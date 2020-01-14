package com.ripjava.java.core.spliterator;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ExecutorTest {
    Article article;
    Stream<Author> stream;
    Spliterator<Author> spliterator;

    @BeforeEach
    public void init() {
        article = new Article(Arrays.asList(new Author("Ahmad", 0), new Author("Eugen", 0), new Author("Alice", 1),
                new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0),
                new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0),
                new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1),
                new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1),
                new Author("Mike", 0), new Author("Michał", 0), new Author("Loredana", 1)), 0);
        stream = article.getListOfAuthors().stream();

        spliterator = new RelatedAuthorSpliterator(article.getListOfAuthors());
    }

    @Test
    public void givenAstreamOfAuthors_whenProcessedInParallelWithCustomSpliterator_coubtProducessRightOutput() {
        Stream<Author> stream2 = StreamSupport.stream(spliterator, true);
        assertThat(Executor.countAutors(stream2.parallel()), equalTo(9));
    }

    @Test
    public void test_TrySplit() {
        Spliterator<Article> split1 = Executor.generateElements().spliterator();
        Spliterator<Article> split2 = split1.trySplit();
        assertThat(new Task(split1).call(), containsString( Executor.generateElements().size() / 2 + ""));
        assertThat(new Task(split2).call(), containsString(Executor.generateElements().size() / 2 + ""));
    }

    @Test
    public void test_EstimateSize() {
        Spliterator<Article> split1 = Executor.generateElements().spliterator();
        assertThat(split1.estimateSize(), equalTo(Executor.generateElements().size() * 1L));
        split1.trySplit();
        assertThat(split1.estimateSize(), equalTo(Executor.generateElements().size() / 2L));
    }


    @Test
    public void test_Characteristics() {
        Spliterator<Article> split1 = Executor.generateElements().spliterator();
        // 16464 = 0x4050 = 0x4000+0x0010+0x0040=SUBSIZED+SIZED+ORDERED
        assertThat(split1.characteristics(), equalTo(Spliterator.SUBSIZED | Spliterator.SIZED | Spliterator.ORDERED));
    }
    @Test
    public void  test_HasCharacteristics(){
        Spliterator<Article> split1 = Executor.generateElements().spliterator();
        assertThat(split1.hasCharacteristics(Spliterator.CONCURRENT), equalTo(false));
        assertThat(split1.hasCharacteristics(Spliterator.SUBSIZED), equalTo(true));
    }
}
