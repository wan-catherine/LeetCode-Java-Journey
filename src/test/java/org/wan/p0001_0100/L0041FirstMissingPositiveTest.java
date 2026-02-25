package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L0041FirstMissingPositiveTest {

    L0041FirstMissingPositive l0041FirstMissingPositive = new L0041FirstMissingPositive();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1,2,0}, 3),
                Arguments.of(new int[]{3,4,-1,1}, 2),
                Arguments.of(new int[]{7,8,9,11,12}, 1)
        );
    }

    @ParameterizedTest()
    @MethodSource("provideTestCases")
    void firstMissingPositive(int[] nums, int expected) {
        assertEquals(expected, l0041FirstMissingPositive.firstMissingPositive(nums));
    }
}