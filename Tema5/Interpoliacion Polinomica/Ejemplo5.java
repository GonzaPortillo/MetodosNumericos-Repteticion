//Este ejemplo presenta error a modo de ejemplo

public class Main {
    public static void main(String[] args) {
        double[] x = {1, 2, 3};
        double[] y = {2, 3, 5};
        int n = x.length;

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        // Pendiente (b) y ordenada al origen (a) de la recta y = a + bx
        double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double a = (sumY - b * sumX) / n;

        System.out.printf("Problema 1: y = %.3f + %.3fx\n", a, b);
    }
}
