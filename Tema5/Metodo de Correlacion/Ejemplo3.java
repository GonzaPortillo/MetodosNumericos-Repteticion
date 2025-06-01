public class CorrelacionAudio {
    public static void main(String[] args) {
        // Fragmento de audio buscado
        double[] fragmento = {0.1, 0.5, 0.8, 0.3, -0.2};
        // Grabación completa con ruido
        double[] grabacion = {0.0, 0.1, 0.2, 0.1, 0.5, 0.8, 0.3, -0.2, 0.0,
                              0.1, -0.1};

        double[] correlacion = correlacionCruzada(fragmento, grabacion);

        System.out.println("Resultados de correlación de audio:");
        for (int k = 0; k < correlacion.length; k++) {
            System.out.printf("Lag %d: %.2f%n", k - (fragmento.length - 1), correlacion[k]);
        }

        int maxLag = encontrarMaximoLag(correlacion) - (fragmento.length - 1);
        System.out.println("\nEl fragmento aparece mejor alineado en: Lag " + maxLag);
    }

    /**
     * Calcula la correlación cruzada entre dos señales
     * @param x señal patrón
     * @param y señal con ruido y desplazamiento
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
     * Encuentra el índice del lag con máxima correlación
     * @param correlacion arreglo con valores de correlación cruzada
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
