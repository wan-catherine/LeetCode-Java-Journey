package org.wan.p3601_3700;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class L3614ProcessStringWithSpecialOperationsIITest {
    L3614ProcessStringWithSpecialOperationsII l3614ProcessStringWithSpecialOperationsII = new L3614ProcessStringWithSpecialOperationsII();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("a#b%*", 1, 'a'),
                Arguments.of("cd%#*#", 3, 'd'),
                Arguments.of("z*#", 0, '.'),
                Arguments.of("%edx#n#lkc####uom##qg#%#b#ek%##%%ocr#m%#fv%i%%#n#u%%#n#q%v#rwvd##t###%#%%%o*##r#gr*gz#dm%ez", 4780, 'd')
                );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void containsDuplicateTest(String s, int k, char expected) {
        assertEquals(expected, l3614ProcessStringWithSpecialOperationsII.processStr(s, k));
    }
}