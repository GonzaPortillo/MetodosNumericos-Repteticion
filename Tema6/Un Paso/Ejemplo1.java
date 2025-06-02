import java.text.DecimalFormat;

public class MetodoUnPaso {

    // Función f(x, y) que representa la derivada dy/dx
    public static double f(double x, double y) {
        return x + y; // Ejemplo: dy/dx = x + y
    }

    // Método de Euler para aproximar soluciones a EDOs
    public static void metodoEuler(double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("x\t\ty");
        for (int i = 0; i <= n; i++) {
            System.out.println(df.format(x) + "\t\t" + df.format(y));
            y = y + h * f(x, y); // y_{i+1} = y_i + h*f(x_i, y_i)
            x = x + h;           // x_{i+1} = x_i + h
        }
    }

    public static void main(String[] args) {
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y
        double h = 0.1;   // Tamaño de paso
        int n = 10;       // Número de pasos

        metodoEuler(x0, y0, h, n);
    }
}
