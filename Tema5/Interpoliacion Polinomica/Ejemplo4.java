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
        double[] x = {1, 2, 4}; // Coordenadas x
        double[] y = {2, 1, 3}; // Coordenadas y
        double xEval = 3;       // Punto a evaluar

        double resultado = lagrange(x, y, xEval);

        System.out.printf("Problema 2: P(%.1f) = %.3f\n", xEval, resultado);
    }
}
