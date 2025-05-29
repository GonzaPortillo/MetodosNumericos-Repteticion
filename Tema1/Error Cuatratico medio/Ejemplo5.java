// valores pequeños

public class MSEEjemplo5 {
    public static void main(String[] args) {
        double[] reales = {0.1, 0.2, 0.3, 0.4, 0.5};
        double[] predichos = {0.12, 0.18, 0.32, 0.38, 0.52};
        double mse = calcularMSE(reales, predichos);
        System.out.println("MSE: " + mse);
    }

    public static double calcularMSE(double[] reales, double[] predichos) {
        double sumaError = 0.0;
        int n = reales.length;
        for (int i = 0; i < n; i++) {
            sumaError += Math.pow(reales[i] - predichos[i], 2);
        }
        return sumaError / n;
    }
}
