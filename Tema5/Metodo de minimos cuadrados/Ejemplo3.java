public class MinimosCuadrados {
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2.7, 7.4, 20.1, 54.6, 148.4};
        int n = x.length;

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        // Transformación logarítmica de y
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += Math.log(y[i]);
            sumXY += x[i] * Math.log(y[i]);
            sumX2 += x[i] * x[i];
        }

        // Cálculo de coeficientes para la forma ln(y) = ln(A) + Bx
        double B = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double A_ln = (sumY - B * sumX) / n;
        double A = Math.exp(A_ln);

        // Ecuación ajustada
        System.out.printf("Problema 3: y = %.2fe^(%.2fx)%n", A, B);
    }
}
