package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L0004MedianOfTwoSortedArraysTest {

    L0004MedianOfTwoSortedArrays medianOfTwoSortedArrays = new L0004MedianOfTwoSortedArrays();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1,3}, new int[]{2}, 2.00000),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.50000)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void findMedianSortedArrays(int[] nums1, int[] nums2, double expected) {
        double area = medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, area);
    }
}