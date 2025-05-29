//Con arreglos int

public class MSEEjemplo1 {
  
    public static void main(String[] args) {
      
        int[] reales = {1, 2, 3, 4, 5};
        int[] predichos = {1, 2, 2, 4, 6};
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

