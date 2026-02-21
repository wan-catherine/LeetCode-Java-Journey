package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L0033SearchInRotatedSortedArrayTest {

    L0033SearchInRotatedSortedArray testClass = new L0033SearchInRotatedSortedArray();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{4,5,6,7,0,1,2}, 0, 4),
                Arguments.of(new int[]{4,5,6,7,0,1,2}, 3, -1),
                Arguments.of(new int[]{1}, 0, -1),
                Arguments.of(new int[]{5,1,3}, 5, 0)
        );
    }

    @ParameterizedTest()
    @MethodSource("provideTestCases")
    void search(int[] nums, int target, int expected) {
        assertEquals(expected, testClass.search(nums, target));
    }
}