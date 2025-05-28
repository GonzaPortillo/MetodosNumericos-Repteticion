# Interpolación y Ajuste de Funciones

## Introduccion

Son técnicas utilizadas en el análisis de datos y en la matemática aplicada para aproximar y modelar funciones a partir de un conjunto de datos. La interpolación es el proceso de estimar valores intermedios dentro de un rango de datos conocido. Es decir, dada una serie de puntos de datos conocidos, se utiliza la interpolación para encontrar un valor dentro de ese rango. El ajuste de funciones, también conocido como regresión, es el proceso de encontrar una función que aproxima la relación entre las variables de un conjunto de datos, pero no necesariamente pasa exactamente por los puntos de datos

1. Lineal: La forma más simple de interpolación consiste en unir dos puntos con una línea recta. Dicha técnica es llamada interpolación lineal. La notación f1(x) designa que éste es un polinomio de interpolación de primer grado. Observe que además de representar la pendiente de la línea que une los puntos, el término f(x1) – f(x0)/(x1 – x0) es una aproximación en diferencia dividida finita a la primer derivada
2. Lagrange: Es un método de interpolación polinómica que utiliza un polinomio de grado n-1 para aproximar una funciónf(x) a partir de n puntos conocidos. El polinomio de Lagrange P(x) se construye como una combinación lineal de los polinomios base de Lagrange Li(x).
3. Cuadratica: Para mejorar la estimación consiste en introducir alguna curvatura a la línea que une los puntos. Si se tienen tres puntos como datos, éstos pueden ajustarse en un polinomio de segundo grado (también conocido como polinomio cuadrático o parábola).
4. Newton: Es un método de interpolación polinómica que utiliza diferencias divididas para construir un polinomio que pasa por un conjunto de puntos dados. La fórmula de interpolación de Newton es útil porque permite agregar puntos adicionales sin recalcular el polinomio completo.

## Algoritmos

### Lineal
1. Definir los puntos conocidos.
2. Calcular la Pendiente.
3. Calcular la Intersección.
4. Formar la Ecuación de la Recta.
5. Calcular el Valor Interpolado.

### Lagrange
1. Obtener los puntos (x0, y0), (x1, y1), ..., (xn, yn).
2. Calcular los polinomios de Lagrange Li(x) para cada punto (xi, yi).
3. Construir el polinomio interpolante P(x) como la suma ponderada de los polinomios de Lagrange.
4. Evaluar el polinomio interpolante P(x) en el punto deseado x_eval.

### Cuadratica
1. Definir los puntos conocidos.
2. Formar el Sistema de Ecuaciones.
3. Resolver el Sistema de Ecuaciones.
4. Formar el Polinomio Interpolante.

### Newton
1. Obtener los puntos (x0, y0), (x1, y1), ..., (xn, yn).
2. Construir una tabla de diferencias divididas de (n+1) filas y (n+1) columnas.
3. Inicializar la primera columna de la tabla con los valores y0, y1, ..., yn.
4. Calcular las diferencias divididas f[x0, x1], f[x0, x1, x2], ..., f[x0, x1, ..., xn] usando la definición recursiva y llenar la tabla de diferencias divididas.
5. Evaluar el polinomio interpolante P(x) en el punto deseado x utilizando la fórmula de Newton y las diferencias divididas calculadas.

## Implementacion en Java

### Lineal

    public class Main {
    
        // Función para realizar la interpolación lineal
        public static double interpolacionLineal(double x1, double y1, double x2, double y2, double x) {
            // Calcular la pendiente de la recta
            double m = (y2 - y1) / (x2 - x1);
        
            // Calcular el valor de y usando la ecuación de la recta (y = mx + b)
            double y = m * (x - x1) + y1;
        
            return y;
        }
    
        public static void main(String[] args) {
            // Definir los puntos conocidos (x1, y1) y (x2, y2)
            double x1 = 7.0;
            double y1 = 14.0;
            double x2 = 10.0;
            double y2 = 21.0;
        
            // Punto para el que se quiere estimar el valor de y
            double x = 9;
        
            // Calcular el valor interpolado de y
            double y = interpolacionLineal(x1, y1, x2, y2, x);
        
            // Imprimir el resultado
            System.out.println("El valor interpolado de y para x = " + x + " es: " + y);
        }
    }

### Lagrange

    public class LagrangeInterpolation {

        // Método para calcular el polinomio de interpolación de Lagrange
        public static double lagrangeInterpolation(double[] x, double[] y, double xi) {
            double result = 0.0;
            int n = x.length;

            for (int i = 0; i < n; i++) {
                double term = y[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        term = term * (xi - x[j]) / (x[i] - x[j]);
                    }
                }
                result += term;
            }
            return result;
        }

        public static void main(String[] args) {
            // Definir los puntos conocidos (x, y)
            double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};
            double[] y = {10.0, 15.0, 20.0, 25.0, 30.0};

            // Definir el valor de xi para interpolar
            double xi = 2.5;

            // Calcular el valor interpolado
            double yi = lagrangeInterpolation(x, y, xi);

            // Mostrar el resultado
            System.out.printf("El valor interpolado en x = %.2f es y = %.2f%n", xi, yi);
        }
    }

### Cuadratica

    public class Main {
    
        // Función para realizar la interpolación cuadrática
        public static double interpolacionCuadratica(double x1, double y1, 
                                                 double x2, double y2, 
                                                 double x3, double y3, 
                                                 double x) {
            // Calcular los coeficientes de la función cuadrática
            double a = ((y2 - y1) / ((x2 - x1) * (x2 - x1))) 
                 - ((y3 - y1) / ((x3 - x1) * (x3 - x1))) 
                 + ((y3 - y2) / ((x3 - x2) * (x3 - x2)));
        
            double b = ((y2 - y1) / (x2 - x1)) - a * (x1 + x2);
        
            double c = y1 - a * x1 * x1 - b * x1;
        
            // Calcular el valor de y usando la ecuación de la función cuadrática
            double y = a * x * x + b * x + c;
        
            return y;
        }
    
        public static void main(String[] args) {
            // Definir los puntos conocidos (x1, y1), (x2, y2) y (x3, y3)
            double x1 = 10.0;
            double y1 = 21.0;
            double x2 = 13.0;
            double y2 = 28.0;
            double x3 = 16.0;
            double y3 = 19.0;
        
            // Punto para el que se quiere estimar el valor de y
            double x = 9;
        
            // Calcular el valor interpolado de y
            double y = interpolacionCuadratica(x1, y1, x2, y2, x3, y3, x);
        
            // Imprimir el resultado
            System.out.println("El valor interpolado de y para x = " + x + " es: " + y);
        }
    }

### Newton

    public class NewtonInterpolation {

        public static double[] calculateCoefficients(double[] x, double[] y) {
            int n = x.length;
            double[] coefficients = y.clone();
            for (int j = 1; j < n; j++) {
                for (int i = n - 1; i >= j; i--) {
                    coefficients[i] = (coefficients[i] - coefficients[i - 1]) / (x[i] - x[i - j]);
                }
            }
            return coefficients;
        }

        public static double interpolate(double[] x, double[] coefficients, double value) {
            double result = coefficients[coefficients.length - 1];
            for (int i = coefficients.length - 2; i >= 0; i--) {
                result = coefficients[i] + (value - x[i]) * result;
            }
            return result;
        }

        public static void main(String[] args) {
            double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};
            double[] y = {2.0, 3.0, 5.0, 7.0, 11.0};

            double[] coefficients = calculateCoefficients(x, y);

            // Example interpolation
            double valueToInterpolate = 2.5;
            double interpolatedValue = interpolate(x, coefficients, valueToInterpolate);
            System.out.println("Interpolated value at x = " + valueToInterpolate + ": " + interpolatedValue);
        }
    }

