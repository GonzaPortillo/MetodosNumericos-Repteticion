public class CorrelacionTemperaturas {

    public static void main(String[] args) {
        // Temperaturas semana de referencia
        double[] semana1 = {22.5, 23.1, 24.3, 25.0, 23.8, 22.0, 21.5};
        // Temperaturas de dos semanas (incluye ruido y desplazamiento)
        double[] semana2 = {19.0, 20.2, 21.3, 22.5, 23.1, 24.3, 25.0, 23.8,
                            22.0, 21.5, 20.0};

        // Calcular la correlación cruzada
        double[] correlacion = correlacionCruzada(semana1, semana2);

        // Mostrar resultados
        System.out.println("Resultados de correlación de temperaturas:");
        for (int k = 0; k < correlacion.length; k++) {
            System.out.printf("Lag %d: %.2f%n", k - (semana1.length - 1), correlacion[k]);
        }

        // Encontrar el lag con máxima correlación
        int maxLag = encontrarMaximoLag(correlacion) - (semana1.length - 1);
        System.out.println("\nEl desplazamiento óptimo es: Lag " + maxLag);
    }

    /**
     * Calcula la correlación cruzada entre dos arreglos de datos
     * @param x arreglo referencia
     * @param y arreglo con desplazamiento y ruido
     * @return arreglo con valores de correlación cruzada
     */
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

    /**
     * Encuentra el índice del lag con la máxima correlación
     * @param correlacion arreglo con valores de correlación
     * @return índice del lag óptimo
     */
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
