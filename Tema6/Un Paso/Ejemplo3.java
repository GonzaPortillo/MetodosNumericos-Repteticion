public class MetodoEuler {

    // Función que representa la derivada dy/dx = f(x, y)
    public static double f(double x, double y) {
        return Math.cos(x) - y;
    }

    public static void main(String[] args) {
        // Datos iniciales
        double x0 = 0;
        double y0 = 2;
        double h = 0.2;  // Tamaño del paso
        int n = 5;       // Número de pasos

        double x = x0;
        double y = y0;

        // Encabezado de la tabla de resultados
        System.out.println("Paso\t x\t\t y");
        System.out.printf("0\t %.2f\t %.4f%n", x, y);

        // Iteración con el método de Euler
        for (int i = 1; i <= n; i++) {
            y = y + h * f(x, y); // Euler: y_{i+1} = y_i + h * f(x_i, y_i)
            x = x + h;           // Avance de x
            System.out.printf("%d\t %.2f\t %.4f%n", i, x, y);
        }
    }
}
