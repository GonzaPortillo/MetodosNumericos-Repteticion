public class PasoMultipleAB3_Ej1 {

    // Función que representa la derivada dv/dt = f(t, v)
    public static double f(double t, double v) {
        return 9.8 - 0.1 * v;
    }

    public static void main(String[] args) {
        double h = 0.2;

        // Valores de t conocidos
        double[] t = {0.0, 0.2, 0.4};

        // Aproximaciones previas de v(t) en t = 0.0, 0.2 y 0.4
        double[] v = {0.0, 1.96, 3.724};

        // Evaluaciones de la función en los puntos anteriores
        double f0 = f(t[0], v[0]);
        double f1 = f(t[1], v[1]);
        double f2 = f(t[2], v[2]);

        // Aplicación del método de Adams-Bashforth de 3 pasos
        double v3 = v[2] + h * (23 * f2 - 16 * f1 + 5 * f0) / 12;

        // Resultado
        System.out.printf("Aproximación de v(0.6): %.5f m/s\n", v3);
    }
}
