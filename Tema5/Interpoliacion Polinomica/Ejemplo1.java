public class Main {

    // Método que aplica interpolación de Lagrange
    public static double lagrange(double[] x, double[] y, double xEval) {
        double result = 0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term *= (xEval - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        // Coordenadas conocidas
        double[] x = {0, 1, 2}; // Coordenadas x
        double[] y = {1, 3, 2}; // Coordenadas y

        // Punto a evaluar
        double xEval = 1.5;

        // Evaluación usando interpolación de Lagrange
        double resultado = lagrange(x, y, xEval);

        // Mostrar resultado
        System.out.printf("Problema 1: P(%.1f) = %.3f\n", xEval, resultado);
    }
}
