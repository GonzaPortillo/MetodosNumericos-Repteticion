public class Newton3 {
    public static double f(double x) {
        return Math.cos(x) - x;
    }

    public static double df(double x) {
        return -Math.sin(x) - 1;
    }

    public static void main(String[] args) {
        double x = 0.5;
        double tol = 1e-6;
        int maxIter = 100;

        for (int i = 0; i < maxIter; i++) {
            double fx = f(x), dfx = df(x);
            if (Math.abs(fx) < tol) break;
            x = x - fx / dfx;
        }

        System.out.printf("Raíz aproximada: %.6f\n", x);  // ≈ 0.739
    }
}
