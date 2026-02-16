package org.wan.p0201_0300;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class L0217ContainsDuplicateTest {

    L0217ContainsDuplicate l0217ContainsDuplicate = new L0217ContainsDuplicate();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,1}, true),
                Arguments.of(new int[]{1,2,3,4}, false),
                Arguments.of(new int[]{1,1,1,3,3,4,3,2,4,2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void containsDuplicateTest(int[] nums, boolean expected) {
        assertEquals(expected, l0217ContainsDuplicate.containsDuplicate(nums));
    }
}