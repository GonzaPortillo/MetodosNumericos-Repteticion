public class Newton4 {
    public static double f(double x) {
        return Math.exp(x) - 3 * x;
    }

    public static double df(double x) {
        return Math.exp(x) - 3;
    }

    public static void main(String[] args) {
        double x = 1.0;
        double tol = 1e-6;
        int maxIter = 100;

        for (int i = 0; i < maxIter; i++) {
            double fx = f(x), dfx = df(x);
            if (Math.abs(fx) < tol) break;
            x = x - fx / dfx;
        }

        System.out.printf("Raíz aproximada: %.6f\n", x);  // ≈ 1.512
    }
}
