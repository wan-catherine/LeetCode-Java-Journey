package org.wan.p0301_0400;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class L0347TopKFrequentElementsTest {

    L0347TopKFrequentElements l0217ContainsDuplicate = new L0347TopKFrequentElements();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1,1,1,2,2,3}, 2, new int[]{1,2}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1,2,1,2,1,2,3,1,3,2}, 2, new int[]{1,2})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void topKFrequent(int[] nums, int k, int[] expected) {
        assertArrayEquals(expected, l0217ContainsDuplicate.topKFrequent(nums, k));
        assertThat(l0217ContainsDuplicate.topKFrequent_minHeap(nums, k)).containsExactlyInAnyOrder(expected);
    }
}