package metodo.de.interpolacion.lineal;

public class MetodoDeInterpolacionLineal {

    // Método de interpolación lineal
    public static Double interpolar(double x0, double y0, double x1, double y1, double x) {
        if (x1 == x0) {
            // Evita división por cero
            return null;
        }
        return y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
    }

    public static void main(String[] args) {
        // Datos de ejemplo
        double x0 = 6;
        double y0 = 12.35;
        double x1 = 9.5;
        double y1 = 13.88;
        double x = 8;

        // Llamada al método de interpolación
        Double resultado = interpolar(x0, y0, x1, y1, x);

        // Validación del resultado
        if (resultado == null) {
            System.out.println("Error: x0 y x1 no pueden ser iguales (división por cero).");
        } else {
            System.out.printf("El valor interpolado en x = %.2f es: f(x) = %.2f%n", x, resultado);
        }
    }
}
