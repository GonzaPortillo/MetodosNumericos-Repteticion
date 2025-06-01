package interpolacionlineal;

public class InterpolacionLineal {

    // Método de interpolación lineal
    public static double interpolarLineal(double x0, double y0, double x1, double y1, double x) {
        if (x0 == x1) {
            throw new IllegalArgumentException("Los valores x0 y x1 no pueden ser iguales (evitar división por cero).");
        }
        return y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
    }

    public static void main(String[] args) {
        // Datos conocidos (velocidad en km/h, distancia de frenado en metros)
        double velocidad1 = 30.0;
        double distancia1 = 10.0;
        double velocidad2 = 80.0;
        double distancia2 = 50.0;

        // Velocidad para la que queremos estimar la distancia
        double velocidadDeseada = 60.0;

        // Validar que la velocidad esté dentro del rango conocido
        if (velocidadDeseada < Math.min(velocidad1, velocidad2) ||
            velocidadDeseada > Math.max(velocidad1, velocidad2)) {
            System.out.println("¡Advertencia! La velocidad deseada está fuera del rango de datos conocidos.");
        }

        // Calcular distancia estimada
        double distanciaEstimada = interpolarLineal(velocidad1, distancia1, velocidad2, distancia2, velocidadDeseada);

        // Resultado
        System.out.println("A " + velocidadDeseada + " km/h, la distancia estimada de frenado es: " +
                           String.format("%.2f", distanciaEstimada) + " metros.");
    }
}
