public class RungeKutta {

    // Función f(x, y) = x + y
    public static double f(double x, double y) {
        return x + y;
    }

    public static void main(String[] args) {
        double x = 0.0;
        double y = 1.0;
        double xFinal = 0.4;
        double h = 0.2;

        int n = (int) ((xFinal - x) / h);

        System.out.println("x\t\ty");
        System.out.printf("%.1f\t\t%.5f\n", x, y);

        for (int i = 1; i <= n; i++) {
            double k1 = f(x, y);
            double k2 = f(x + h / 2.0, y + (h / 2.0) * k1);
            double k3 = f(x + h / 2.0, y + (h / 2.0) * k2);
            double k4 = f(x + h, y + h * k3);

            // Cálculo de y en el siguiente paso
            double yNext = y + (h / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);

            // Avanzar al siguiente punto
            x += h;
            y = yNext;

            System.out.printf("%.1f\t\t%.5f\n", x, y);
        }
    }
}
