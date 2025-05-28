# Solución de Ecuaciones Diferenciales

## Introduccion
La solución de ecuaciones diferenciales en métodos numéricos se refiere a la implementación de técnicas computacionales para encontrar soluciones aproximadas a ecuaciones diferenciales, ya sean ordinarias o parciales, cuando no es posible obtener una solución analítica cerrada.

Algunos de los algoritmos que veremos son:

1. Euler: Es un método de integración numérica de primer orden para resolver ecuaciones diferenciales ordinarias. Aproxima la solución paso a paso, utilizando la pendiente inicial de la ecuación diferencial.
2. Runge Kutta: Es un método de integración numérica de orden superior (por ejemplo, Runge-Kutta de cuarto orden) para resolver ecuaciones diferenciales ordinarias. Utiliza una combinación de evaluaciones de la ecuación diferencial en diferentes puntos para obtener una aproximación más precisa.
3. Taylor: Es un método numérico para resolver ecuaciones diferenciales ordinarias. Se basa en expandir la solución de la ecuación diferencial en una serie de Taylor alrededor de un punto.

## Algroitmos

### Euler
1. Definir la ecuación diferencial de primer orden que se desea resolver: dy/dx = f(x, y).
2. Especificar el punto inicial (x0, y0).
3. Especificar el tamaño del paso h.
4. Calcular los valores de y en los puntos sucesivos utilizando la fórmula de Euler: ( y(n+1) = yn + h * f(xn, yn) )
5. Repetir el paso 4 hasta alcanzar el punto final deseado.

### Runge Kutta
1. Definir la ecuación diferencial de primer orden que se desea resolver: dy/dx = f(x, y).
2. Especificar el punto inicial (x0, y0).
3. Especificar el tamaño del paso h.
4. Calcular los valores de y en los puntos sucesivos utilizando la fórmula de Runge-Kutta de cuarto orden.
5. Repetir el paso 4 hasta alcanzar el punto final deseado.

### Taylor
1. Definir la ecuación diferencial de primer orden que se desea resolver: dy/dx = f(x, y).
2. Especificar el punto inicial (x0, y0).
3. Calcular las derivadas de la función f(x, y) con respecto a y en el punto inicial.
4. Utilizar la serie de Taylor para aproximar la solución de la ecuación diferencial en los puntos sucesivos.
5. Repetir el paso 4 hasta alcanzar el punto final deseado.

## Codigo en Java
### Euler

    public class MetodoEuler {

        // Definimos la ecuación diferencial dy/dx = f(x, y)
        // En este ejemplo, vamos a usar dy/dx = x + y
        public static double f(double x, double y) {
            return x + y;
        }

        // Método de Euler
        public static void metodoEuler(double x0, double y0, double h, int n) {
            double x = x0;
            double y = y0;

            System.out.printf("x0: %.4f, y0: %.4f%n", x, y);

            // Iteramos n veces para obtener las aproximaciones
            for (int i = 0; i < n; i++) {
                y = y + h * f(x, y);
                x = x + h;

                System.out.printf("x%d: %.4f, y%d: %.4f%n", i + 1, x, i + 1, y);
            }
        }

        public static void main(String[] args) {
            // Valores iniciales
            double x0 = 0.0;
            double y0 = 1.0;
            // Tamaño del paso
            double h = 0.1;
            // Número de iteraciones
            int n = 10;

            // Llamamos al método de Euler
            metodoEuler(x0, y0, h, n);
        }
    }

### Runge Kutta

    public class RungeKutta {

        // Definimos la ecuación diferencial dy/dx = f(x, y)
        // En este ejemplo, vamos a usar dy/dx = e^x - y
        public static double f(double x, double y) {
            return Math.exp(x) - y;
        }

        // Método de Runge-Kutta de cuarto orden
        public static void metodoRungeKutta(double x0, double y0, double h, int n) {
            double x = x0;
            double y = y0;

            System.out.printf("x0: %.4f, y0: %.4f%n", x, y);

            // Iteramos n veces para obtener las aproximaciones
            for (int i = 0; i < n; i++) {
                double k1 = h * f(x, y);
                double k2 = h * f(x + h / 2.0, y + k1 / 2.0);
                double k3 = h * f(x + h / 2.0, y + k2 / 2.0);
                double k4 = h * f(x + h, y + k3);

                y = y + (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;
                x = x + h;

                System.out.printf("x%d: %.4f, y%d: %.4f%n", i + 1, x, i + 1, y);
            }
        }

        public static void main(String[] args) {
            // Valores iniciales
            double x0 = 0.0;
            double y0 = 1.0;
            // Tamaño del paso
            double h = 0.1;
            // Número de iteraciones
            int n = 10;

            // Llamamos al método de Runge-Kutta
            metodoRungeKutta(x0, y0, h, n);
        }
    }

### Taylor

    public class Taylor {
        // Definimos la ecuación diferencial dy/dx = f(x, y)
        // En este ejemplo, vamos a usar dy/dx = x^2 - y
        public static double f(double x, double y) {
            return x * x - y;
        }

        // Definimos la primera derivada parcial de f con respecto a x
        public static double dfdx(double x, double y) {
            return 2 * x;
        }

        // Definimos la primera derivada parcial de f con respecto a y
        public static double dfdy(double x, double y) {
            return -1;
        }

        // Método de Taylor de segundo orden
        public static void metodoTaylor(double x0, double y0, double h, int n) {
            double x = x0;
            double y = y0;

            System.out.printf("x0: %.4f, y0: %.4f%n", x, y);

            // Iteramos n veces para obtener las aproximaciones
            for (int i = 0; i < n; i++) {
                double y1 = y + h * f(x, y) + (h * h / 2) * (dfdx(x, y) + f(x, y) * dfdy(x, y));
                y = y1;
                x = x + h;

                System.out.printf("x%d: %.4f, y%d: %.4f%n", i + 1, x, i + 1, y);
            }
        }

        public static void main(String[] args) {
            // Valores iniciales
            double x0 = 0.0;
            double y0 = 1.0;
            // Tamaño del paso
            double h = 0.1;
            // Número de iteraciones
            int n = 10;

            // Llamamos al método de Taylor
            metodoTaylor(x0, y0, h, n);
        }
    }
