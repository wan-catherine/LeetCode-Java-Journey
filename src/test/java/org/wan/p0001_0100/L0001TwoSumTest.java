package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class L0001TwoSumTest {

    L0001TwoSum twoSun = new L0001TwoSum();

    @ParameterizedTest(name = "nums={0}, target={1}, expected={2}")
    @MethodSource("provideTwoSumTestCases")
    public void twoSumTest(int[] nums, int target, int[] expected) {
        int[] result = twoSun.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> provideTwoSumTestCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3,2,4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }
}