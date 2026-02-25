package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L0042TrappingRainWaterTest {

    L0042TrappingRainWater l0042TrappingRainWater = new L0042TrappingRainWater();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6),
                Arguments.of(new int[]{4,2,0,3,2,5}, 9),
                Arguments.of(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}, 83)
                );
    }

    @ParameterizedTest()
    @MethodSource("provideTestCases")
    void trap(int[] height, int expected) {
        assertEquals(expected, l0042TrappingRainWater.trap(height));
    }
}