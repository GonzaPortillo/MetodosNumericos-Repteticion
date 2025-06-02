public class Ejercicio3 {

    static double g = 9.8;
    static double b = 0.01;

    // Derivada dy/dt = z (velocidad)
    public static double g1(double t, double y, double z) {
        return z;
    }

    // Derivada dz/dt = aceleración con fricción cuadrática
    public static double g2(double t, double y, double z) {
        return -g + b * z * z;
    }

    public static void rungeKutta(double t0, double y0, double z0, double tf, double h) {
        double t = t0;
        double y = y0;
        double z = z0;

        while (t < tf + 1e-6) {
            double k1y = h * g1(t, y, z);
            double k1z = h * g2(t, y, z);

            double k2y = h * g1(t + h / 2, y + k1y / 2, z + k1z / 2);
            double k2z = h * g2(t + h / 2, y + k1y / 2, z + k1z / 2);

            double k3y = h * g1(t + h / 2, y + k2y / 2, z + k2z / 2);
            double k3z = h * g2(t + h / 2, y + k2y / 2, z + k2z / 2);

            double k4y = h * g1(t + h, y + k3y, z + k3z);
            double k4z = h * g2(t + h, y + k3y, z + k3z);

            y += (k1y + 2 * k2y + 2 * k3y + k4y) / 6.0;
            z += (k1z + 2 * k2z + 2 * k3z + k4z) / 6.0;
            t += h;

            System.out.printf("%.2f \t%.6f \t%.6f%n", t, y, z);
        }
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio 3 - Caída libre con fricción");
        System.out.println("t \ty \tz");
        rungeKutta(0, 0, 0, 5, 1);
    }
}
