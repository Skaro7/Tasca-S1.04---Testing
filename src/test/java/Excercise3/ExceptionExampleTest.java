package Excercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionExampleTest {
    @Test
    public void testThrowsArrayIndexOutOfBoundsException() {
        int[] array = {1, 2, 3};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            ExceptionExample.accessInvalidArrayIndex(array, 5);
        });
    }

    @Test
    public void testDoesNotThrowExceptionWithValidIndex() {
        int[] array = {1, 2, 3};

        ExceptionExample.accessInvalidArrayIndex(array, 1);
    }
}
