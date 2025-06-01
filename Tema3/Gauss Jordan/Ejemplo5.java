public class Problema_5 {

    public static void main(String[] args) {
        double[][] matriz = {
            {1, 2, -1, 1, 4},
            {2, -1, 3, -2, 7},
            {3, 1, 1, 4, 10},
            {1, -1, 0, 2, 1}
        };
    
        gaussJordan(matriz);
    
        System.out.println("Solución del sistema de ecuaciones:");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("x" + (i+1) + " = " + matriz[i][matriz[i].length-1]);
        }
    }

    public static void gaussJordan(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
    
        for (int i = 0; i < filas; i++) {
            int maxFila = i;
            for (int k = i + 1; k < filas; k++) {
                if (Math.abs(matriz[k][i]) > Math.abs(matriz[maxFila][i])) {
                    maxFila = k;
                }
            }
            double[] temp = matriz[maxFila];
            matriz[maxFila] = matriz[i];
            matriz[i] = temp;
        
            double pivote = matriz[i][i];
            for (int j = i; j < columnas; j++) {
                matriz[i][j] /= pivote;
            }
        
            for (int k = 0; k < filas; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    for (int j = i; j < columnas; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                }
            }
        }
    }
}
