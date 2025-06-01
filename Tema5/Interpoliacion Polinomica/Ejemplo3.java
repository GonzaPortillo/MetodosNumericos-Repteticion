public class RendimientoMaquina {

    // Método para calcular la tabla de diferencias divididas
    public static double[][] diferenciasDivididas(double[] tiempo, double[] rendimiento) {
        int n = tiempo.length;
        double[][] tabla = new double[n][n];

        // Inicializar la primera columna con los valores de rendimiento
        for (int i = 0; i < n; i++) {
            tabla[i][0] = rendimiento[i];
        }

        // Calcular las diferencias divididas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i + 1][j - 1] - tabla[i][j - 1]) / (tiempo[i + j] - tiempo[i]);
            }
        }

        return tabla;
    }

    // Evaluar el polinomio de Newton en tiempoEval
    public static double evaluarNewton(double[] tiempo, double[][] tabla, double tiempoEval) {
        double resultado = tabla[0][0];
        double producto = 1;

        for (int i = 1; i < tiempo.length; i++) {
            producto *= (tiempoEval - tiempo[i - 1]);
            resultado += tabla[0][i] * producto;
        }

        return resultado;
    }

    public static void main(String[] args) {
        double[] tiempo = {1, 2, 4}; // Tiempo en horas
        double[] rendimiento = {2, 1, 3}; // Unidades producidas

        double tiempoEstimado = 3; // Queremos estimar en 3 horas

        double[][] tabla = diferenciasDivididas(tiempo, rendimiento);
        double resultado = evaluarNewton(tiempo, tabla, tiempoEstimado);

        System.out.printf("Estimación de producción a las %.1f horas: %.3f unidades\n", tiempoEstimado, resultado);
    }
}
