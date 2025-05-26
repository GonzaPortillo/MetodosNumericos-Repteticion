public class PuntoFijo3
{

    public static double g(double x) {
        return 1 - Math.pow(x, 3);
    }

    public static double puntoFijo(double x0, double tolerancia, int maxIteraciones) {
        int iter = 0;
        double x1;

        do {
            x1 = g(x0);

            if (Math.abs(x1 - x0) < tolerancia) {
                return x1;
            }

            x0 = x1;
            iter++;
        } while (iter < maxIteraciones);

        System.out.println("No se encontró la raíz en el número máximo de iteraciones.");
        return x1;
    }

    public static void main(String[] args) {
        double x0 = 0.5;
        double tolerancia = 1e-6;
        int maxIteraciones = 100;

        double raiz = puntoFijo(x0, tolerancia, maxIteraciones);
        System.out.printf("Raíz aproximada: %.6f\n", raiz);
    }
}
