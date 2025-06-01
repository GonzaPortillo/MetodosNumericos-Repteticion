public class Problema_4 {

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
        double[][] A = {{1, -2, 3, -1}, {2, 3, -1, 2}, {3, -1, 2, 3}, {1, 4, -2, -1}}; 
        double[] b = {4, 9, 12, 1}; 
    
        int iterations = 50;
    
        double[] solution = jacobi(A, b, iterations);
    
        System.out.println("La solución al sistema de ecuaciones es:");
        for (int i = 0; i < solution.length; i++) {
            System.out.println("x[" + i + "] = " + solution[i]);
        }
    }
}
