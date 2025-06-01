public class Problema_1 {

    public static double[] gaussSeidel(double[][] A, double[] b, double tol, int maxIter) {
        int n = A.length;
        double[] x = new double[n]; // Vector de solución
        double[] x_new = new double[n]; // Vector de solución actualizado
    
        for (int i = 0; i < n; i++) {
            x[i] = 0;
        }
    
        int iter = 0;
        double error = tol + 1; // Error inicial
        while (error > tol && iter < maxIter) {
            for (int i = 0; i < n; i++) {
                double sum = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum += A[i][j] * x[j];
                    }
                }
                x_new[i] = (b[i] - sum) / A[i][i];
            }
        
            error = 0;
            for (int i = 0; i < n; i++) {
                error = Math.max(error, Math.abs(x_new[i] - x[i]));
            }
        
            for (int i = 0; i < n; i++) {
                x[i] = x_new[i];
            }
        
            iter++;
        }
    
        if (iter == maxIter) {
            System.out.println("El método no convergió después de " + maxIter + " iteraciones.");
        }
    
        return x;
    }

    public static void main(String[] args) {
        double[][] A = {{10, 2, 1}, {1, 5, 1}, {2, 3, 10}}; // Matriz de coeficientes
        double[] b = {7, -8, 6}; // Vector de términos constantes
        double tol = 1e-6; // Tolerancia
        int maxIter = 1000; // Máximo número de iteraciones
    
        double[] x = gaussSeidel(A, b, tol, maxIter);
    
        System.out.println("La solución del sistema es:");
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
