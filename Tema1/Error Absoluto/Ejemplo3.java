public class Ejemplo3 {
    public static double errorAbsoluto(double real, double aprox) {
        return Math.abs(real - aprox);
    }

    public static void main(String[] args) {
        System.out.println("Error Absoluto: " + errorAbsoluto(98.7, 97.9));
    }
}
