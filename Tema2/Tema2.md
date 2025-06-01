[ <- Regresar](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/tree/main)

# Métodos de Solución de Ecuaciones

## Introducción

Los **métodos de solución de ecuaciones** son técnicas numéricas utilizadas para encontrar los valores de las variables que satisfacen una ecuación dada, es decir, los **valores que hacen que una función se anule** (raíces de la función). Estos métodos resultan útiles cuando no es posible resolver una ecuación de forma analítica o exacta. Dependiendo del tipo de función y del comportamiento de la raíz, se pueden aplicar distintos enfoques para obtener una solución aproximada con un margen de error aceptable.

En este proyecto se abordan los siguientes métodos numéricos para encontrar raíces de funciones:

- [**Bisección**](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Tema2.md#método-de-bisección): Método que divide un intervalo donde la función cambia de signo, asegurando la presencia de una raíz, y reduce el intervalo hasta alcanzar la precisión deseada.

- **Regla Falsa (Falsa Posición)**: Utiliza una interpolación lineal entre los extremos del intervalo para estimar la raíz, permitiendo una convergencia más rápida que la bisección en ciertos casos.

- **Secante**: Se basa en dos aproximaciones sucesivas y construye una línea secante para encontrar nuevas aproximaciones. Generalmente converge más rápido, pero es menos estable.

- **Punto Fijo**: Reescribe la ecuación en la forma \( x = g(x) \) y aplica iteraciones sucesivas para encontrar la raíz, siempre que se cumplan ciertas condiciones de convergencia.

- **Newton-Raphson**: Método muy eficiente que requiere la derivada de la función. A partir de una aproximación inicial, utiliza la pendiente de la tangente para aproximarse rápidamente a la raíz.

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
            System.out.printf("La raíz encontrada es: %.6f\n", raiz);
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
La raíz encontrada es: 1.521380
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

### 🧪 Ejemplo

- `f(x) = x³ - x - 2`  
- `f'(x) = 3x² - 1`  
- `x0 = 1.5`  
- `tolerancia = 1e-6`  
- `maxIteraciones = 100`



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
### Caso de prueba
### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_5.java)

## Punto Fijo

### Algoritmo
### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo5.java)

## Regla Falsa

### Algoritmo
### Pseudocódigo
### Codigo en Java
### Caso de prueba
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
