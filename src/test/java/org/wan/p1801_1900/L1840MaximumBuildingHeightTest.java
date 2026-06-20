package org.wan.p1801_1900;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class L1840MaximumBuildingHeightTest {

    L1840MaximumBuildingHeight l1840MaximumBuildingHeight = new L1840MaximumBuildingHeight();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(5, new int[][]{{2,1}, {4,1}}, 2),
                Arguments.of(6, new int[][]{}, 5),
                Arguments.of(10, new int[][]{{5,3}, {2,5}, {7,4}, {10,3}}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void topKFrequent(int n, int[][] nums, int expected) {
        assertThat(l1840MaximumBuildingHeight.maxBuilding(n, nums)).isEqualTo(expected);
    }
}