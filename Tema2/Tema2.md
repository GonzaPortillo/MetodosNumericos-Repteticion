# Métodos de Solución de Ecuaciones

## Introduccion

Los métodos de solución de ecuaciones son técnicas utilizadas para encontrar los valores de las variables que satisfacen una ecuación dada. Dependiendo del tipo de ecuación, se pueden utilizar diferentes métodos.

Los metodos que veremos en esta ocacion son:

1. Biseccion: Es un método numérico utilizado para encontrar las raíces de una función continua. Consiste en dividir repetidamente un intervalo en dos partes y seleccionar el subintervalo en el que existe un cambio de signo de la función, lo que indica la presencia de una raíz. Este proceso se repite hasta que se alcanza un intervalo suficientemente pequeño, proporcionando una aproximación de la raíz.
2. Regla falsa: También conocido como método de interpolación lineal o método de la secante, es un método numérico para encontrar raíces de funciones continuas. A diferencia del método de bisección, que divide el intervalo por la mitad, la regla falsa utiliza una interpolación lineal entre los puntos finales del intervalo para estimar la raíz. Este método converge más rápidamente que el método de bisección en ciertos casos.
3. Secante: Es un método numérico para encontrar raíces de una función continua. Es similar al método de la regla falsa, pero en lugar de mantener un intervalo que contiene la raíz, utiliza dos aproximaciones sucesivas de la raíz para iterativamente acercarse a la solución. Este método generalmente converge más rápido que el método de bisección y la regla falsa.

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

