//Con enteros negativos

public class MSEEjemplo3 {
    public static void main(String[] args) {
        int[] reales = {-5, -10, -15, -20, -25};
        int[] predichos = {-4, -9, -14, -19, -24};
        double mse = calcularMSE(reales, predichos);
        System.out.println("MSE: " + mse);
    }

    public static double calcularMSE(int[] reales, int[] predichos) {
        double sumaError = 0.0;
        int n = reales.length;
        for (int i = 0; i < n; i++) {
            sumaError += Math.pow(reales[i] - predichos[i], 2);
        }
        return sumaError / n;
    }
}
