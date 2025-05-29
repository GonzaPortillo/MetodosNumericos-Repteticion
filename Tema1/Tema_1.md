[ <- Regresan](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/tree/main)

# Introduccion a Metodos Numericos

## Introduccion

En el mundo real, muchos problemas matemáticos no pueden resolverse de forma exacta debido a su complejidad o porque involucran datos experimentales, infinitos decimales o funciones no analíticas. Para abordar estos desafíos, utilizamos los métodos numéricos, un conjunto de técnicas que nos permiten encontrar soluciones aproximadas a problemas matemáticos utilizando algoritmos sistemáticos y computación.

A diferencia de los métodos analíticos, que buscan una solución exacta en forma cerrada, los métodos numéricos trabajan con aproximaciones sucesivas, lo que hace esencial el estudio de los errores involucrados en los cálculos. Comprender los distintos tipos de error es clave para evaluar la precisión y confiabilidad de los resultados obtenidos.

Entre los errores más comunes se encuentran:

- Error absoluto: Es la diferencia directa entre el valor real (verdadero) y el valor aproximado.
- Error relativo: Representa el error absoluto en proporción al valor real. Es útil para comparar errores en magnitudes diferentes.
- Error de redondeo: Ocurre al limitar el número de cifras decimales que se pueden representar o usar en un cálculo. Este tipo de error es inherente al uso de números finitos en computadoras.
- Error de truncamiento: Aparece cuando se interrumpe un proceso infinito, como una serie numérica, después de un número finito de términos. Es común al usar aproximaciones como series de Taylor o métodos iterativos.
- Error cuadrático medio (MSE): Se utiliza principalmente para evaluar el rendimiento global de un conjunto de estimaciones en relación con los valores reales. Es común en estadística, machine learning y simulaciones numéricas.

## Algoritmos

### Error Absoluto
Este algoritmo calcula qué tanto difiere un valor aproximado de su valor real.
#### Pasos:

1. Leer el valor real (VR).
2. Leer el valor aproximado (VA).
3. Calcular la diferencia absoluta: |VR - VA|.
4. El resultado es el error absoluto.

### Error Relativo
Este algoritmo compara el error absoluto con respecto al valor real, útil cuando se trabaja con magnitudes muy diferentes.
#### Pasos:

1. Leer el valor real (VR).
2. Leer el valor aproximado (VA).
3. Verificar que el valor real no sea cero (para evitar división por cero).
4. Calcular el error absoluto: |VR - VA|.
5. Dividir ese resultado entre |VR| para obtener el error relativo.
6. El resultado es el error relativo.

### Error de Redondeo
Este algoritmo mide cuánto se pierde al redondear un número.
#### Pasos:

Leer el número original (con todas sus cifras).

Leer el número redondeado.

Calcular la diferencia absoluta entre ellos: |original - redondeado|.

El resultado es el error de redondeo.

✅ 4. Algoritmo del Error de Truncamiento
Se usa cuando se interrumpe un cálculo infinito (como una serie) en un punto determinado.

Pasos:

Leer el valor exacto o más preciso de una función.

Leer el valor truncado (calculado con menos términos o pasos).

Calcular la diferencia absoluta: |exacto - truncado|.

El resultado es el error de truncamiento.

✅ 5. Algoritmo del Error Cuadrático Medio (MSE)
Este algoritmo calcula el promedio de los errores al cuadrado entre varios valores reales y aproximados. Es muy usado en estadística y aprendizaje automático.

Pasos:

Leer dos listas del mismo tamaño: una con los valores reales y otra con los valores aproximados.

Inicializar una variable para acumular la suma de errores al cuadrado.

Para cada par de valores reales y aproximados:

Restar: error = real - aproximado.

Elevar ese error al cuadrado.

Sumarlo a la variable acumuladora.

Dividir la suma total entre el número de elementos.

El resultado es el MSE (error cuadrático medio).
