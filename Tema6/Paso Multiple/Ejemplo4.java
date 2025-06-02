public class PasoMultipleAB3_Ej2 {

    // Función que representa la derivada dT/dt = f(t, T)
    public static double f(double t, double T) {
        return -0.07 * (T - 22); // Ley de enfriamiento de Newton
    }

    public static void main(String[] args) {
        double h = 0.1;

        // Valores de tiempo conocidos
        double[] t = {0.0, 0.1, 0.2};

        // Temperaturas aproximadas en t = 0.0, 0.1, 0.2
        double[] T = {90.0, 83.66, 78.02};

        // Evaluaciones de la función f(t, T)
        double f0 = f(t[0], T[0]);
        double f1 = f(t[1], T[1]);
        double f2 = f(t[2], T[2]);

        // Aplicación del método de Adams-Bashforth de 3 pasos
        double T3 = T[2] + h * (23 * f2 - 16 * f1 + 5 * f0) / 12;

        // Resultado
        System.out.printf("Aproximación de T(0.3): %.5f °C\n", T3);
    }
}
