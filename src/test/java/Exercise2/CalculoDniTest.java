package Exercise2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculoDniTest {

    @ParameterizedTest
    @MethodSource
    void testCalculateValidLetter(int dni, char expected) {
        assertEquals(expected, CalculoDni.obtenerLetraDNI(dni));
    }
    static Stream<Arguments> testCalculateValidLetter() {
        return Stream.of(
                Arguments.of(0, 'T'),
                Arguments.of(1, 'R'),
                Arguments.of(2, 'W'),
                Arguments.of(3, 'A'),
                Arguments.of(4, 'G'),
                Arguments.of(5, 'M'),
                Arguments.of(6, 'Y'),
                Arguments.of(7, 'F'),
                Arguments.of(8, 'P'),
                Arguments.of(9, 'D'),
                Arguments.of(10, 'X')
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100, -9999999})
    void testCalculateNegativeDNILetter(int invalidNumber) {
        assertThrows(IllegalArgumentException.class, () -> {
            CalculoDni.obtenerLetraDNI(invalidNumber);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1000000000, 777777777, 785034879})
    void testCalculateTooBigDNILetter(int invalidNumber) {
        assertThrows(IllegalArgumentException.class, () -> {
            CalculoDni.obtenerLetraDNI(invalidNumber);
        });
    }


}