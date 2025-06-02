import java.util.Scanner;

public class RungeKutta {

    // Define la función derivada f(x, y)
    public static double f(double x, double y) {
        return x + y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor inicial de x (x0): ");
        double x0 = scanner.nextDouble();

        System.out.print("Ingrese el valor inicial de y (y0): ");
        double y0 = scanner.nextDouble();

        System.out.print("Ingrese el valor final de x: ");
        double xf = scanner.nextDouble();

        System.out.print("Ingrese el tamaño del paso h: ");
        double h = scanner.nextDouble();

        int n = (int) ((xf - x0) / h);

        System.out.println("x\t\ty");
        // Imprimir valores iniciales
        System.out.printf("%.2f\t%.6f%n", x0, y0);

        for (int i = 1; i <= n; i++) {
            double k1 = f(x0, y0);
            double k2 = f(x0 + h / 2.0, y0 + (h / 2.0) * k1);
            double k3 = f(x0 + h / 2.0, y0 + (h / 2.0) * k2);
            double k4 = f(x0 + h, y0 + h * k3);

            double y1 = y0 + (h / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);

            x0 += h;
            y0 = y1;

            System.out.printf("%.2f\t%.6f%n", x0, y0);
        }

        scanner.close();
    }
}
