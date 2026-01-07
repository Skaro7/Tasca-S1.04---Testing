package Excercise2;

public class Main {
    public static void main(String[] args) {
        int[] testDnis = {12345678, 87654321, 11222333, 44555666, 77888999,
                99887766, 55443322, 11223344, 22334455, 99999999};

        for (int dni : testDnis) {
            char letter = CalculoDni.obtenerLetraDNI(dni);
            System.out.println(dni + " -> " + letter);
        }
    }
}
