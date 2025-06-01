public class InterpolacionLineal {

    // Método para interpolar linealmente
    public static double interpolarLineal(double x0, double y0, double x1, double y1, double x) {
        // Fórmula: y = y0 + ((y1 - y0) / (x1 - x0)) * (x - x0)
        return y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
    }

    public static void main(String[] args) {
        // Datos conocidos (peso en kg, precio en $)
        double peso1 = 0.5;
        double precio1 = 1.50;
        double peso2 = 1.0;
        double precio2 = 2.80;

        // Peso para el que queremos estimar el precio
        double pesoDeseado = 0.75;

        // Aplicamos interpolación lineal
        double precioEstimado = interpolarLineal(peso1, precio1, peso2, precio2, pesoDeseado);

        // Mostramos el resultado
        System.out.println("Precio estimado para " + pesoDeseado + " kg de manzanas: $" 
            + String.format("%.2f", precioEstimado));
    }
}
