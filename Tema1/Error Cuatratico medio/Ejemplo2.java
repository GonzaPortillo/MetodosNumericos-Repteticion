//Con arreglos double

public class MSEEjemplo2 {
  
    public static void main(String[] args) {
        double[] reales = {2.5, 3.6, 1.8, 4.9, 5.0};
        double[] predichos = {2.4, 3.5, 1.9, 4.8, 5.2};
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
