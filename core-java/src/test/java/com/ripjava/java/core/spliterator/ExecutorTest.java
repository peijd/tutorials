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
    @Test
    public void test_countAuthorsWithSpliterator() {
        Article article = new Article(Arrays.asList(new Author("Ahmad", 0),
                new Author("a", 0),
                new Author("b", 1),
                new Author("c", 1),
                new Author("d", 0),
                new Author("e", 1),
                new Author("f", 0),
                new Author("g", 1),
                new Author("h", 0),
                new Author("i", 1),
                new Author("g", 0),
                new Author("k", 0),
                new Author("l", 1),
                new Author("m", 0),
                new Author("n", 1),
                new Author("p", 0),
                new Author("q", 1),
                new Author("r", 0),
                new Author("s", 1),
                new Author("t", 0),
                new Author("r", 0),
                new Author("s", 1)), 0);
        Stream<Author> stream = article.getListOfAuthors().stream();
        Spliterator<Author> spliterator = new RelatedAuthorSpliterator(article.getListOfAuthors());
        Stream<Author> stream2 = StreamSupport.stream(spliterator, true);
        assertThat(Executor.countAuthors(stream2.parallel()), equalTo(9));
    }
    @Test
    public  void test_countAuthors(){
        Article article = new Article(Arrays.asList(new Author("Ahmad", 0),
                new Author("a", 0),
                new Author("b", 1),
                new Author("c", 1),
                new Author("d", 0),
                new Author("e", 1),
                new Author("f", 0),
                new Author("g", 1),
                new Author("h", 0),
                new Author("i", 1),
                new Author("g", 0),
                new Author("k", 0),
                new Author("l", 1),
                new Author("m", 0),
                new Author("n", 1),
                new Author("p", 0),
                new Author("q", 1),
                new Author("r", 0),
                new Author("s", 1),
                new Author("t", 0),
                new Author("r", 0),
                new Author("s", 1)), 0);
        Stream<Author> stream = article.getListOfAuthors().stream();
        assertThat(Executor.countAuthors(stream), equalTo(9));
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
