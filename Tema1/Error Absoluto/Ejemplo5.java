import java.util.Scanner;

public class Ejemplo5 {
    public static double errorAbsoluto(double valorReal, double valorAproximado) {
        return Math.abs(valorReal - valorAproximado);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor real: ");
        double real = scanner.nextDouble();

        System.out.print("Ingrese el valor aproximado: ");
        double aprox = scanner.nextDouble();

        System.out.printf("Error Absoluto: %.4f%n", errorAbsoluto(real, aprox));
    }
}
