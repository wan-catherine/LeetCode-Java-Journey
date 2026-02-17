package org.wan.p0001_0100;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class L0014LongestCommonPrefixTest {

    L0014LongestCommonPrefix longestCommonPrefix = new L0014LongestCommonPrefix();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new String[]{"flower","flow","flight"}, "fl"),
                Arguments.of(new String[]{"dog","racecar","car"}, ""),
                Arguments.of(new String[]{"ab", "a"}, "a"),
                Arguments.of(new String[]{"flower"}, "flower")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void longestCommonPrefixTest(String[] strs, String expected) {
        assertEquals(expected, longestCommonPrefix.longestCommonPrefix(strs));
    }
}