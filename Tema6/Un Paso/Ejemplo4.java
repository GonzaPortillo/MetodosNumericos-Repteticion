public class MetodoEuler {

    // Función que representa la derivada dy/dx = f(x, y)
    public static double f(double x, double y) {
        return 2 * x * y;
    }

    // Solución exacta para comparar: y(x) = e^(x^2)
    public static double solucionExacta(double x) {
        return Math.exp(x * x);
    }

    public static void main(String[] args) {
        // Datos iniciales
        double x0 = 0;
        double y0 = 1;
        double h = 0.2;
        int n = 5;

        double x = x0;
        double y = y0;

        System.out.println("Paso\t x\t\t y_aprox\t y_real\t\t error");
        for (int i = 0; i <= n; i++) {
            double yReal = solucionExacta(x);
            double error = Math.abs(y - yReal);
            System.out.printf("%d\t %.2f\t %.6f\t %.6f\t %.6f%n", i, x, y, yReal, error);

            // Aplicamos el método de Euler
            y = y + h * f(x, y);
            x = x + h;
        }
    }
}

