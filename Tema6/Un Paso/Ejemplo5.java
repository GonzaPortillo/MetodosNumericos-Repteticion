public class MetodoError {

    // Derivada dy/dx = f(x, y)
    public static double f(double x, double y) {
        return y;
    }

    public static void main(String[] args) {
        // Datos iniciales
        double x0 = 0;
        double y0 = 1;
        double h = 0.2;
        int n = 5;

        double x = x0;
        double y = y0;

        System.out.println("Paso\t x\t\t y (Euler)");
        System.out.printf("0\t %.2f\t %.6f%n", x, y);

        for (int i = 1; i <= n; i++) {
            y = y + h * f(x, y); // Método de Euler
            x = x + h;
            System.out.printf("%d\t %.2f\t %.6f%n", i, x, y);
        }

        // Comparación con la solución exacta y(x) = e^x
        double yExacto = Math.exp(1); // e^1 ≈ 2.7182818
        double error = Math.abs(yExacto - y);

        System.out.printf("%nValor exacto en x = 1: %.6f%n", yExacto);
        System.out.printf("Valor estimado con Euler: %.6f%n", y);
        System.out.printf("Error absoluto: %.6f%n", error);
    }
}

