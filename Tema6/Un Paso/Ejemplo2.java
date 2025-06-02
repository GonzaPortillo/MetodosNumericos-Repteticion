public class MetodoEuler {

    // Función que representa la derivada dy/dx = f(x, y)
    public static double f(double x, double y) {
        return y - Math.pow(x, 2) + 1; // Ejemplo: dy/dx = y - x^2 + 1
    }

    public static void main(String[] args) {
        // Datos iniciales
        double x0 = 0;
        double y0 = 0.5;
        double h = 0.2;  // Paso
        int n = 5;       // Número de pasos

        double x = x0;
        double y = y0;

        System.out.println("Paso\t x\t\t y");
        System.out.printf("0\t %.2f\t %.4f%n", x, y);

        for (int i = 1; i <= n; i++) {
            y = y + h * f(x, y); // Fórmula de Euler: y_{i+1} = y_i + h*f(x_i, y_i)
            x = x + h;           // Avanzamos en x: x_{i+1} = x_i + h
            System.out.printf("%d\t %.2f\t %.4f%n", i, x, y);
        }
    }
}
