public class Problema_1 {

    public static double[] jacobi(double[][] A, double[] b, int iterations) {
        int n = A.length;
        double[] x = new double[n]; // Vector inicial
        double[] x_new = new double[n]; // Vector para almacenar los nuevos valores
    
        for (int iter = 0; iter < iterations; iter++) {
            for (int i = 0; i < n; i++) {
                double sum = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum += A[i][j] * x[j];
                    }
                }
                x_new[i] = (b[i] - sum) / A[i][i];
            }
        
            for (int i = 0; i < n; i++) {
                x[i] = x_new[i];
            }
        }
    
        return x;
    }

    public static void main(String[] args) {
        double[][] A = {{4, -1, 0}, {-1, 4, -1}, {0, -1, 3}};
        double[] b = {5, -10, 5};
    
        int iterations = 50;
    
        double[] solution = jacobi(A, b, iterations);
    
        System.out.println("La solución al sistema de ecuaciones es:");
        for (int i = 0; i < solution.length; i++) {
            System.out.println("x[" + i + "] = " + solution[i]);
        }
    }
}
