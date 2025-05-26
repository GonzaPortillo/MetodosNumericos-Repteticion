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

