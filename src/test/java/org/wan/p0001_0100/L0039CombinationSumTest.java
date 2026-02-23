package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L0039CombinationSumTest {

    L0039CombinationSum testClass = new L0039CombinationSum();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{2,3,6,7}, 7, Arrays.asList(Arrays.asList(2,2,3), Arrays.asList(7))),
                Arguments.of(new int[]{2,3,5}, 8, Arrays.asList(Arrays.asList(2,2,2,2), Arrays.asList(2,3,3), Arrays.asList(3,5))),
                Arguments.of(new int[]{2}, 1, List.of())
        );
    }

    @ParameterizedTest()
    @MethodSource("provideTestCases")
    void combinationSum(int[] candidates, int target, List<List<Integer>> expected) {
        assertEquals(expected, testClass.combinationSum(candidates, target));
    }
}