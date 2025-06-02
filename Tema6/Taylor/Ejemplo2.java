public class TaylorExp {
    public static double derivative(int n, double a) {
        return Math.exp(a); // Todas las derivadas de e^x son e^a
    }

    public static double taylor(double a, double x, int n) {
        double resultado = 0, potencia = 1, factorial = 1;
        for (int i = 0; i <= n; i++) {
            if (i > 0) {
                potencia *= (x - a);
                factorial *= i;
            }
            resultado += (derivative(i, a) * potencia) / factorial;
        }
        return resultado;
    }

    public static void main(String[] args) {
        double a = 0, x = 1;
        int n = 10;
        double aproximacion = taylor(a, x, n);
        System.out.println("Taylor e^x ≈ " + aproximacion);
        System.out.println("Valor real e^x = " + Math.exp(x));
        System.out.println("Error = " + Math.abs(Math.exp(x) - aproximacion));
    }
}
