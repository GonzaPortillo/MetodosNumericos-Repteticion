public class Problema_4 {
    
    public static double funcion(double x) {
        return 2 * x * x * x - 5 * x * x + x - 1; // f(x) = 2x^3 - 5x^2 + x - 1
    }

    public static double biseccion(double a, double b, double tolerancia, int maxIteraciones) {
        if (funcion(a) * funcion(b) >= 0) {
            System.out.println("El método de bisección no se puede aplicar.");
            return Double.NaN;
        }
        
        double c = a;
        for (int i = 0; i < maxIteraciones; i++) {
            c = (a + b) / 2;

            if (funcion(c) == 0.0 || (b - a) / 2 < tolerancia) {
                return c;
            }

            if (funcion(c) * funcion(a) < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        
        return c;
    }

    public static void main(String[] args) {
        double a = 0; // Límite inferior del intervalo
        double b = 4; // Límite superior del intervalo
        double tolerancia = 1e-6; // Tolerancia
        int maxIteraciones = 1000; // Número máximo de iteraciones
        
        double raiz = biseccion(a, b, tolerancia, maxIteraciones);
        
        if (!Double.isNaN(raiz)) {
            System.out.printf("La raíz encontrada es: %.6f\n", raiz);
        } else {
            System.out.println("No se encontró una raíz en el intervalo dado.");
        }
    }
}
