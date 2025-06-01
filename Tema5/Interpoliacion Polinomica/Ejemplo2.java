public class Main {

    // Método para calcular diferencias divididas
    public static double[][] diferenciasDivididas(double[] x, double[] y) {
        int n = x.length;
        double[][] tabla = new double[n][n];

        // Inicializar primera columna con los valores de y[]
        for (int i = 0; i < n; i++) {
            tabla[i][0] = y[i];
        }

        // Calcular las diferencias divididas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i + 1][j - 1] - tabla[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        return tabla;
    }

    // Evaluar el polinomio de Newton en xEval
    public static double evaluarNewton(double[] x, double[][] tabla, double xEval) {
        double resultado = tabla[0][0];
        double producto = 1;

        for (int i = 1; i < x.length; i++) {
            producto *= (xEval - x[i - 1]);
            resultado += tabla[0][i] * producto;
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Puntos conocidos
        double[] x = {0, 1, 2};
        double[] y = {1, 3, 2};

        // Punto a evaluar
        double xEval = 1.5;

        // Calcular tabla de diferencias divididas
        double[][] tabla = diferenciasDivididas(x, y);

        // Evaluar el polinomio en el punto deseado
        double resultado = evaluarNewton(x, tabla, xEval);

        // Mostrar resultado
        System.out.printf("Problema 2 (Newton): P(%.1f) = %.3f\n", xEval, resultado);
    }
}
