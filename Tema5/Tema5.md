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
### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos

1. [Ejemplo 1]()
2. [Ejemplo 2]()
3. [Ejemplo 3]()
4. [Ejemplo 4]()
5. [Ejemplo 5]()

## Metodo de minimos cuadrados

### Algoritmo
### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos

1. [Ejemplo 1]()
2. [Ejemplo 2]()
3. [Ejemplo 3]()
4. [Ejemplo 4]()
5. [Ejemplo 5]()

## Metodo de regresion

### Algoritmo
### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos

1. [Ejemplo 1]()
2. [Ejemplo 2]()
3. [Ejemplo 3]()
4. [Ejemplo 4]()
5. [Ejemplo 5]()

