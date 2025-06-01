# Métodos de Solución de Sistemas de Ecuaciones


## Introduccion

Los métodos de solución de sistemas de ecuaciones son procedimientos matemáticos que se utilizan para encontrar las soluciones de un conjunto de ecuaciones simultáneas. En el contexto de la materia de Métodos Numéricos, se abordan técnicas específicas para resolver sistemas de ecuaciones de manera aproximada, especialmente cuando las soluciones exactas no son prácticas de obtener o cuando se trabaja con sistemas grandes y complejos.

Los metodos que veremos en esta ocacion son:

1. Eliminacion Gaussiana: Es un método algebraico utilizado para resolver sistemas de ecuaciones lineales. Consiste en transformar el sistema de ecuaciones en una forma escalonada (triangular superior) utilizando operaciones elementales de fila. Una vez en esta forma, se aplica la sustitución regresiva para encontrar las soluciones del sistema.
2. Gauss-Jordan: Es una extensión del método de eliminación gaussiana que transforma una matriz en su forma reducida por filas (forma escalonada reducida). Este método no solo convierte la matriz en una forma triangular superior, sino que también elimina todos los coeficientes por debajo y por encima de los pivotes, resultando en una matriz identidad en el lado izquierdo de la matriz aumentada.
3. Gauss-Seidel: Es un método iterativo utilizado para resolver sistemas de ecuaciones lineales. A diferencia de los métodos directos como la eliminación gaussiana, los métodos iterativos generan una sucesión de aproximaciones que convergen a la solución exacta.
4. Metodo de Jacobi: Método iterativo utilizado para resolver sistemas de ecuaciones lineales. En este método, cada componente del vector solución se calcula utilizando únicamente los valores de la iteración anterior. A diferencia del método de Gauss-Seidel, el método de Jacobi no usa las aproximaciones más recientes dentro de la misma iteración.

## Eliminacion Gaussiana

### Algoritmo

1. **Inicializar** la matriz aumentada del sistema de ecuaciones.

2. **Para** cada fila \( i \) desde la primera hasta la penúltima:
    1. **Para** cada fila \( k \) debajo de la fila \( i \) (es decir, \( k = i+1 \) hasta el final):
        1. Calcular el **factor**:  
           \[
           \text{factor} = \frac{a_{k,i}}{a_{i,i}}
           \]
        2. **Para** cada columna \( j \) desde la columna \( i \) hasta la última (incluyendo términos independientes):
           - Actualizar el elemento:  
             \[
             a_{k,j} = a_{k,j} - \text{factor} \times a_{i,j}
             \]
             
3. **Inicializar** un vector solución con tamaño igual al número de incógnitas.
4. **Para** cada fila \( i \) desde la última hasta la primera (en orden inverso):
    1. Asignar el término independiente como valor inicial para \( x_i \):  
       \[
       x_i = a_{i,n}
       \]

    3. **Para** cada columna \( j \) desde \( i+1 \) hasta el número de incógnitas:
       - Restar el producto de los coeficientes y soluciones ya calculadas:  
         \[
         x_i = x_i - a_{i,j} \times x_j
         \]
   
    4. Dividir por el coeficiente diagonal para despejar \( x_i \):  
       \[
       x_i = \frac{x_i}{a_{i,i}}
       \]
    
5. **Retornar** el vector solución con los valores de las incógnitas.

### Pseudocódigo

```
Función resolverSistema(matriz):
    n ← número de filas de matriz

    Para i desde 0 hasta n-2:
        Para k desde i+1 hasta n-1:
            factor ← matriz[k][i] / matriz[i][i]
            Para j desde i hasta n:
                matriz[k][j] ← matriz[k][j] - factor * matriz[i][j]

    Crear arreglo solucion de tamaño n

    Para i desde n-1 hasta 0 (decreciendo):
        solucion[i] ← matriz[i][n]
        Para j desde i+1 hasta n-1:
            solucion[i] ← solucion[i] - matriz[i][j] * solucion[j]
        solucion[i] ← solucion[i] / matriz[i][i]

    Retornar solucion
```

### Codigo en Java

```java
public class EliminacionGaussiana {

    public static void main(String[] args) {
        double[][] matriz = {
            {2, 1, -1, 8},
            {-3, -1, 2, -11},
            {-2, 1, 2, -3}
        };
    
        double[] solucion = resolverSistema(matriz);
    
        for (int i = 0; i < solucion.length; i++) {
            System.out.println("x" + (i+1) + " = " + solucion[i]);
        }
    }

    public static double[] resolverSistema(double[][] matriz) {
        int n = matriz.length;
    
        for (int i = 0; i < n - 1; i++) {
            for (int k = i + 1; k < n; k++) {
                double factor = matriz[k][i] / matriz[i][i];
                for (int j = i; j < n + 1; j++) {
                    matriz[k][j] -= factor * matriz[i][j];
                }
            }
        }
    
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
```

### Caso de prueba

Valor de entrada
```
{
  {2, 1, -1, 8},
  {-3, -1, 2, -11},
  {-2, 1, 2, -3}
}
```
Salida esperada
```
x1 = 2.0
x2 = 3.0
x3 = -1.0
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Eliminacion%20Gausiana/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Eliminacion%20Gausiana/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Eliminacion%20Gausiana/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Eliminacion%20Gausiana/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Eliminacion%20Gausiana/Ejemplo5.java)

## Gauss Jordan

### Algoritmo

# Algoritmo Método de Gauss-Jordan

1. **Inicializar** la matriz aumentada del sistema de ecuaciones.
2. **Para** cada fila \( i \) desde la primera hasta la última:
    1. Encontrar la fila con el valor absoluto máximo en la columna \( i \) desde la fila \( i \) hacia abajo, para evitar divisiones por cero o problemas numéricos. Denotar esta fila como `maxFila`.
    2. Intercambiar la fila \( i \) con la fila `maxFila`.
    3. Dividir toda la fila \( i \) por el pivote \( a_{i,i} \) para que el pivote sea 1.
    4. **Para** cada fila \( k \) diferente de \( i \) (es decir, todas las demás filas):
        1. Calcular el factor \( \text{factor} = a_{k,i} \).
        2. Restar a la fila \( k \) el producto del factor por la fila \( i \):  
           \[
           a_{k,j} = a_{k,j} - \text{factor} \times a_{i,j} \quad \forall j
           \]
           Esto hace que todos los elementos de la columna \( i \), excepto el pivote, queden en cero.

3. La matriz queda en forma escalonada reducida, con los valores de las incógnitas en la última columna.
4. **Leer** las soluciones \( x_i = a_{i,n} \), donde \( n \) es el índice de la columna de términos independientes.
5. **Retornar** el vector solución con los valores de las incógnitas.


### Pseudocódigo

```
Función GaussJordan(matriz):
    filas ← número de filas en matriz
    columnas ← número de columnas en matriz

    Para i desde 0 hasta filas - 1:
        maxFila ← i
        Para k desde i + 1 hasta filas - 1:
            Si |matriz[k][i]| > |matriz[maxFila][i]|:
                maxFila ← k

        Intercambiar matriz[i] con matriz[maxFila]

        pivote ← matriz[i][i]
        Para j desde i hasta columnas - 1:
            matriz[i][j] ← matriz[i][j] / pivote

        Para k desde 0 hasta filas - 1:
            Si k ≠ i:
                factor ← matriz[k][i]
                Para j desde i hasta columnas - 1:
                    matriz[k][j] ← matriz[k][j] - factor * matriz[i][j]

    Retornar matriz

```

### Codigo en Java

```java
public class Problema_1 {

    public static void main(String[] args) {
        double[][] matriz = {
            {2, 1, -1, 8},
            {-3, -1, 2, -11},
            {-2, 1, 2, -3}
        };
    
        double[] solucion = resolverSistema(matriz);
    
        for (int i = 0; i < solucion.length; i++) {
            System.out.println("x" + (i+1) + " = " + solucion[i]);
        }
    }

    public static double[] resolverSistema(double[][] matriz) {
        int n = matriz.length;
    
        for (int i = 0; i < n - 1; i++) {
            for (int k = i + 1; k < n; k++) {
                double factor = matriz[k][i] / matriz[i][i];
                for (int j = i; j < n + 1; j++) {
                    matriz[k][j] -= factor * matriz[i][j];
                }
            }
        }
    
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
```

### Caso de prueba

Valores de entrada
```
[
    [2,  1, -1,  8],
    [-3, -1, 2, -11],
    [-2, 1,  2, -3]
]

```

```
x1 = 2.0
x2 = 3.0
x3 = -1.0
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Gauss%20Jordan/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Gauss%20Jordan/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Gauss%20Jordan/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Gauss%20Jordan/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Gauss%20Jordan/Ejemplo5.java)

## Gauss Seidel

### Algoritmo

1. **Inicializar:**
   - Sea \( n \) el número de ecuaciones (tamaño de la matriz \( A \)).
   - Inicializar el vector solución \( x = [0, 0, ..., 0] \).
   - Establecer el número de iteraciones a 0.
   - Establecer un valor inicial para el error mayor que la tolerancia deseada.

2. **Repetir mientras el error sea mayor que la tolerancia y el número de iteraciones sea menor que el máximo permitido:**
   1. Para cada variable \( i = 0, 1, ..., n-1 \):
      - Calcular la suma:  
      \[
      \text{suma} = \sum_{\substack{j=0 \\ j \neq i}}^{n-1} A[i][j] \cdot x[j]
      \]
      - Actualizar la solución para la variable \( i \):  
      \[
      x_{\text{nuevo}}[i] = \frac{b[i] - \text{suma}}{A[i][i]}
      \]

3. **Calcular el error máximo:**  
\[
\text{error} = \max_{0 \leq i < n} |x_{\text{nuevo}}[i] - x[i]|
\]

4. **Actualizar el vector solución:**  
\[
x = x_{\text{nuevo}}
\]

5. **Incrementar el contador de iteraciones.**

6. **Si el número máximo de iteraciones se alcanza y el error es mayor que la tolerancia, mostrar mensaje de no convergencia.**

7. **Retornar el vector solución \( x \).**

### Pseudocódigo

```
Función GaussSeidel(A, b, tol, maxIter):
    n ← número de filas de A
    x ← vector de tamaño n inicializado en 0
    iter ← 0
    error ← tol + 1

    Mientras error > tol y iter < maxIter:
        Para i desde 0 hasta n-1:
            suma ← 0
            Para j desde 0 hasta n-1:
                Si j ≠ i:
                    suma ← suma + A[i][j] * x[j]

            x_new[i] ← (b[i] - suma) / A[i][i]

        error ← 0
        Para i desde 0 hasta n-1:
            error ← max(error, |x_new[i] - x[i]|)

        Para i desde 0 hasta n-1:
            x[i] ← x_new[i]

        iter ← iter + 1

    Si iter = maxIter:
        Mostrar "El método no convergió después de maxIter iteraciones."

    Retornar x

```

### Codigo en Java

```java
public class Problema_1 {

    public static double[] gaussSeidel(double[][] A, double[] b, double tol, int maxIter) {
        int n = A.length;
        double[] x = new double[n]; // Vector de solución
        double[] x_new = new double[n]; // Vector de solución actualizado
    
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
        
            error = 0;
            for (int i = 0; i < n; i++) {
                error = Math.max(error, Math.abs(x_new[i] - x[i]));
            }
        
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
    
        double[] x = gaussSeidel(A, b, tol, maxIter);
    
        System.out.println("La solución del sistema es:");
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
```

### Caso de prueba

Valores de entrada
```
A = [
  [10, 2, 1],
  [1, 5, 1],
  [2, 3, 10]
]

b = [7, -8, 6]

```

Salida esperada
```
x[0] ≈ 0.499979
x[1] ≈ -1.600009
x[2] ≈ 0.799994

```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Gauss%20Seidel/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Gauss%20Seidel/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Gauss%20Seidel/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Gauss%20Seidel/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Gauss%20Seidel/Ejemplo5.java)

## Metodo de Jacobi

### Algoritmo

1. Inicializar:
   - Obtener tamaño \( n \) de la matriz \( A \).
   - Crear vector \( x \) con ceros.
   - Crear vector auxiliar \( x_{\text{nuevo}} \).

2. Para cada iteración desde 1 hasta el máximo:
   - Para cada índice \( i \) desde 0 hasta \( n-1 \):
     - Calcular suma:  
       \[
       \text{suma} = \sum_{\substack{j=0 \\ j \neq i}}^{n-1} A[i][j] \times x[j]
       \]
     - Actualizar nuevo valor:  
       \[
       x_{\text{nuevo}}[i] = \frac{b[i] - \text{suma}}{A[i][i]}
       \]

3. Copiar \( x_{\text{nuevo}} \) a \( x \).

4. Repetir hasta completar todas las iteraciones.

5. Retornar \( x \) como solución aproximada.

### Pseudocódigo

```
Función Jacobi(A, b, iteraciones)
    n ← longitud de A
    x ← vector de tamaño n inicializado con 0
    x_nuevo ← vector de tamaño n

    Para iter desde 1 hasta iteraciones hacer:
        Para i desde 0 hasta n-1 hacer:
            suma ← 0
            Para j desde 0 hasta n-1 hacer:
                Si j ≠ i entonces
                    suma ← suma + A[i][j] * x[j]
            Fin Para

            x_nuevo[i] ← (b[i] - suma) / A[i][i]
        Fin Para

        Para i desde 0 hasta n-1 hacer:
            x[i] ← x_nuevo[i]
        Fin Para
    Fin Para

    Retornar x
Fin Función
```

### Codigo en Java

```java
public class Jacobi {

    public static double[] jacobi(double[][] A, double[] b, int iterations) {
        int n = A.length;
        double[] x = new double[n]; // Vector inicial
        double[] x_new = new double[n]; // Vector para almacenar los nuevos valores
    
        for (int iter = 0; iter < iterations; iter++) {
            for (int i = 0; i < n; i++) {
                double sum = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum += A[i][j] * x[j];
                    }
                }
                x_new[i] = (b[i] - sum) / A[i][i];
            }
        
            for (int i = 0; i < n; i++) {
                x[i] = x_new[i];
            }
        }
    
        return x;
    }

    public static void main(String[] args) {
        double[][] A = {{4, -1, 0}, {-1, 4, -1}, {0, -1, 3}};
        double[] b = {5, -10, 5};
    
        int iterations = 50;
    
        double[] solution = jacobi(A, b, iterations);
    
        System.out.println("La solución al sistema de ecuaciones es:");
        for (int i = 0; i < solution.length; i++) {
            System.out.println("x[" + i + "] = " + solution[i]);
        }
    }
}
```

### Caso de prueba

```
A = [
  [4, -1, 0],
  [-1, 4, -1],
  [0, -1, 3]
]

b = [5, -10, 5]
```

Salida esperada

```
La solución al sistema de ecuaciones es:
x[0] = 2.9997
x[1] = -4.9995
x[2] = 3.9997
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Metodo%20de%20Jacobi/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Metodo%20de%20Jacobi/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Metodo%20de%20Jacobi/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Metodo%20de%20Jacobi/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema3/Metodo%20de%20Jacobi/Ejemplo5.java)
