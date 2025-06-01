[ <- Regresar](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/tree/main)

# Diferenciación e Integración Numérica

## Introduccion

Los métodos de diferenciación e integración numérica son técnicas utilizadas en matemáticas y ciencias computacionales para aproximar las derivadas e integrales de funciones cuando no se pueden obtener soluciones analíticas exactas.

Algunos de estos metodos son:

1. Simpson 1/3: Es una técnica de integración numérica utilizada para aproximar el valor de una integral definida. Este método utiliza una interpolación cuadrática para conectar tres puntos equidistantes en el intervalo de integración y calcula el área bajo la curva utilizando la fórmula de Simpson.
2. Simspson 3/8: Es una técnica de integración numérica utilizada para aproximar el valor de una integral definida. Este método utiliza una interpolación cúbica para conectar cuatro puntos equidistantes en el intervalo de integración y calcula el área bajo la curva utilizando la fórmula de Simpson 3/8.
3. Metodo del trapecio: Es una técnica de integración numérica utilizada para aproximar el valor de una integral definida. La idea detrás del método del trapecio es aproximar el área bajo una curva mediante un conjunto de trapecios cuyas bases son segmentos de la curva y cuyas alturas son la distancia entre los puntos de la partición. En esencia, se aproxima el área bajo la curva como la suma de las áreas de los trapecios.

## Simpson 1/3

### Algoritmo
### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%201.3/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%201.3/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%201.3/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%201.3/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%201.3/Ejemplo5.java)

## Simpson 3/8

### Algoritmo
### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%203.8/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%203.8/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%203.8/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%203.8/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%203.8/Ejemplo5.java)

## Metodo de trapecio

### Algoritmo

1. Definir la función `f(x)` a integrar.
2. Establecer los límites de integración `a` y `b`, y el número de subintervalos `n`.
3. Calcular el tamaño del paso:  
   `h = (b - a) / n`
4. Calcular la suma inicial:  
   `suma = (f(a) + f(b)) / 2`
5. Para `i = 1` hasta `n - 1`:
   - Calcular `x_i = a + i * h`
   - Agregar `f(x_i)` a la suma
6. Calcular el resultado:  
   `resultado = h * suma`
7. Mostrar el resultado

### Pseudocódigo

```
Inicio
    Definir función f(x)
    Leer a, b, n
    h ← (b - a) / n
    suma ← (f(a) + f(b)) / 2

    Para i desde 1 hasta n - 1 hacer
        x ← a + i * h
        suma ← suma + f(x)
    Fin Para

    resultado ← h * suma
    Mostrar "La integral aproximada es: ", resultado
Fin
```

### Codigo en Java

```java
public class Problema_1 {
    
    public static double funcion(double x) {
        return x * x; // f(x) = x^2
    }

    public static double trapecio(double a, double b, int n) {
        double h = (b - a) / n;
        double suma = (funcion(a) + funcion(b)) / 2.0;

        for (int i = 1; i < n; i++) {
            suma += funcion(a + i * h);
        }

        return h * suma;
    }

    public static void main(String[] args) {
        double a = 0;
        double b = 1;
        int n = 6;

        double resultado = trapecio(a, b, n);

        System.out.println("La integral aproximada es: " + resultado);
    }
}

```

### Caso de prueba
Datos de entrada
```
f(x) = x²

Limites de intregracion:

a = 0
b = 1
```

Salida esperada
```
La integral aproximada es: 0.335
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Trapezoide/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Trapezoide/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Trapezoide/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Trapezoide/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Trapezoide/Ejemplo5.java)
