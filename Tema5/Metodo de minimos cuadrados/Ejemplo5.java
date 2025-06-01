public class MinimosCuadrados {
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2.3, 3.1, 3.8, 4.4, 4.9};
        int n = x.length;

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        // Transformar x con logaritmo natural para el modelo y = A + B ln(x)
        for (int i = 0; i < n; i++) {
            double lnX = Math.log(x[i]);
            sumX += lnX;
            sumY += y[i];
            sumXY += lnX * y[i];
            sumX2 += lnX * lnX;
        }

        // Calcular coeficientes B y A
        double B = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double A = (sumY - B * sumX) / n;

        // Mostrar la ecuación ajustada
        System.out.printf("Problema 4: y = %.2f + %.2fln(x)%n", A, B);
    }
}
