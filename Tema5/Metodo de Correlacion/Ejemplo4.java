public class CorrelacionVentas {
    public static void main(String[] args) {
        // Ventas del primer año (patrón)
        double[] ventas2022 = {150, 170, 200, 180, 220, 250};
        // Ventas del segundo año con posible desplazamiento estacional
        double[] ventas2023 = {100, 120, 150, 170, 200, 180, 220, 250, 230};

        double[] correlacion = correlacionCruzada(ventas2022, ventas2023);

        System.out.println("Resultados de correlación de ventas:");
        for (int k = 0; k < correlacion.length; k++) {
            System.out.printf("Lag %d: %.2f%n", k - (ventas2022.length - 1), correlacion[k]);
        }

        int maxLag = encontrarMaximoLag(correlacion) - (ventas2022.length - 1);
        System.out.println("\nEl desplazamiento estacional es: Lag " + maxLag);
    }

    // Método para calcular la correlación cruzada
    public static double[] correlacionCruzada(double[] x, double[] y) {
        int n = x.length;
        int m = y.length;
        double[] resultado = new double[n + m - 1];

        for (int k = 0; k < resultado.length; k++) {
            double suma = 0.0;
            for (int i = 0; i < n; i++) {
                int j = k + i - (n - 1);
                if (j >= 0 && j < m) {
                    suma += x[i] * y[j];
                }
            }
            resultado[k] = suma;
        }
        return resultado;
    }

    // Método para encontrar el lag con máxima correlación
    public static int encontrarMaximoLag(double[] correlacion) {
        int maxIndex = 0;
        double maxValor = correlacion[0];
        for (int i = 1; i < correlacion.length; i++) {
            if (correlacion[i] > maxValor) {
                maxValor = correlacion[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
