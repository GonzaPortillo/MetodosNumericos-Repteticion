public class Problema_4 {

    public static double f(double x) {
        return x * x - 2 * x - 3; // Función: x^2 - 2x - 3
    }

    public static double secantMethod(double x0, double x1, double tol, int maxIter) {
        double f0 = f(x0);
        double f1 = f(x1);
        double x2 = 0.0;
        int iter = 0;

        while (Math.abs(f1) > tol && iter < maxIter) {
            x2 = x1 - f1 * ((x1 - x0) / (f1 - f0)); // Fórmula del método de la secante
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = f(x1);
            iter++;
        }

        if (iter >= maxIter) {
            System.out.println("El método no convergió en " + maxIter + " iteraciones.");
        }

        return x2;
    }

    public static void main(String[] args) {
        double x0 = 3; // Valor inicial 1
        double x1 = 4; // Valor inicial 2
        double tol = 1e-6; // Tolerancia
        int maxIter = 100; // Número máximo de iteraciones

        double root = secantMethod(x0, x1, tol, maxIter);
        System.out.println("La raíz encontrada es: " + root);
    }
}
