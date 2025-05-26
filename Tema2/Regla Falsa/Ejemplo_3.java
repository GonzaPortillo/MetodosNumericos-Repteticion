public class ReglaFalsa3 {
    public static double f(double x) {
        return Math.cos(x) - x;
    }

    public static void main(String[] args) {
        double a = 0, b = 1, tol = 1e-6;
        int maxIter = 100;
        double fa = f(a), fb = f(b), c = a;

        for (int i = 0; i < maxIter; i++) {
            c = b - fb * (b - a) / (fb - fa);
            double fc = f(c);
            if (Math.abs(fc) < tol) break;
            if (fa * fc < 0) {
                b = c; fb = fc;
            } else {
                a = c; fa = fc;
            }
        }

        System.out.printf("Raíz aproximada: %.6f\n", c);
    }
}
