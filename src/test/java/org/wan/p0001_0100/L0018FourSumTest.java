package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L0018FourSumTest {

    L0018FourSum l0018FourSum =  new L0018FourSum();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1,0,-1,0,-2,2}, 0, List.of (
                                List.of(-2,-1,1,2), List.of(-2,0,0,2), List.of(-1,0,0,1)
                        ),
                        Arguments.of(new int[]{2,2,2,2,2}, 8, List.of(List.of(2,2,2,2))),
                        Arguments.of(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296, Collections.EMPTY_LIST)
                ));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void fourSum(int[] nums, int target, List<List<Integer>> expected) {
        assertEquals(expected, l0018FourSum.fourSum(nums, target));
    }
}