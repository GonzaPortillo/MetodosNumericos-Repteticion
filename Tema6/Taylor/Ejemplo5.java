public class TaylorSeriesWithError {

    // Todas las derivadas de e^x son e^a
    public static double derivative(int n, double a) {
        return Math.exp(a);
    }

    // Calcula la aproximación de Taylor y el error
    public static double[] taylorSeriesWithError(double a, double x, int n) {
        double resultado = 0;
        double factorial = 1;
        double potencia = 1;

        for (int i = 0; i <= n; i++) {
            if (i > 0) {
                factorial *= i;            // i!
                potencia *= (x - a);       // (x - a)^i
            }
            resultado += (derivative(i, a) * potencia) / factorial;
        }

        double valorReal = Math.exp(x);
        double error = valorReal - resultado;

        return new double[]{resultado, error};
    }

    public static void main(String[] args) {
        double a = 0; // Punto base de la serie
        double x = 1; // Punto donde se evalúa
        int n = 5;    // Número de términos

        double[] result = taylorSeriesWithError(a, x, n);
        System.out.printf("Aproximación de Taylor: %.10f%n", result[0]);
        System.out.printf("Error absoluto: %.10f%n", result[1]);
    }
}
