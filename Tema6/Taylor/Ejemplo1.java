public class TaylorSeries {

    // Función que devuelve la derivada n-ésima de la función deseada en el punto a
    public static double derivative(int n, double a, String funcion) {
        switch (funcion) {
            case "exp":
                return Math.exp(a); // f(x) = e^x → todas las derivadas son e^a
            case "sin":
                switch (n % 4) {
                    case 0: return Math.sin(a);
                    case 1: return Math.cos(a);
                    case 2: return -Math.sin(a);
                    case 3: return -Math.cos(a);
                }
            case "cos":
                switch (n % 4) {
                    case 0: return Math.cos(a);
                    case 1: return -Math.sin(a);
                    case 2: return -Math.cos(a);
                    case 3: return Math.sin(a);
                }
            case "ln":
                if (n == 0) return Math.log(a);
                else return Math.pow(-1, n + 1) * factorial(n - 1) / Math.pow(a, n);
            case "1/(1-x)":
                return factorial(n) / Math.pow(1 - a, n + 1);
            default:
                throw new IllegalArgumentException("Función no soportada.");
        }
    }

    // Factorial auxiliar
    public static double factorial(int n) {
        double fact = 1.0;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }

    // Serie de Taylor
    public static double taylorSeries(double a, double x, int n, String funcion) {
        double resultado = 0;
        double potencia = 1;
        double fact = 1;

        for (int i = 0; i <= n; i++) {
            if (i > 0) {
                potencia *= (x - a);
                fact *= i;
            }
            resultado += (derivative(i, a, funcion) * potencia) / fact;
        }

        return resultado;
    }

    public static void main(String[] args) {
        double a = 0; // Punto de expansión
        double x = 0.5; // Valor a evaluar
        int n = 10; // Número de términos
        String funcion = "sin"; // Cambia esto por: "exp", "sin", "cos", "ln", "1/(1-x)"

        double resultado = taylorSeries(a, x, n, funcion);
        double real = switch (funcion) {
            case "exp" -> Math.exp(x);
            case "sin" -> Math.sin(x);
            case "cos" -> Math.cos(x);
            case "ln" -> Math.log(x);
            case "1/(1-x)" -> 1.0 / (1.0 - x);
            default -> 0.0;
        };

        System.out.println("Función: " + funcion);
        System.out.println("Aproximación de Taylor: " + resultado);
        System.out.println("Valor real: " + real);
        System.out.println("Error absoluto: " + Math.abs(real - resultado));
    }
}
