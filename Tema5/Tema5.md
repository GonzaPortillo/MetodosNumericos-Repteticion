[ <- Regresar](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/tree/main)

# Interpolación y Ajuste de Funciones

## Introduccion

Son técnicas utilizadas en el análisis de datos y en la matemática aplicada para aproximar y modelar funciones a partir de un conjunto de datos. La interpolación es el proceso de estimar valores intermedios dentro de un rango de datos conocido. Es decir, dada una serie de puntos de datos conocidos, se utiliza la interpolación para encontrar un valor dentro de ese rango. El ajuste de funciones, también conocido como regresión, es el proceso de encontrar una función que aproxima la relación entre las variables de un conjunto de datos, pero no necesariamente pasa exactamente por los puntos de datos

1. **Interpolacion Lineal**: Es la forma más sencilla de interpolación. Consiste en unir pares de puntos consecutivos mediante líneas rectas. La función interpolante es de primer grado, y estima un valor intermedio basándose únicamente en los dos puntos más cercanos. Aunque simple, es útil cuando se desea una estimación rápida y los datos no presentan mucha curvatura.

2. **Interpolacion Polinomica**: Este método utiliza un polinomio de grado n-1 (siendo n el número de puntos conocidos) que pasa exactamente por todos los puntos del conjunto de datos. A medida que se agregan más puntos, el grado del polinomio aumenta, lo que puede llevar a oscilaciones no deseadas (fenómeno de Runge). No obstante, es una herramienta poderosa cuando se requiere una función suave y continua que pase por todos los datos.

3. **Metodo de Correlacion**: La correlación evalúa el grado de relación lineal entre dos variables. No se trata de una técnica de interpolación directa, pero es fundamental para el análisis de ajuste. Un coeficiente de correlación cercano a 1 o -1 indica una fuerte relación lineal, mientras que valores cercanos a 0 indican que no existe una relación lineal clara entre las variables.

4. **Metodo de minimos cuadrados**: Es uno de los métodos más utilizados para el ajuste de funciones. Consiste en encontrar una función (usualmente una recta o un polinomio) que minimice la suma de los errores al cuadrado entre los valores reales y los valores predichos por la función. A diferencia de la interpolación, esta función no necesariamente pasa por todos los puntos, pero proporciona una representación global más estable, especialmente cuando los datos contienen ruido.

5. **Metodo de Regresion**: La regresión es un tipo específico de ajuste de funciones que busca modelar la relación entre una variable dependiente y una o más variables independientes. Puede ser lineal (regresión lineal simple o múltiple) o no lineal, dependiendo de la forma del modelo. La regresión no solo estima valores, sino que también permite hacer inferencias estadísticas y predicciones a partir del modelo obtenido.

## Interpolacion Lineal

### Algoritmo

1. Se tienen dos puntos conocidos:  
   \( (x_0, y_0) \) y \( (x_1, y_1) \)
2. Se desea estimar el valor \( y \) en un punto \( x \) intermedio.
3. Se aplica la fórmula de interpolación lineal:  
   \[
   y = y_0 + \left( \frac{y_1 - y_0}{x_1 - x_0} \right) \cdot (x - x_0)
   \]
4. Se retorna el valor de \( y \).

### Pseudocódigo

```
Inicio
    Leer x0, y0, x1, y1, x
    Calcular:
        y ← y0 + ((y1 - y0) / (x1 - x0)) * (x - x0)
    Mostrar y
Fin
```

### Codigo en Java

```Java
public class InterpolacionLineal {

    // Método para interpolar linealmente
    public static double interpolarLineal(double x0, double y0, double x1, double y1, double x) {
        // Fórmula: y = y0 + ((y1 - y0) / (x1 - x0)) * (x - x0)
        return y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
    }

    public static void main(String[] args) {
        // Datos conocidos (peso en kg, precio en $)
        double peso1 = 0.5;
        double precio1 = 1.50;
        double peso2 = 1.0;
        double precio2 = 2.80;

        // Peso para el que queremos estimar el precio
        double pesoDeseado = 0.75;

        // Aplicamos interpolación lineal
        double precioEstimado = interpolarLineal(peso1, precio1, peso2, precio2, pesoDeseado);

        // Mostramos el resultado
        System.out.println("Precio estimado para " + pesoDeseado + " kg de manzanas: $" + String.format("%.2f", precioEstimado));
    }
}
```

### Caso de prueba

Datos de entrada
```
x0 = 0.5
y0 = 1.50
x1 = 1.0
y1 = 2.80
x = 0.75
```

Salida esperada
```
Precio estimado para 0.75 kg de manzanas: $2.15
```

### Codigos

1. [Ejemplo 1]()
2. [Ejemplo 2]()
3. [Ejemplo 3]()
4. [Ejemplo 4]()
5. [Ejemplo 5]()

## Interpolacion Polinomica

### Algoritmo


1. Definir las coordenadas conocidas \( x = [x_0, x_1, ..., x_{n-1}] \) y \( y = [y_0, y_1, ..., y_{n-1}] \).
2. Definir el punto de evaluación \( x_{eval} \).
3. Inicializar el resultado `result` en 0.
4. Para cada índice \( i \) de 0 a \( n-1 \):
   - Inicializar `term` con \( y_i \).
   - Para cada índice \( j \) de 0 a \( n-1 \) donde \( j \neq i \):
     - Multiplicar `term` por \(\frac{x_{eval} - x_j}{x_i - x_j}\).
   - Sumar `term` a `result`.
5. Retornar `result` como el valor interpolado en \( x_{eval} \).

### Pseudocódigo

```
Para i ← 0 hasta n-1 hacer:
    term ← y[i]
    Para j ← 0 hasta n-1 hacer:
        Si j ≠ i entonces:
            term ← term * (xEval - x[j]) / (x[i] - x[j])
    result ← result + term

retornar result
```

### Codigo en Java

```java
public class Main {

    // Método que aplica interpolación de Lagrange
    public static double lagrange(double[] x, double[] y, double xEval) {
        double result = 0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term *= (xEval - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        // Coordenadas conocidas
        double[] x = {0, 1, 2}; // Coordenadas x
        double[] y = {1, 3, 2}; // Coordenadas y

        // Punto a evaluar
        double xEval = 1.5;

        // Evaluación usando interpolación de Lagrange
        double resultado = lagrange(x, y, xEval);

        // Mostrar resultado
        System.out.printf("Problema 1: P(%.1f) = %.3f\n", xEval, resultado);
    }
}
```

### Caso de prueba

Datos de entrada
```
x ← [0, 1, 2]
y ← [1, 3, 2]
xEval ← 1.5
```

Salida esperada
```
Problema 1: P(1.5) = 2.250
```

### Codigos

1. [Ejemplo 1]()
2. [Ejemplo 2]()
3. [Ejemplo 3]()
4. [Ejemplo 4]()
5. [Ejemplo 5]()

## Metodo de Correlacion

### Algoritmo
1. **Inicialización**:
   - Recibir los vectores `x[]` y `y[]` de valores conocidos.
   - Crear una tabla de diferencias divididas de tamaño `n x n`.

2. **Llenado de la tabla**:
   - La primera columna de la tabla es igual a `y[]`.
   - Para cada columna \( j \) desde 1 hasta \( n - 1 \), calcular:
     \[
     tabla[i][j] = \frac{tabla[i+1][j-1] - tabla[i][j-1]}{x[i+j] - x[i]}
     \]

3. **Evaluación del polinomio**:
   - Inicializar `resultado = tabla[0][0]`.
   - Para cada término del polinomio, multiplicar sucesivamente \( (xEval - x[i]) \) y sumar el producto del coeficiente correspondiente.

### Pseudocódigo

```
Función diferenciasDivididas(x[], y[]):
n ← longitud(x)
Crear tabla[n][n]

Para i ← 0 hasta n-1:
    tabla[i][0] ← y[i]

Para j ← 1 hasta n-1:
    Para i ← 0 hasta n-j-1:
        tabla[i][j] ← (tabla[i+1][j-1] - tabla[i][j-1]) / (x[i+j] - x[i])

retornar tabla

Función evaluarNewton(x[], tabla[][], xEval):
resultado ← tabla[0][0]
producto ← 1

Para i ← 1 hasta n-1:
    producto ← producto * (xEval - x[i-1])
    resultado ← resultado + tabla[0][i] * producto

retornar resultado
```

### Codigo en Java

```java
public class Main {

    // Método para calcular diferencias divididas
    public static double[][] diferenciasDivididas(double[] x, double[] y) {
        int n = x.length;
        double[][] tabla = new double[n][n];

        // Inicializar primera columna con los valores de y[]
        for (int i = 0; i < n; i++) {
            tabla[i][0] = y[i];
        }

        // Calcular las diferencias divididas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i + 1][j - 1] - tabla[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        return tabla;
    }

    // Evaluar el polinomio de Newton en xEval
    public static double evaluarNewton(double[] x, double[][] tabla, double xEval) {
        double resultado = tabla[0][0];
        double producto = 1;

        for (int i = 1; i < x.length; i++) {
            producto *= (xEval - x[i - 1]);
            resultado += tabla[0][i] * producto;
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Puntos conocidos
        double[] x = {0, 1, 2};
        double[] y = {1, 3, 2};

        // Punto a evaluar
        double xEval = 1.5;

        // Calcular tabla de diferencias divididas
        double[][] tabla = diferenciasDivididas(x, y);

        // Evaluar el polinomio en el punto deseado
        double resultado = evaluarNewton(x, tabla, xEval);

        // Mostrar resultado
        System.out.printf("Problema 2 (Newton): P(%.1f) = %.3f\n", xEval, resultado);
    }
}
```

### Caso de prueba
Datos de entrada
```
x ← [0, 1, 2]
y ← [1, 3, 2]
xEval ← 1.5
```

Salida esperada
```
Problema 2 (Newton): P(1.5) = 2.250
```

### Codigos

1. [Ejemplo 1]()
2. [Ejemplo 2]()
3. [Ejemplo 3]()
4. [Ejemplo 4]()
5. [Ejemplo 5]()

## Metodo de minimos cuadrados

### Algoritmo

1. Inicializar vectores x e y con los puntos conocidos.
2. Calcular la longitud n del arreglo.
3. Inicializar sumatorias: sumX, sumY, sumXY, sumX2 a 0.
4. Recorrer los datos desde i = 0 hasta n - 1:
   - sumX += x[i]
   - sumY += y[i]
   - sumXY += x[i] * y[i]
   - sumX2 += x[i] * x[i]
5. Calcular pendiente (m):
   - m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX^2)
6. Calcular ordenada al origen (b):
   - b = (sumY - m * sumX) / n
7. Imprimir la ecuación de la recta: y = mx + b

### Pseudocódigo

```
Función mínimosCuadrados(x[], y[]):
    n ← longitud(x)
    sumX ← 0
    sumY ← 0
    sumXY ← 0
    sumX2 ← 0

    Para i ← 0 hasta n-1 hacer:
        sumX ← sumX + x[i]
        sumY ← sumY + y[i]
        sumXY ← sumXY + x[i] * y[i]
        sumX2 ← sumX2 + x[i] * x[i]

    m ← (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX)
    b ← (sumY - m * sumX) / n

    Retornar m, b
```

### Codigo en Java

```java
public class MinimosCuadrados {
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 4, 5, 4, 5};
        int n = x.length;

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        double m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double b = (sumY - m * sumX) / n;

        System.out.printf("Problema 1: y = %.2fx + %.2f%n", m, b);
    }
} 
```

### Caso de prueba

Entrada:
```
x = [1, 2, 3, 4, 5]
y = [2, 4, 5, 4, 5]
```

Salida esperada:
```
y = 0.60x + 2.20
```


### Codigos

1. [Ejemplo 1]()
2. [Ejemplo 2]()
3. [Ejemplo 3]()
4. [Ejemplo 4]()
5. [Ejemplo 5]()

## Metodo de regresion

### Algoritmo

1. Inicializar los arreglos `x` y `y` con los datos conocidos.
2. Determinar el número de puntos `n`.
3. Inicializar las sumatorias: `sumX`, `sumY`, `sumXY`, `sumX2` en 0.
4. Para cada i desde 0 hasta n - 1:
   - sumX += x[i]
   - sumY += y[i]
   - sumXY += x[i] * y[i]
   - sumX2 += x[i] * x[i]
5. Calcular coeficiente `b`:
   - b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX^2)
6. Calcular coeficiente `a`:
   - a = (sumY - b * sumX) / n
7. Imprimir la ecuación: `y = a + bx`

### Pseudocódigo

```
Función regresiónLineal(x[], y[]):
    n ← longitud(x)
    sumX ← 0
    sumY ← 0
    sumXY ← 0
    sumX2 ← 0

    Para i desde 0 hasta n - 1 hacer:
        sumX ← sumX + x[i]
        sumY ← sumY + y[i]
        sumXY ← sumXY + x[i] * y[i]
        sumX2 ← sumX2 + x[i] * x[i]

    b ← (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX)
    a ← (sumY - b * sumX) / n

    Retornar a, b
```

### Codigo en Java

```java
public class Main {
    public static void main(String[] args) {
        double[] x = {1, 2, 3};
        double[] y = {2, 3, 5};
        int n = x.length;

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double a = (sumY - b * sumX) / n;

        System.out.printf("Problema 1: y = %.3f + %.3fx\n", a, b);
    }
}
```

### Caso de prueba

Entrada:
```
x = [1, 2, 3]  
y = [2, 3, 5]
```

Salida esperada:
```
y = 0.333 + 1.500x
```

### Codigos

1. [Ejemplo 1]()
2. [Ejemplo 2]()
3. [Ejemplo 3]()
4. [Ejemplo 4]()
5. [Ejemplo 5]()

