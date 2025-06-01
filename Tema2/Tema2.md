[ <- Regresar](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/tree/main)

# Métodos de Solución de Ecuaciones

## Introducción

Los **métodos de solución de ecuaciones** son técnicas numéricas utilizadas para encontrar los valores de las variables que satisfacen una ecuación dada, es decir, los **valores que hacen que una función se anule** (raíces de la función). Estos métodos resultan útiles cuando no es posible resolver una ecuación de forma analítica o exacta. Dependiendo del tipo de función y del comportamiento de la raíz, se pueden aplicar distintos enfoques para obtener una solución aproximada con un margen de error aceptable.

En este proyecto se abordan los siguientes métodos numéricos para encontrar raíces de funciones:

- [**Bisección**](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Tema2.md#método-de-bisección): Método que divide un intervalo donde la función cambia de signo, asegurando la presencia de una raíz, y reduce el intervalo hasta alcanzar la precisión deseada.

- [**Newton-Raphson**](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Tema2.md#newton-raphson): Método muy eficiente que requiere la derivada de la función. A partir de una aproximación inicial, utiliza la pendiente de la tangente para aproximarse rápidamente a la raíz.

- [**Punto Fijo**](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Tema2.md#punto-fijo): Reescribe la ecuación en la forma \( x = g(x) \) y aplica iteraciones sucesivas para encontrar la raíz, siempre que se cumplan ciertas condiciones de convergencia.

- **Regla Falsa (Falsa Posición)**: Utiliza una interpolación lineal entre los extremos del intervalo para estimar la raíz, permitiendo una convergencia más rápida que la bisección en ciertos casos.

- **Secante**: Se basa en dos aproximaciones sucesivas y construye una línea secante para encontrar nuevas aproximaciones. Generalmente converge más rápido, pero es menos estable.

Cada uno de estos métodos tiene ventajas y desventajas, y su uso dependerá del tipo de función y la información disponible.

## Método de Bisección

### Algoritmo

1. Definir la función \( f(x) \) y los extremos del intervalo \([a, b]\) tal que \( f(a) \cdot f(b) < 0 \).
2. Calcular el punto medio \( c = \frac{a + b}{2} \).
3. Evaluar \( f(c) \). Si \( f(c) = 0 \) o el intervalo es suficientemente pequeño, \( c \) es la raíz.
4. Si \( f(a) \cdot f(c) < 0 \), la raíz está en \([a, c]\); de lo contrario, en \([c, b]\).
5. Repetir hasta cumplir el criterio de convergencia.

### Pseudocódigo

```plaintext
Función f(x):
  Retornar x^3 - x - 2

Función Biseccion(a, b, tolerancia, maxIteraciones):
  Si f(a) * f(b) ≥ 0:
    Mostrar "El método de bisección no se puede aplicar"
    Retornar NaN

  Repetir hasta maxIteraciones:
    c ← (a + b) / 2
    Si f(c) == 0 ó (b - a)/2 < tolerancia:
      Retornar c

    Si f(c) * f(a) < 0:
      b ← c
    Sino:
      a ← c

  Retornar c
```

### Codigo en Java

```java
public class Problema_1 {
    
    public static double funcion(double x) {
        return x * x * x - x - 2; //f(x) = x^3 - x - 2
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
        double a = 1; // Límite inferior del intervalo
        double b = 2; // Límite superior del intervalo
        double tolerancia = 1e-6; // Tolerancia
        int maxIteraciones = 1000; // Número máximo de iteraciones
        
        double raiz = biseccion(a, b, tolerancia, maxIteraciones);
        
        if (!Double.isNaN(raiz)) {
            System.out.printf("La raíz encontrada es: %.2f\n", raiz);
        } else {
            System.out.println("No se encontró una raíz en el intervalo dado.");
        }
    }
}

```

### Caso de prueba

**Función objetivo:**

```plaintext
f(x) = x^3 - x - 2
```

Salida esperada

```plaintext
La raíz encontrada es: 1.52
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo5.java)

## Newton Raphson

### Algoritmo

1. **Definir la función** `f(x)` de la cual se desea encontrar una raíz.
2. **Calcular la derivada** `f'(x)` de la función.
3. **Elegir un valor inicial** `x₀` cercano a la raíz esperada.
4. **Establecer una tolerancia** `ε`, por ejemplo `1e-6`, que indica la precisión deseada.
5. **Establecer un número máximo de iteraciones** `maxIteraciones` para evitar ciclos infinitos.
6. **Repetir mientras no se alcance la tolerancia y no se superen las iteraciones máximas:**
    1. Evaluar `f(x₀)` y `f'(x₀)`.
    2. Si `f'(x₀) == 0`, detener el algoritmo:
    3. Calcular el nuevo valor:
       ```
       x₁ = x₀ - f(x₀) / f'(x₀)
       ```
    4. Verificar si se cumple:
       ```
       |x₁ - x₀| < tolerancia
       ```
       Si es verdadero, entonces `x₁` es una raíz aproximada.
    5. Si no se cumple, actualizar:
       ```
       x₀ = x₁
       ```
    6. Incrementar el contador de iteraciones.
7. **Si se alcanza el número máximo de iteraciones sin cumplir la condición de tolerancia:**

---

### Pseudocódigo

```plaintext
Repetir mientras iter < maxIteraciones:
    fx ← f(x0)
    fpx ← fPrima(x0)

    Si fpx == 0:
        Mostrar "Derivada cero. Método falló."
        Retornar NaN

    x1 ← x0 - fx / fpx

    Si |x1 - x0| < tolerancia:
        Retornar x1

    x0 ← x1
    iter ← iter + 1

Mostrar "No se encontró la raíz en el número máximo de iteraciones"
Retornar x1
```

### Codigo en Java

```java
public class Newton2 {
    public static double f(double x) {
        return x * x - 4;
    }

    public static double df(double x) {
        return 2 * x;
    }

    public static void main(String[] args) {
        double x = 3.0;
        double tol = 1e-6;
        int maxIter = 100;

        for (int i = 0; i < maxIter; i++) {
            double fx = f(x), dfx = df(x);
            if (Math.abs(fx) < tol) break;
            x = x - fx / dfx;
        }

        System.out.printf("Raíz aproximada: %.2f\n", x);  // ≈ 2
    }
}
```

### Caso de prueba

**Función objetivo:**

```plaintext
f(x) = x^2 - 4
```

Salida esperada

```plaintext
Raíz aproximada: 2.00
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_5.java)

## Punto Fijo

### Algoritmo

1. Elegir una función \( g(x) \) tal que \( x = g(x) \) tenga la misma raíz que \( f(x) = 0 \).
2. Seleccionar un valor inicial \( x_0 \).
3. Evaluar \( x_1 = g(x_0) \).
4. Comprobar si \( |x_1 - x_0| < \text{tolerancia} \).  
   - Si es así, detener y retornar \( x_1 \) como la raíz.
5. Si no se cumple la condición de tolerancia:
   - Asignar \( x_0 = x_1 \) y repetir el proceso.
6. Si se alcanza el número máximo de iteraciones sin cumplir la condición, mostrar mensaje de error.
7. Retornar la última aproximación \( x_1 \).

### Pseudocódigo

```plaintext
Función g(x):
    Retornar alguna función equivalente a x = g(x)
    (Ejemplo: g(x) = sqrt(x + 2) si f(x) = x^2 - x - 2)

Función PuntoFijo(x0, tolerancia, maxIteraciones):
    iter ← 0

    Repetir mientras iter < maxIteraciones:
        x1 ← g(x0)

        Si |x1 - x0| < tolerancia:
            Retornar x1

        x0 ← x1
        iter ← iter + 1

    Mostrar "No se encontró la raíz en el número máximo de iteraciones"
    Retornar x1

```

### Codigo en Java

```java
public class PuntoFijo {

    public static double g(double x) {
        // Se define en cada ejemplo
        return 0;
    }

    public static double puntoFijo(double x0, double tolerancia, int maxIteraciones) {
        int iter = 0;
        double x1;

        do {
            x1 = g(x0);

            if (Math.abs(x1 - x0) < tolerancia) {
                return x1;
            }

            x0 = x1;
            iter++;
        } while (iter < maxIteraciones);

        System.out.println("No se encontró la raíz en el número máximo de iteraciones.");
        return x1;
    }

    public static void main(String[] args) {
        double x0 = 0.5; // Valor inicial
        double tolerancia = 1e-6;
        int maxIteraciones = 100;

        double raiz = puntoFijo(x0, tolerancia, maxIteraciones);
        System.out.printf("Raíz aproximada: %.2f\n", raiz);
    }
}
```

### Caso de prueba

```plaintext
f(x) = x^2 - x - 2
```

Salida esperada 

```
Raíz aproximada: 2.00
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo5.java)

## Regla Falsa

### Algoritmo

1. Calcular \( f(a) \) y \( f(b) \).
2. Verificar si \( f(a) \cdot f(b) > 0 \):  
   - Si es así, **detener**: no se garantiza una raíz en el intervalo.
3. Iterar hasta alcanzar la tolerancia o el número máximo de iteraciones:
   - Calcular el punto de intersección de la secante:
     \[
     c = b - f(b) \cdot \frac{b - a}{f(b) - f(a)}
     \]
   - Calcular \( f(c) \).
   - Si \( |f(c)| < \text{tolerancia} \), retornar \( c \) como la raíz.
   - Si \( f(a) \cdot f(c) < 0 \):
     - Reemplazar \( b = c \), \( f(b) = f(c) \)
   - Sino:
     - Reemplazar \( a = c \), \( f(a) = f(c) \)
4. Si se alcanza el número máximo de iteraciones, retornar el último valor de \( c \).

### Pseudocódigo

```
Función f(x):
    Retornar x^2 - 4

Función ReglaFalsa(a, b, tolerancia, maxIteraciones):
    fa ← f(a)
    fb ← f(b)

    Si fa * fb > 0:
        Mostrar "La función no cambia de signo en el intervalo"
        Retornar NaN

    Repetir hasta maxIteraciones:
        c ← b - fb * (b - a) / (fb - fa)
        fc ← f(c)

        Si |fc| < tolerancia:
            Mostrar "Raíz encontrada: c"
            Retornar c

        Si fa * fc < 0:
            b ← c
            fb ← fc
        Sino:
            a ← c
            fa ← fc

    Mostrar "No se encontró la raíz después de maxIteraciones iteraciones"
    Retornar c
```

### Codigo en Java

```java
public class ReglaFalsa1 {
    public static double f(double x) {
        return x * x * x - x - 2;
    }

    public static void main(String[] args) {
        double a = 1, b = 2, tol = 1e-6;
        int maxIter = 100;
        double fa = f(a), fb = f(b), c = a;

        for (int i = 0; i < maxIter; i++) {
            c = b - fb * (b - a) / (fb - fa);
            double fc = f(c);
            if (Math.abs(fc) < tol) break;
            if (fa * fc < 0) {
                b = c; fb = fc;
            } else {
                a = c; fa = fc;
            }
        }

        System.out.printf("Raíz aproximada: %.2f\n", c);
    }
}
```

### Caso de prueba


**Función objetivo:**

```plaintext
f(x) = x^3 - x - 2
```

```
Raíz aproximada: 1.52
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Regla%20Falsa/Ejemplo_1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Regla%20Falsa/Ejemplo_2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Regla%20Falsa/Ejemplo_3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Regla%20Falsa/Ejemplo_4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Regla%20Falsa/Ejemplo_5.java)

## Secante

### Algoritmo
### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Secante/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Secante/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Secante/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Secante/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Secante/Ejemplo5.java)
