package Excercise2;

public class CalculoDni {
    public static char obtenerLetraDNI(int dni) {
        if (dni < 0 || dni > 99999999) {
            throw new IllegalArgumentException("Invalid DNI number");
        }
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
                'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letras[dni % 23];
    }
}
