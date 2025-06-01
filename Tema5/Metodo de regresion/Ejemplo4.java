public class Main {
    public static void main(String[] args) {
        double[] x = {2, 4, 6, 8};
        double[] y = {4, 2, 4, 6};
        int n = x.length;

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double a = (sumY - b * sumX) / n;

        System.out.printf("Problema 4: y = %.3f + %.3fx\n", a, b);
    }
}
