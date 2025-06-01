public class CorrelacionEstudioCalificaciones {
    public static void main(String[] args) {
        double[] horasEstudio = {5, 8, 3, 10, 6};
        double[] calificaciones = {6.0, 7.5, 4.5, 9.0, 7.0};

        double correlacion = calcularCorrelacion(horasEstudio, calificaciones);
        System.out.printf("Coeficiente de correlación de Pearson: %.4f%n", correlacion);

        interpretarCorrelacion(correlacion);
    }

    public static double calcularCorrelacion(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
            sumY2 += y[i] * y[i];
        }

        double numerador = sumXY - (sumX * sumY / n);
        double denominador = Math.sqrt((sumX2 - (sumX * sumX / n)) * (sumY2 - (sumY * sumY / n)));

        return numerador / denominador;
    }

    public static void interpretarCorrelacion(double r) {
        System.out.println("\nInterpretación:");
        if (r >= 0.9) {
            System.out.println("Correlación positiva muy fuerte.");
        } else if (r >= 0.7) {
            System.out.println("Correlación positiva fuerte.");
        } else if (r >= 0.5) {
            System.out.println("Correlación positiva moderada.");
        } else if (r >= 0.3) {
            System.out.println("Correlación positiva débil.");
        } else if (r > -0.3) {
            System.out.println("No hay correlación significativa.");
        } else if (r > -0.5) {
            System.out.println("Correlación negativa débil.");
        } else {
            System.out.println("Correlación negativa fuerte.");
        }
    }
}
