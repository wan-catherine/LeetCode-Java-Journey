package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L0016ThreeSumClosestTest {

    L0016ThreeSumClosest threeSum  = new L0016ThreeSumClosest();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{-1,2,1,-4}, 1, 2),
                Arguments.of(new int[]{0,0,0}, 1, 0),
                Arguments.of(new int[]{7,8,9}, -1, 24)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void threeSumClosest(int[] nums, int target, int expected) {
        assertEquals(expected, threeSum.threeSumClosest(nums, target));
    }
}