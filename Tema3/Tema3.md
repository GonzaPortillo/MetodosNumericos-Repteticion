# Métodos de Solución de Sistemas de Ecuaciones


## Introduccion

Los métodos de solución de sistemas de ecuaciones son procedimientos matemáticos que se utilizan para encontrar las soluciones de un conjunto de ecuaciones simultáneas. En el contexto de la materia de Métodos Numéricos, se abordan técnicas específicas para resolver sistemas de ecuaciones de manera aproximada, especialmente cuando las soluciones exactas no son prácticas de obtener o cuando se trabaja con sistemas grandes y complejos.

Los metodos que veremos en esta ocacion son:

1. Eliminacion Gaussiana: Es un método algebraico utilizado para resolver sistemas de ecuaciones lineales. Consiste en transformar el sistema de ecuaciones en una forma escalonada (triangular superior) utilizando operaciones elementales de fila. Una vez en esta forma, se aplica la sustitución regresiva para encontrar las soluciones del sistema.
2. Gauss-Jordan: Es una extensión del método de eliminación gaussiana que transforma una matriz en su forma reducida por filas (forma escalonada reducida). Este método no solo convierte la matriz en una forma triangular superior, sino que también elimina todos los coeficientes por debajo y por encima de los pivotes, resultando en una matriz identidad en el lado izquierdo de la matriz aumentada.
3. Gauss-Seidel: Es un método iterativo utilizado para resolver sistemas de ecuaciones lineales. A diferencia de los métodos directos como la eliminación gaussiana, los métodos iterativos generan una sucesión de aproximaciones que convergen a la solución exacta.
4. Metodo de Jacobi: Método iterativo utilizado para resolver sistemas de ecuaciones lineales. En este método, cada componente del vector solución se calcula utilizando únicamente los valores de la iteración anterior. A diferencia del método de Gauss-Seidel, el método de Jacobi no usa las aproximaciones más recientes dentro de la misma iteración.

## Algoritmos

### Eliminacion Gaussiana:

1. Formación de la Matriz Aumentada: Formar la matriz aumentada del sistema de ecuaciones A|b donde A es la matriz de coeficientes y b es el vector de términos independientes.
2. Transformación a Forma Escalonada: Para cada fila i desde 1 hasta n.
3. Pivoteo: Seleccionar el elemento con el mayor valor absoluto en la columna i de las filas i a n (pivoteo parcial) y permutar la fila actual con la fila del pivote si es necesario.
4. Eliminación hacia adelante: Para cada fila j desde +i+1 hasta n.
5. Sustitución Regresiva: Inicializar el vector solución x de tamaño n.

### Gauss-Jordan

1. Definir la matriz de coeficientes ( A ) y el vector de términos independientes ( b ).
2. Construir la matriz aumentada ([A | b]).
3. Aplicar las operaciones de fila para transformar la matriz aumentada en la forma ([I | x]), donde ( I ) es la matriz identidad.
4. El vector resultante en la columna de términos independientes es la solución ( x ).

### Gauss-Seidel

1.Inicializar las soluciones (x_0^{(0)}, x_1^{(0)}, ..., x_n^{(0)}) de manera arbitraria o utilizando valores aproximados.
2. Para cada ecuación (i) en el sistema, calcular (x_i^{(k+1)}) utilizando las soluciones calculadas en la iteración (k).
3. Repetir el paso 2 hasta que se satisfaga un criterio de convergencia (por ejemplo, la diferencia entre dos iteraciones consecutivas sea menor que una tolerancia predefinida).

### Metodo de Jacobi

1.-Inicialización: Comienza con una estimación inicial de las soluciones del sistema de ecuaciones lineales 𝐴𝑥=𝑏. Puedes empezar con un vector 𝑥^(0). 
2.-Iteraciones: Para cada iteración 𝑘. 
3.-Criterio de parada: Repite el paso 2 hasta que se cumpla algún criterio de parada. Un criterio común es que la diferencia entre dos iteraciones consecutivas sea menor que una cierta tolerancia predefinida, o hasta que se alcance un número máximo de iteraciones. 
4.-Salida: El vector 𝑥^(𝑘)será la aproximación de la solución del sistema de ecuaciones lineales.

## Implementacion en Java

### Eliminacion Gaussiana:

    public class EliminacionGaussiana {

        public static void main(String[] args) {
            double[][] matriz = {
                {2, 1, -1, 8},
                {-3, -1, 2, -11},
                {-2, 1, 2, -3}
            };
        
            double[] solucion = resolverSistema(matriz);
        
            // Imprimir la solución
            for (int i = 0; i < solucion.length; i++) {
                System.out.println("x" + (i+1) + " = " + solucion[i]);
            }
        }

        public static double[] resolverSistema(double[][] matriz) {
            int n = matriz.length;
        
            // Eliminación hacia adelante
            for (int i = 0; i < n - 1; i++) {
                for (int k = i + 1; k < n; k++) {
                    double factor = matriz[k][i] / matriz[i][i];
                    for (int j = i; j < n + 1; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                }
            }
        
            // Sustitución hacia atrás
            double[] solucion = new double[n];
            for (int i = n - 1; i >= 0; i--) {
                solucion[i] = matriz[i][n];
                for (int j = i + 1; j < n; j++) {
                    solucion[i] -= matriz[i][j] * solucion[j];
                }
                solucion[i] /= matriz[i][i];
            }
        
            return solucion;
        }
    }


### Gauss-Jordan

    public class GaussJordan {
    
        public static void main(String[] args) {
            double[][] matriz = {
                {2, 1, -1, 8},
                {-3, -1, 2, -11},
                {-2, 1, 2, -3}
            };
        
            gaussJordan(matriz);
        
            System.out.println("Solución del sistema de ecuaciones:");
            for (int i = 0; i < matriz.length; i++) {
                System.out.println("x" + (i+1) + " = " + matriz[i][matriz[i].length-1]);
            }
        }
    
        public static void gaussJordan(double[][] matriz) {
            int filas = matriz.length;
            int columnas = matriz[0].length;
        
            for (int i = 0; i < filas; i++) {
                // Pivoteo parcial
                int maxFila = i;
                for (int k = i + 1; k < filas; k++) {
                    if (Math.abs(matriz[k][i]) > Math.abs(matriz[maxFila][i])) {
                        maxFila = k;
                    }
                }
                // Intercambiar filas
                double[] temp = matriz[maxFila];
                matriz[maxFila] = matriz[i];
                matriz[i] = temp;
            
                // Hacer la columna i de la diagonal igual a 1
                double pivote = matriz[i][i];
                for (int j = i; j < columnas; j++) {
                    matriz[i][j] /= pivote;
                }
            
                // Hacer 0 el resto de elementos en la columna
                for (int k = 0; k < filas; k++) {
                    if (k != i) {
                        double factor = matriz[k][i];
                        for (int j = i; j < columnas; j++) {
                            matriz[k][j] -= factor * matriz[i][j];
                        }
                    }
                }
            }
        }
    }


### Gauss-Seidel

    public class GaussSeidel {
    
        // Método para resolver el sistema de ecuaciones usando Gauss-Seidel
        public static double[] gaussSeidel(double[][] A, double[] b, double tol, int maxIter) {
            int n = A.length;
            double[] x = new double[n]; // Vector de solución
            double[] x_new = new double[n]; // Vector de solución actualizado
        
            // Inicializar el vector de solución
            for (int i = 0; i < n; i++) {
                x[i] = 0;
            }
        
            int iter = 0;
            double error = tol + 1; // Error inicial
            while (error > tol && iter < maxIter) {
                for (int i = 0; i < n; i++) {
                    double sum = 0;
                    for (int j = 0; j < n; j++) {
                        if (j != i) {
                            sum += A[i][j] * x[j];
                        }
                    }
                    x_new[i] = (b[i] - sum) / A[i][i];
                }
            
                // Calcular el error
                error = 0;
                for (int i = 0; i < n; i++) {
                    error = Math.max(error, Math.abs(x_new[i] - x[i]));
                }
            
                // Actualizar el vector de solución
                for (int i = 0; i < n; i++) {
                    x[i] = x_new[i];
                }
            
                iter++;
            }
        
            if (iter == maxIter) {
                System.out.println("El método no convergió después de " + maxIter + " iteraciones.");
            }
        
            return x;
        }
    
        public static void main(String[] args) {
            double[][] A = {{10, 2, 1}, {1, 5, 1}, {2, 3, 10}}; // Matriz de coeficientes
            double[] b = {7, -8, 6}; // Vector de términos constantes
            double tol = 1e-6; // Tolerancia
            int maxIter = 1000; // Máximo número de iteraciones
        
            // Resolver el sistema de ecuaciones
            double[] x = gaussSeidel(A, b, tol, maxIter);
        
            // Imprimir la solución
            System.out.println("La solución del sistema es:");
            for (int i = 0; i < x.length; i++) {
                System.out.println("x[" + i + "] = " + x[i]);
            }
        }
    }


### Metodo de Jacobi

    public class JacobiMethod {
        // Método para resolver el sistema de ecuaciones usando el método de Jacobi
        public static double[] jacobi(double[][] A, double[] b, int iterations) {
            int n = A.length;
            double[] x = new double[n]; // Vector inicial
            double[] x_new = new double[n]; // Vector para almacenar los nuevos valores
        
            // Iterar hasta que se alcance el número deseado de iteraciones
            for (int iter = 0; iter < iterations; iter++) {
                // Calcular los nuevos valores de x
                for (int i = 0; i < n; i++) {
                    double sum = 0.0;
                    for (int j = 0; j < n; j++) {
                        if (j != i) {
                            sum += A[i][j] * x[j];
                        }
                    }
                    x_new[i] = (b[i] - sum) / A[i][i];
                }
            
                // Actualizar x
                for (int i = 0; i < n; i++) {
                    x[i] = x_new[i];
                }
            }
        
            return x;
        }
    
        public static void main(String[] args) {
            // Definir el sistema de ecuaciones Ax = b
            double[][] A = {{4, -1, 0}, {-1, 4, -1}, {0, -1, 3}};
            double[] b = {5, -10, 5};
        
            // Número de iteraciones
            int iterations = 25;
        
            // Resolver el sistema usando el método de Jacobi
            double[] solution = jacobi(A, b, iterations);
        
            // Imprimir la solución
            System.out.println("La solución al sistema de ecuaciones es:");
            for (int i = 0; i < solution.length; i++) {
                System.out.println("x[" + i + "] = " + solution[i]);
            }
        }
    }
