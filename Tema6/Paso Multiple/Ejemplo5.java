public class PasoMultipleAB3_EjConError {

    // Derivada dy/dt = f(t, y)
    public static double f(double t, double y) {
        return -2 * y;
    }

    // Solución exacta y(t) = e^(-2t)
    public static double exactSolution(double t) {
        return Math.exp(-2 * t);
    }

    public static void main(String[] args) {
        double h = 0.1;

        // Valores previos de tiempo
        double[] t = {0.0, 0.1, 0.2};

        // Aproximaciones previas de y
        double[] y = {1.0, 0.81873, 0.67032};

        // Evaluaciones de la función f(t, y)
        double f0 = f(t[0], y[0]);
        double f1 = f(t[1], y[1]);
        double f2 = f(t[2], y[2]);

        // Adams-Bashforth 3 pasos para calcular y(0.3)
        double y3 = y[2] + h * (23 * f2 - 16 * f1 + 5 * f0) / 12;

        // Cálculo de la solución exacta en t=0.3
        double exact = exactSolution(0.3);

        // Cálculo del error absoluto
        double error = Math.abs(exact - y3);

        // Resultados
        System.out.printf("Aproximación de y(0.3): %.5f%n", y3);
        System.out.printf("Valor exacto y(0.3): %.5f%n", exact);
        System.out.printf("Error absoluto: %.5f%n", error);
    }
}
