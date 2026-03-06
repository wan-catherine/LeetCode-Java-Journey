package org.wan.p0001_0100;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L0074SearchA2DMatrixTest {

    L0074SearchA2DMatrix search = new L0074SearchA2DMatrix();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3, true),
                Arguments.of(new int[][]{{1}}, 1, true),
                Arguments.of(new int[][]{{1,3}}, 3, true)
        );
    }

    @ParameterizedTest()
    @MethodSource("provideTestCases")
    void searchMatrix(int[][] matrix, int target, boolean expected) {
        assertEquals(expected, search.searchMatrix(matrix, target));
    }
}