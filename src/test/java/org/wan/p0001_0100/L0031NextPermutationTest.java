package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class L0031NextPermutationTest {

    L0031NextPermutation test = new L0031NextPermutation();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, new int[]{1,3,2}),
                Arguments.of(new int[]{3,2,1}, new int[]{1,2,3}),
                Arguments.of(new int[]{1,1,5}, new int[]{1,5,1}),
                Arguments.of(new int[]{5,1,1}, new int[]{1,1,5})
        );
    }

    @ParameterizedTest()
    @MethodSource("provideTestCases")
    void nextPermutation(int[] nums, int[] expected) {
        test.nextPermutation(nums);
        assertArrayEquals(expected, nums);
    }
}