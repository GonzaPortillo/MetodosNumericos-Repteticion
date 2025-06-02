public class AdamsBashforthError {

    // Derivada dy/dt = f(t, y)
    public static double f(double t, double y) {
        return y; // Ejemplo: dy/dt = y
    }

    public static void main(String[] args) {
        double h = 0.2;     // Tamaño del paso
        double t0 = 0.0;    // Valor inicial de t
        double y0 = 1.0;    // Valor inicial de y
        double tf = 1.0;    // Valor final de t
        int n = (int) ((tf - t0) / h); // Número de pasos

        double[] t = new double[n + 1];
        double[] y = new double[n + 1];
        double[] exacto = new double[n + 1];

        t[0] = t0;
        y[0] = y0;
        exacto[0] = Math.exp(t0);

        // Uso de Runge-Kutta 4 para obtener los primeros 4 valores
        for (int i = 0; i < 3; i++) {
            double k1 = f(t[i], y[i]);
            double k2 = f(t[i] + h / 2, y[i] + h * k1 / 2);
            double k3 = f(t[i] + h / 2, y[i] + h * k2 / 2);
            double k4 = f(t[i] + h, y[i] + h * k3);
            y[i + 1] = y[i] + h * (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            t[i + 1] = t[i] + h;
            exacto[i + 1] = Math.exp(t[i + 1]);
        }

        // Método de Adams-Bashforth de 4 pasos
        for (int i = 3; i < n; i++) {
            y[i + 1] = y[i] + h * (
                    55 * f(t[i], y[i])
                  - 59 * f(t[i - 1], y[i - 1])
                  + 37 * f(t[i - 2], y[i - 2])
                  - 9 * f(t[i - 3], y[i - 3])
            ) / 24;

            t[i + 1] = t[i] + h;
            exacto[i + 1] = Math.exp(t[i + 1]);
        }

        // Mostrar resultados
        System.out.println("Paso\t t\t\t y (AB4)\t y (Exacto)\t Error Abs.");
        for (int i = 0; i <= n; i++) {
            double error = Math.abs(exacto[i] - y[i]);
            System.out.printf("%d\t %.2f\t %.6f\t %.6f\t %.6f%n",
                    i, t[i], y[i], exacto[i], error);
        }

        // Error absoluto y relativo en t = 1
        double errorFinal = Math.abs(exacto[n] - y[n]);
        System.out.printf("%nError absoluto en t = 1: %.6f%n", errorFinal);
        System.out.printf("Error relativo en t = 1: %.6f%%%n", (errorFinal / exacto[n]) * 100);
    }
}
