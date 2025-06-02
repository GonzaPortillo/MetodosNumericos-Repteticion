public class AdamsMoulton3 {

    // Función que representa la derivada dy/dt
    public static double f(double t, double y) {
        return Math.pow(y + t, 2) - 1;
    }

    public static void main(String[] args) {
        double h = 0.1;      // Tamaño del paso
        double t0 = 0.0;     // Valor inicial de t
        double y0 = 0.0;     // Valor inicial de y
        double tf = 0.5;     // Valor final de t
        int n = (int) ((tf - t0) / h); // Número de pasos

        double[] t = new double[n + 1];
        double[] y = new double[n + 1];

        // Condiciones iniciales
        t[0] = t0;
        y[0] = y0;

        // Calcular primeros dos valores usando Runge-Kutta de orden 4
        for (int i = 0; i < 2; i++) {
            double k1 = f(t[i], y[i]);
            double k2 = f(t[i] + h / 2, y[i] + h * k1 / 2);
            double k3 = f(t[i] + h / 2, y[i] + h * k2 / 2);
            double k4 = f(t[i] + h, y[i] + h * k3);
            y[i + 1] = y[i] + h * (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            t[i + 1] = t[i] + h;
        }

        // Método Adams-Bashforth-Moulton de 3 pasos
        for (int i = 2; i < n; i++) {
            // Predictor: Adams-Bashforth de 3 pasos
            double fp0 = f(t[i], y[i]);
            double fp1 = f(t[i - 1], y[i - 1]);
            double fp2 = f(t[i - 2], y[i - 2]);
            double yp = y[i] + h * (23 * fp0 - 16 * fp1 + 5 * fp2) / 12;
            double tp = t[i] + h;

            // Corrector: Adams-Moulton de 3 pasos
            double fc0 = f(tp, yp);
            double fc1 = f(t[i], y[i]);
            double fc2 = f(t[i - 1], y[i - 1]);
            double fc3 = f(t[i - 2], y[i - 2]);
            y[i + 1] = y[i] + h * (9 * fc0 + 19 * fc1 - 5 * fc2 + fc3) / 24;
            t[i + 1] = t[i] + h;
        }

        // Mostrar resultados
        System.out.println("t\t\t y(t)");
        for (int i = 0; i <= n; i++) {
            System.out.printf("%.2f\t\t %.6f%n", t[i], y[i]);
        }
    }
}
