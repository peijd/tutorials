package com.ripjava.java.core.regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexTest {

    @Test
    public void test_SimpleRegexMatches() {
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher("foo");

        assertTrue(matcher.find());
    }

    @Test
    public void test_SimpleRegexMatchesTwice() {
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher("foofoo");
        int matches = 0;
        while (matcher.find()){
            matches++;
        }

        assertEquals(matches, 2);
    }

    @Test
    public void test_MatchesWithDotMatch() {
        int matches = runTest(".", "foo");

        assertTrue(matches == 3);
    }

    @Test
    public void test_MatchesOnceWithDotMatch() {
        int matches= runTest("foo.", "foofoo");

        assertEquals(matches, 1);
    }

    @Test
    public void test_ORSetMatchesAny() {
        int matches = runTest("[abc]", "b");

        assertEquals(matches, 1);
    }

    @Test
    public void test_ORSetMatchesAnyAndAll() {
        int matches = runTest("[abc]", "cab");

        assertEquals(matches, 3);
    }

    @Test
    public void test_ORSetMatchesAllCombinations() {
        int matches = runTest("[bcr]at", "bat cat rat");

        assertEquals(matches, 3);
    }

    @Test
    public void test_NORSetMatchesNon() {
        int matches = runTest("[^abc]", "g");

        assertTrue(matches > 0);
    }

    @Test
    public void test_NORSetMatchesExceptElements() {
        int matches = runTest("[^bcr]at", "sat cat eat");

        assertTrue(matches == 2);
    }

    @Test
    public void test_UpperCaseRangeMatchesUpperCase() {
        int matches = runTest(
                "[A-Z]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 2);
    }

    @Test
    public void test_LowerCaseRangeMatchesLowerCase() {
        int matches = runTest(
                "[a-z]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 26);
    }

    @Test
    public void test_BothLowerAndUpperCaseRangeMatchesAllLetters() {
        int matches = runTest(
                "[a-zA-Z]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 28);
    }

    @Test
    public void test_NumberRangeMatchesAccurately() {
        int matches = runTest(
                "[1-5]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 2);
    }

    @Test
    public void test_NumberRangeMatchesAccurately2(){
        int matches = runTest(
                "[30-35]", "Two Uppercase alphabets 34 overall");

        assertEquals(matches, 1);
    }

    @Test
    public void test_TwoSetsMatchesUnion() {
        int matches = runTest("[1-3[7-9]]", "123456789");

        assertEquals(matches, 6);
    }

    @Test
    public void test_TwoSetsMatchesIntersection() {
        int matches = runTest("[1-6&&[3-9]]", "123456789");

        assertEquals(matches, 4);
    }
    @Test
    public void test_SetWithSubtractionMatchesAccurately() {
        int matches = runTest("[0-9&&[^2468]]", "123456789");

        assertEquals(matches, 5);
    }

    @Test
    public void test_DigitsMatches() {
        int matches = runTest("\\d", "123");

        assertEquals(matches, 3);
    }

    @Test
    public void test_NonDigitsMatches() {
        int matches = runTest("\\D", "a6c");

        assertEquals(matches, 2);
    }

    @Test
    public void test_WhiteSpaceMatches() {
        int matches = runTest("\\s", "a c");

        assertEquals(matches, 1);
    }

    @Test
    public void test_NonWhiteSpaceMatches() {
        int matches = runTest("\\S", "a c");

        assertEquals(matches, 2);
    }

    @Test
    public void test_WordCharacterMatches() {
        int matches = runTest("\\w", "hi!");

        assertEquals(matches, 2);
    }

    @Test
    public void test_NonWordCharacterMatches() {
        int matches = runTest("\\W", "hi!");

        assertEquals(matches, 1);
    }

    @Test
    public void test_ZeroOrOneQuantifierMatches() {
        int matches = runTest("\\a?", "hi");

        assertEquals(matches, 3);
    }

    @Test
    public void test_ZeroOrOneQuantifierMatches2() {
        int matches = runTest("\\a{0,1}", "hi");

        assertEquals(matches, 3);
    }

    @Test
    public void test_ZeroOrManyQuantifierMatches() {
        int matches = runTest("\\a*", "hi");

        assertEquals(matches, 3);
    }
    @Test
    public void test_ZeroOrManyQuantifierMatches2() {
        int matches = runTest("\\a{0,}", "hi");

        assertEquals(matches, 3);
    }
    @Test
    public void test_OneOrManyQuantifierMatches() {
        int matches = runTest("\\a+", "hi");

        assertEquals(matches, 0);
    }

    @Test
    public void test_OneOrManyQuantifierMatches2() {
        int matches = runTest("\\a{1,}", "hi");

        assertEquals(matches, 0);
    }
    @Test
    public void test_BraceQuantifierMatches() {
        int matches = runTest("a{3}", "aaaaaa");

        assertEquals(matches, 2);
    }

    @Test
    public void test_BraceQuantifierFailsToMatch() {
        int matches = runTest("a{3}", "aa");

        assertEquals(matches, 0);
    }
    @Test
    public void test_BraceQuantifierWithRangeMatches() {
        int matches = runTest("a{2,3}", "aaaa");

        assertEquals(matches, 1);
    }

    @Test
    public void test_BraceQuantifierWithRangeMatchesLazily() {
        int matches = runTest("a{2,3}?", "aaaa");

        assertEquals(matches, 2);
    }
    @Test
    public void test_CapturingGroupMatches() {
        int matches = runTest("(\\d\\d)", "12");

        assertEquals(matches, 1);
    }

    @Test
    public void test_CapturingGroupMatches2() {
        int matches = runTest("(\\d\\d)", "1212");

        assertEquals(matches, 2);
    }

    @Test
    public void test_CapturingGroupMatchesWithBackReference() {
        int matches = runTest("(\\d\\d)\\1", "1212");

        assertEquals(matches, 1);
    }

    @Test
    public void test_CapturingGroupMatches3() {
        int matches = runTest("(\\d\\d)(\\d\\d)", "1212");

        assertEquals(matches, 1);
    }

    @Test
    public void test_CapturingGroupMatchesWithBackReference2() {
        int matches = runTest("(\\d\\d)\\1\\1\\1", "12121212");

        assertEquals(matches, 1);
    }

    @Test
    public void test_CapturingGroupAndWrongInputMatchFailsWithBackReference() {
        int matches = runTest("(\\d\\d)\\1", "1213");

        assertFalse(matches > 0);

    }
    @Test
    public void test_MatchesAtBeginning() {
        int matches = runTest("^dog", "dogs are friendly");
        int matches2 = runTest("^dog", "are dogs are friendly?");
        assertTrue(matches > 0);
        assertFalse(matches2 > 0);
    }


    @Test
    public void test_MatchesAtEnd() {
        int matches = runTest("dog$", "Man's best friend is a dog");
        int matches2 = runTest("dog$", "is a dog man's best friend?");

        assertTrue(matches > 0);
        assertFalse(matches2 > 0);


    }


    @Test
    public void test_MatchesAtWordBoundary() {
        int matches = runTest("\\bdog\\b", "a dog is friendly");
        int matches2 = runTest("\\bdog\\b", "dog is man's best friend");

        assertTrue(matches > 0);
        assertTrue(matches > 0);
    }


    @Test
    public void test_MatchesAtWordAndNonBoundary() {
        int matches = runTest("\\bdog\\b", "snoop dogg is a rapper");

        int matches2 = runTest("\\bdog\\B", "snoop dogg is a rapper");

        assertFalse(matches > 0);
        assertTrue(matches2 > 0);
    }

    @Test
    public void  test_RegexWithoutCanonEqMatchFailsOnEquivalentUnicode() {
        int matches = runTest("\u00E9", "\u0065\u0301");

        assertFalse(matches > 0);
    }

    @Test
    public void test_RegexWithCanonEqMatchesOnEquivalentUnicode() {
        int matches = runTest("\u00E9", "\u0065\u0301", Pattern.CANON_EQ);

        assertTrue(matches > 0);
    }


    @Test
    public void test_RegexWithDefaultMatcherMatchFailsOnDifferentCases() {
        int matches = runTest("dog", "This is a Dog");

        assertFalse(matches > 0);
    }

    @Test
    public void test_RegexWithCaseInsensitiveMatcherMatchesOnDifferentCases() {
        int matches = runTest(
                "dog", "This is a Dog", Pattern.CASE_INSENSITIVE);

        assertTrue(matches > 0);
    }

    @Test
    public void test_RegexWithEmbeddedCaseInsensitiveMatcherMatchesOnDifferentCases() {
        int matches = runTest("(?i)dog", "This is a Dog");

        assertTrue(matches > 0);
    }

    @Test
    public void test_RegexWithCommentsMatchFailsWithoutFlag() {
        int matches = runTest(
                "dog$  #check for word dog at end of text", "This is a dog");

        assertFalse(matches > 0);
    }
    @Test
    public void test_RegexWithCommentsMatchesWithFlag() {
        int matches = runTest(
                "dog$  #check end of text","This is a dog", Pattern.COMMENTS);

        assertTrue(matches > 0);
    }

    @Test
    public void test_RegexWithCommentsMatchesWithEmbeddedFlag() {
        int matches = runTest(
                "(?x)dog$  #check end of text", "This is a dog");

        assertTrue(matches > 0);
    }

    @Test
    public void test_RegexWithLineTerminatorMatchFails() {
        Pattern pattern = Pattern.compile("(.*)");
        Matcher matcher = pattern.matcher(
                "this is a text" + System.getProperty("line.separator")
                        + " continued on another line");
        matcher.find();

        assertEquals("this is a text", matcher.group(1));
    }



    @Test
    public void test_RegexMatchesWithoutLiteralFlag() {
        int matches = runTest("(.*)", "text");

        assertTrue(matches > 0);
    }
    @Test
    public void test_RegexMatchFailsWithLiteralFlag() {
        int matches = runTest("(.*)", "text", Pattern.LITERAL);

        assertFalse(matches > 0);
    }

    @Test
    public void test_RegexMatchesWithLiteralFlag() {
        int matches = runTest("(.*)", "text(.*)", Pattern.LITERAL);

        assertTrue(matches > 0);
    }

    @Test
    public void test_RegexMatchFailsWithoutMultilineFlag() {
        int matches = runTest(
                "dog$", "This is a dog" + System.getProperty("line.separator")
                        + "this is a fox");

        assertFalse(matches > 0);
    }

    @Test
    public void test_RegexMatchesWithMultilineFlag() {
        int matches = runTest(
                "dog$", "This is a dog" + System.getProperty("line.separator")
                        + "this is a fox", Pattern.MULTILINE);

        assertTrue(matches > 0);
    }

    @Test
    public void test_Regex_whenMatchesWithEmbeddedMultilineFlag() {
        int matches = runTest(
                "(?m)dog$", "This is a dog" + System.getProperty("line.separator")
                        + "this is a fox");

        assertTrue(matches > 0);
    }

    @Test
    public void test_RegexWithLineTerminatorMatchesWithDotall() {
        Pattern pattern = Pattern.compile("(.*)", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(
                "this is a text" + System.getProperty("line.separator")
                        + " continued on another line");
        matcher.find();
        assertEquals(
                "this is a text" + System.getProperty("line.separator")
                        + " continued on another line", matcher.group(1));
    }

    @Test
    public void test_RegexWithLineTerminatorMatchesWithEmbeddedDotall() {

        Pattern pattern = Pattern.compile("(?s)(.*)");
        Matcher matcher = pattern.matcher(
                "this is a text" + System.getProperty("line.separator")
                        + " continued on another line");
        matcher.find();

        assertEquals(
                "this is a text" + System.getProperty("line.separator")
                        + " continued on another line", matcher.group(1));
    }


    @Test
    public void test_MatchGetsIndices() {
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher = pattern.matcher("This dog is mine");
        matcher.find();

        assertEquals(5, matcher.start());
        assertEquals(8, matcher.end());
    }

    @Test
    public void test_StudyMethodsWork() {
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher = pattern.matcher("dogs are friendly");

        assertTrue(matcher.lookingAt());
        assertFalse(matcher.matches());
    }

    @Test
    public void test_StudyMethodWork2() {
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher = pattern.matcher("dog");

        assertTrue(matcher.matches());
    }

    @Test
    public void test_ReplaceFirstWorks() {
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher = pattern.matcher(
                "dogs are domestic animals, dogs are friendly");
        String newStr = matcher.replaceFirst("cat");

        assertEquals(
                "cats are domestic animals, dogs are friendly", newStr);
    }

    @Test
    public void test_ReplaceAllWorks() {
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher = pattern.matcher(
                "dogs are domestic animals, dogs are friendly");
        String newStr = matcher.replaceAll("cat");

        assertEquals("cats are domestic animals, cats are friendly", newStr);
    }

    public static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    public static int runTest(String regex, String text, int flags) {
        Pattern pattern = Pattern.compile(regex, flags);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()){
            matches++;
        }
        return matches;
    }
}
