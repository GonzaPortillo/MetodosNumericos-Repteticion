[ <- Regresar](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/tree/main)

# Métodos de Solución de Ecuaciones

# Introducción

Los **métodos de solución de ecuaciones** son técnicas numéricas utilizadas para encontrar los valores de las variables que satisfacen una ecuación dada, es decir, los **valores que hacen que una función se anule** (raíces de la función). Estos métodos resultan útiles cuando no es posible resolver una ecuación de forma analítica o exacta. Dependiendo del tipo de función y del comportamiento de la raíz, se pueden aplicar distintos enfoques para obtener una solución aproximada con un margen de error aceptable.

En este proyecto se abordan los siguientes métodos numéricos para encontrar raíces de funciones:

- **Bisección**: Método que divide un intervalo donde la función cambia de signo, asegurando la presencia de una raíz, y reduce el intervalo hasta alcanzar la precisión deseada.

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

### Caso de prueba

### Bisección

Ejemplo de salida del codigo
```plaintext
La raíz encontrada es: 1.521380
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo5.java)

