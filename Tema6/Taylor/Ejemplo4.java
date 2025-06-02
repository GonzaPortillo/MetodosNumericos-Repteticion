public class TaylorCos {
    public static double derivative(int n, double a) {
        switch (n % 4) {
            case 0: return Math.cos(a);
            case 1: return -Math.sin(a);
            case 2: return -Math.cos(a);
            case 3: return Math.sin(a);
            default: return 0;
        }
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
        double a = 0, x = Math.PI / 4;
        int n = 10;
        double aproximacion = taylor(a, x, n);
        System.out.println("Taylor cos(x) ≈ " + aproximacion);
        System.out.println("Valor real cos(x) = " + Math.cos(x));
        System.out.println("Error = " + Math.abs(Math.cos(x) - aproximacion));
    }
}
