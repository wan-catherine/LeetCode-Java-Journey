package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class L0034FindFirstAndLastPositionOfElementInSortedArrayTest {

    L0034FindFirstAndLastPositionOfElementInSortedArray testClass = new L0034FindFirstAndLastPositionOfElementInSortedArray();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{5,7,7,8,8,10}, 8, new int[]{3, 4}),
                Arguments.of(new int[]{5,7,7,8,8,10}, 6, new int[]{-1, -1}),
                Arguments.of(new int[]{}, 0, new int[]{-1, -1})
        );
    }

    @ParameterizedTest()
    @MethodSource("provideTestCases")
    void searchRange(int[] nums, int target, int[] expected) {
        assertArrayEquals(expected, testClass.searchRange(nums, target));
    }
}