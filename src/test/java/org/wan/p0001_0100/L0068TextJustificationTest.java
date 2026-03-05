package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L0068TextJustificationTest {

    L0068TextJustification test = new L0068TextJustification();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16, List.of(
                    "This    is    an", "example  of text", "justification.  "
                )),
                Arguments.of(new String[] {"What","must","be","acknowledgment","shall","be"}, 16, List.of("What   must   be",
                        "acknowledgment  ",
                        "shall be        ")),
                Arguments.of(new String[] {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20
                , List.of("Science  is  what we",
                                "understand      well",
                                "enough to explain to",
                                "a  computer.  Art is",
                                "everything  else  we",
                                "do                  "))
                );
    }

    @ParameterizedTest()
    @MethodSource("provideTestCases")
    void fullJustify(String[] testCase, int m, List<String> expected) {
        assertEquals(expected, test.fullJustify(testCase, m));
    }
}