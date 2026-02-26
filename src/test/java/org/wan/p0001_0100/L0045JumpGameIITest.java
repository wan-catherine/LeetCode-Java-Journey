package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L0045JumpGameIITest {

    L0045JumpGameII l0045JumpGameII = new L0045JumpGameII();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{2,3,1,1,4}, 2),
                Arguments.of(new int[]{2,3,0,1,4}, 2),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{1,2,1,1,1}, 3)
        );
    }

    @ParameterizedTest()
    @MethodSource("provideTestCases")
    void jump(int[] nums, int expected) {
        assertEquals(expected, l0045JumpGameII.jump(nums));
    }
}