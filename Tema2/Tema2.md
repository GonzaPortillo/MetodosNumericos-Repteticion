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

## Algoritmos

### Biseccion

1. Definir la función ( f(x) ) y los extremos del intervalo ([a, b]) tal que ( f(a) \cdot f(b) < 0 ).
2. Calcular el punto medio ( c = \frac{a + b}{2} ).
3. Evaluar ( f(c) ). Si ( f(c) = 0 ) o el intervalo es suficientemente pequeño (criterio de convergencia), entonces ( c ) es la raíz. Si ( f(a) \cdot f(c) < 0 ), entonces la raíz está en el intervalo ([a, c]). De lo contrario, la raíz está en ([c, b]).
4. Repetir el proceso con el nuevo intervalo hasta que se cumpla el criterio de convergencia.

### Regla falsa 

1. Definir f(x).
2. Definir los intervalos [a,b].
3. Defiinr el umbral.
4. Calcular el punto de intersección 𝑐 de la línea que une (af(a) y (b,f(b)).
5. Evaluar f(c).
6. Repetir los pasos anteriores hasta que se cumpla la condición de parada.

### Secante

1. Definir f(x).
2. Definir dos aproximaciones iniciales X0 y X1.
3. Definir el umbral de tolerancia.
4. Para i=1 hasta maxIter.
5. Calcular Xi+1 usando la formula.
6. Retornar Xi+1 como la raíz aproximada si se ha alcanzado la tolerancia, o el valor más cercano después de maxIter iteraciones.

### Newton Raphson

1. Definir la funcion f(x) y su derivada
2. Elegir valor inicial de x0
3. Fija la tolerancia para el error aceptable y un numero maximo de iteraciones

- En cada iteracion:

1. Calcular f(xn)
2. Calcular f'(xn)
3. Si f'(xn) = 0 se detiene debido a que no se puede continuar
4. Calcular una nueva aproximacion
5. Calcular el error
6. Si el error es menor que la tolerancia se devuelve 

### Punto fijo

1. 
## Pseudocodigos

### Biseccion

    Función f(x):
      Retornar x^3 - x - 2

    Función Biseccion(a, b, tolerancia, maxIteraciones):
      Si f(a) * f(b) ≥ 0:
        Mostrar "El método de bisección no se puede aplicar"
        Retornar NaN

      Repetir hasta maxIteraciones:
        c ← (a + b) / 2

        Si f(c) == 0 ó (b - a) / 2 < tolerancia:
            Retornar c

        Si f(c) * f(a) < 0:
            b ← c
        Sino:
            a ← c

    Retornar c

### Regla falsa

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

### Secante

    Función f(x):
        Retornar x^3 - x^2 + 2

    Función MetodoSecante(x0, x1, tolerancia, maxIteraciones):
        f0 ← f(x0)
        f1 ← f(x1)
        iteraciones ← 0

        Mientras |f1| > tolerancia y iteraciones < maxIteraciones:
            x2 ← x1 - f1 * (x1 - x0) / (f1 - f0)
            x0 ← x1
            f0 ← f1
            x1 ← x2
            f1 ← f(x1)
            iteraciones ← iteraciones + 1

        Si iteraciones ≥ maxIteraciones:
            Mostrar "El método no convergió en maxIteraciones iteraciones"

        Retornar x2

### Newton-Raphson

    Función f(x):
        Retornar f(x)   // Por ejemplo: x^3 - x - 2

    Función fPrima(x):
        Retornar derivada de f(x)   // Por ejemplo: 3x^2 - 1

    Función NewtonRaphson(x0, tolerancia, maxIteraciones):
        iter ← 0

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


### Punto fijo

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

## Casos de prueba

### Biseccion

### Regla falsa

### Secante

### Newton-Raphson

### Punto fijo

## Ejemplos en codigo Java
### Biseccion

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Biseccion/Ejemplo5.java)

### Secante

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Secante/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Secante/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Secante/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Secante/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Secante/Ejemplo5.java)

### Regla falsa

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Regla%20Falsa/Ejemplo_1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Regla%20Falsa/Ejemplo_2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Regla%20Falsa/Ejemplo_3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Regla%20Falsa/Ejemplo_4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Regla%20Falsa/Ejemplo_5.java)

### Newton Raphson

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Newtom%20Raphson/Ejemplo_5.java)

### Punto Fijo

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema2/Punto%20fijo/Ejemplo5.java)
6. 


## Métodos Numéricos para Encontrar Raíces

---

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

 
