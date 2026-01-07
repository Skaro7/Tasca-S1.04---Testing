package Excercise3;

public class Main {
    public static void accessInvalidArrayIndex(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int value = array[index];
    }

    public static void main(String[] args) {
        System.out.println("Testing ArrayIndexOutOfBoundsException:");
        System.out.println("======================================");

        int[] testArray = {10, 20, 30, 40, 50};

        System.out.println("Array has " + testArray.length + " elements (indices 0 to " + (testArray.length - 1) + ")");
        System.out.println();

        try {
            System.out.println("Test 1: Accessing valid index 2...");
            accessInvalidArrayIndex(testArray, 2);
            System.out.println("✓ Successfully accessed element at index 2");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("✗ Unexpected exception at valid index!");
        }

        System.out.println();

        try {
            System.out.println("Test 2: Accessing invalid index 10...");
            accessInvalidArrayIndex(testArray, 10);
            System.out.println("✗ No exception thrown for invalid index!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("✓ Correctly caught ArrayIndexOutOfBoundsException for index 10");
        }

        System.out.println();

        try {
            System.out.println("Test 3: Accessing negative index -1...");
            accessInvalidArrayIndex(testArray, -1);
            System.out.println("✗ No exception thrown for negative index!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("✓ Correctly caught ArrayIndexOutOfBoundsException for index -1");
        }

        System.out.println();
        System.out.println("All tests completed!");
    }
}

