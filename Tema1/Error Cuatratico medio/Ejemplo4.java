//Con arreglos long

public class MSEEjemplo4 {
    public static void main(String[] args) {
        long[] reales = {1000000, 2000000, 3000000, 4000000, 5000000};
        long[] predichos = {1100000, 2100000, 2900000, 3900000, 5100000};
        double mse = calcularMSE(reales, predichos);
        System.out.println("MSE: " + mse);
    }

    public static double calcularMSE(long[] reales, long[] predichos) {
        double sumaError = 0.0;
        int n = reales.length;
        for (int i = 0; i < n; i++) {
            sumaError += Math.pow(reales[i] - predichos[i], 2);
        }
        return sumaError / n;
    }
}
