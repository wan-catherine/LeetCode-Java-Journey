package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class L0011ContainerWithMostWaterTest {

    L0011ContainerWithMostWater containerWithMostWater = new L0011ContainerWithMostWater();

    @ParameterizedTest
    @MethodSource("provideTwoSumTestCases")
    void maxArea(int[] height, int target) {
        int area = containerWithMostWater.maxArea(height);
        assertEquals(target, area);
    }

    static Stream<Arguments> provideTwoSumTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                Arguments.of(new int[]{1, 1}, 1)
        );
    }
}