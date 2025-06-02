public class Ejercicio2 {

    static double k = 0.1;
    static double Tamb = 20.0;

    public static double f(double t, double T) {
        return -k * (T - Tamb);
    }

    public static void rungeKutta(double t0, double T0, double tf, double h) {
        double t = t0;
        double T = T0;

        while (t < tf + 1e-6) {
            double k1 = h * f(t, T);
            double k2 = h * f(t + h / 2.0, T + k1 / 2.0);
            double k3 = h * f(t + h / 2.0, T + k2 / 2.0);
            double k4 = h * f(t + h, T + k3);

            T += (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;
            t += h;

            System.out.printf("%.2f \t%.6f%n", t, T);
        }
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio 2 - Enfriamiento");
        System.out.println("t \tT");
        rungeKutta(0, 90, 5, 1);
    }
}
