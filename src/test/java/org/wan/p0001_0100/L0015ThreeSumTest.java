package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L0015ThreeSumTest {

    L0015ThreeSum threeSum = new L0015ThreeSum();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{-1,0,1,2,-1,-4}, List.of (
                        List.of(-1,-1,2), List.of(-1,0,1)
                ),
                Arguments.of(new int[]{0,0,0}, List.of(List.of(0,0,0))),
                Arguments.of(new int[]{0,1,1}, Collections.EMPTY_LIST)
        ));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void threeSum(int[] nums, List<List<Integer>> expected) {
        assertEquals(expected, threeSum.threeSum(nums));
    }
}