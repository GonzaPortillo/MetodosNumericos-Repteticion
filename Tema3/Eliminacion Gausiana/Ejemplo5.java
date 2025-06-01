public class Problema_5 {

    public static void main(String[] args) {
        double[][] matriz = {
            {3, -2, 4},
            {2, 1, 7}
        };
    
        double[] solucion = resolverSistema(matriz);
    
        for (int i = 0; i < solucion.length; i++) {
            System.out.println("x" + (i+1) + " = " + solucion[i]);
        }
    }

    public static double[] resolverSistema(double[][] matriz) {
        int n = matriz.length;
    
        for (int i = 0; i < n - 1; i++) {
            for (int k = i + 1; k < n; k++) {
                double factor = matriz[k][i] / matriz[i][i];
                for (int j = i; j < n + 1; j++) {
                    matriz[k][j] -= factor * matriz[i][j];
                }
            }
        }
    
        double[] solucion = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            solucion[i] = matriz[i][n];
            for (int j = i + 1; j < n; j++) {
                solucion[i] -= matriz[i][j] * solucion[j];
            }
            solucion[i] /= matriz[i][i];
        }
    
        return solucion;
    }
}
