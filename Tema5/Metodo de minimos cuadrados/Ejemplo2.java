public class MinimosCuadrados {
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {1, 4, 9, 16, 25};
        int n = x.length;

        double sumX = 0, sumY = 0, sumX2 = 0, sumX3 = 0, sumX4 = 0;
        double sumXY = 0, sumX2Y = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumX2 += x[i] * x[i];
            sumX3 += x[i] * x[i] * x[i];
            sumX4 += x[i] * x[i] * x[i] * x[i];
            sumXY += x[i] * y[i];
            sumX2Y += x[i] * x[i] * y[i];
        }

        double[][] A = {
            {n, sumX, sumX2},
            {sumX, sumX2, sumX3},
            {sumX2, sumX3, sumX4}
        };

        double[] B = {sumY, sumXY, sumX2Y};
        int size = B.length;

        // Eliminación Gaussiana
        for (int i = 0; i < size; i++) {
            double max = A[i][i];
            int maxRow = i;
            for (int k = i + 1; k < size; k++) {
                if (Math.abs(A[k][i]) > Math.abs(max)) {
                    max = A[k][i];
                    maxRow = k;
                }
            }

            // Intercambio de filas
            double[] temp = A[i];
            A[i] = A[maxRow];
            A[maxRow] = temp;

            double t = B[i];
            B[i] = B[maxRow];
            B[maxRow] = t;

            // Eliminación hacia adelante
            for (int k = i + 1; k < size; k++) {
                double factor = A[k][i] / A[i][i];
                B[k] -= factor * B[i];
                for (int j = i; j < size; j++) {
                    A[k][j] -= factor * A[i][j];
                }
            }
        }

        // Sustitución hacia atrás
        double[] coef = new double[size];
        for (int i = size - 1; i >= 0; i--) {
            coef[i] = B[i] / A[i][i];
            for (int k = i - 1; k >= 0; k--) {
                B[k] -= A[k][i] * coef[i];
            }
        }

        System.out.printf("Problema 2: y = %.2fx² + %.2fx + %.2f%n",
                coef[2], coef[1], coef[0]);
    }
}

