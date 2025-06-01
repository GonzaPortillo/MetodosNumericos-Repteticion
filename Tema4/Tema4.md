[ <- Regresar](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/tree/main)

# Diferenciación e Integración Numérica

## Introduccion

Los métodos de diferenciación e integración numérica son técnicas utilizadas en matemáticas y ciencias computacionales para aproximar las derivadas e integrales de funciones cuando no se pueden obtener soluciones analíticas exactas.

Algunos de estos metodos son:

1. [**Simpson 1/3**](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Tema4.md#simpson-13): Es una técnica de integración numérica utilizada para aproximar el valor de una integral definida. Este método utiliza una interpolación cuadrática para conectar tres puntos equidistantes en el intervalo de integración y calcula el área bajo la curva utilizando la fórmula de Simpson.
2. [**Simspson 3/8**](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Tema4.md#simpson-38): Es una técnica de integración numérica utilizada para aproximar el valor de una integral definida. Este método utiliza una interpolación cúbica para conectar cuatro puntos equidistantes en el intervalo de integración y calcula el área bajo la curva utilizando la fórmula de Simpson 3/8.
3. [**Metodo del trapecio**](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Tema4.md#metodo-de-trapecio): Es una técnica de integración numérica utilizada para aproximar el valor de una integral definida. La idea detrás del método del trapecio es aproximar el área bajo una curva mediante un conjunto de trapecios cuyas bases son segmentos de la curva y cuyas alturas son la distancia entre los puntos de la partición. En esencia, se aproxima el área bajo la curva como la suma de las áreas de los trapecios.

## Simpson 1/3

### Algoritmo

1. Definir la función `f(x)` que se desea integrar.
2. Elegir el número de subintervalos `n`, asegurando que **n sea par**.
3. Calcular el paso de integración:  
   `h = (b - a) / n`
4. Inicializar la suma:  
   `suma = f(a) + f(b)`
5. Para cada `i` impar entre 1 y `n - 1`:
   - Agregar `4 * f(a + i * h)` a la suma.
6. Para cada `i` par entre 2 y `n - 2`:
   - Agregar `2 * f(a + i * h)` a la suma.
7. Calcular el valor aproximado de la integral:  
   `resultado = (h / 3) * suma`
8. Mostrar el resultado.

### Pseudocódigo

```
Inicio
    Definir función f(x)
    Leer a, b, n
    Verificar si n es par
    h ← (b - a) / n
    suma ← f(a) + f(b)

    Para i desde 1 hasta n - 1 con paso 2 hacer
        suma ← suma + 4 * f(a + i * h)
    Fin Para

    Para i desde 2 hasta n - 2 con paso 2 hacer
        suma ← suma + 2 * f(a + i * h)
    Fin Para

    resultado ← (h / 3) * suma
    Mostrar "La integral aproximada es: ", resultado
Fin
```

### Codigo en Java

```java
public class Problema_1 {

    public static double funcion(double x) {
        // Ejemplo: f(x) = x^2
        return x * x;
    }

    public static double simpson13(double a, double b, int n) {
        if (n % 2 != 0) {
            System.out.println("n debe ser un número par.");
            return Double.NaN;
        }

        double h = (b - a) / n; // Paso de integración
        double suma = funcion(a) + funcion(b); // Suma de los extremos

        for (int i = 1; i < n; i += 2) {
            suma += 4 * funcion(a + i * h);
        }

        for (int i = 2; i < n - 1; i += 2) {
            suma += 2 * funcion(a + i * h);
        }

        return (h / 3) * suma;
    }

    public static void main(String[] args) {
        double a = 0;
        double b = 1;
    
        int n = 6;

        double resultado = simpson13(a, b, n);

        System.out.println("La integral aproximada es: " + resultado);
    }
}

```

### Caso de prueba

Datos de entrada
```
Función a integrar:
f(x) = x²

Límites de integración:

a = 0
b = 1
```

Salida esperada
```
La integral aproximada es: 0.33
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%201.3/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%201.3/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%201.3/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%201.3/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema4/Simpson%201.3/Ejemplo5.java)

## Simpson 3/8

### Algoritmo

1. Definir la función `f(x)` que se desea integrar.
2. Elegir el número de subintervalos `n`, tal que sea múltiplo de 3.
3. Calcular el paso de integración:  
   `h = (b - a) / n`
4. Inicializar la suma:  
   `suma = f(a) + f(b)`
5. Para cada `i` de 1 a `n - 1`:
   - Si `i % 3 != 0`, agregar `3 * f(a + i * h)` a la suma.
6. Para cada `i` de 3 hasta `n - 1` con paso de 3:
   - Agregar `2 * f(a + i * h)` a la suma.
7. Calcular el valor aproximado de la integral:  
   `resultado = (3 * h / 8) * suma`
8. Mostrar el resultado

### Pseudocódigo

```
Inicio
    Definir función f(x)
    Leer a, b, n
    Verificar si n es múltiplo de 3
    h ← (b - a) / n
    suma ← f(a) + f(b)

    Para i desde 1 hasta n - 1 hacer
        Si i mod 3 ≠ 0 entonces
            suma ← suma + 3 * f(a + i * h)
    Fin Para

    Para i desde 3 hasta n - 1 con paso 3 hacer
        suma ← suma + 2 * f(a + i * h)
    Fin Para

    resultado ← (3 * h / 8) * suma
    Mostrar "La integral aproximada es: ", resultado
Fin
```

### Codigo en Java

```java
public class Problema_1 {
    // Definición de la función que vamos a integrar
    public static double funcion(double x) {
        // Ejemplo: f(x) = x^2
        return x * x;
    }

    // Implementación de la regla de Simpson 3/8
    public static double simpson38(double a, double b, int n) {
        if (n % 3 != 0) {
            System.out.println("n debe ser un múltiplo de 3.");
            return Double.NaN;
        }

        double h = (b - a) / n;
        double suma = funcion(a) + funcion(b);

        for (int i = 1; i < n; i++) {
            if (i % 3 != 0) {
                suma += 3 * funcion(a + i * h);
            }
        }

        for (int i = 3; i < n; i += 3) {
            suma += 2 * funcion(a + i * h);
        }

        return (3 * h / 8) * suma;
    }

    public static void main(String[] args) {
        double a = 0;
        double b = 1;
        int n = 6;

        double resultado = simpson38(a, b, n);
        System.out.println("La integral aproximada es: " + resultado);
    }
}

```

### Caso de prueba

Datos de entrada
```
Funcion:
f(x) = x²

Límites de integración:

a = 0
b = 1
```
Salida esperada
```
La integral aproximada es: 0.33
```

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
