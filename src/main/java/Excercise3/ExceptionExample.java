package Excercise3;

public class ExceptionExample {
    public static void accessInvalidArrayIndex(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int value = array[index];
    }
}

