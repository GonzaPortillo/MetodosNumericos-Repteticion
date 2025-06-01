[ <- Regresar](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/tree/main)

# Introduccion a Metodos Numericos

## Introduccion

En el mundo real, muchos problemas matemáticos no pueden resolverse de forma exacta debido a su complejidad o porque involucran datos experimentales, infinitos decimales o funciones no analíticas. Para abordar estos desafíos, utilizamos los métodos numéricos, un conjunto de técnicas que nos permiten encontrar soluciones aproximadas a problemas matemáticos utilizando algoritmos sistemáticos y computación.

A diferencia de los métodos analíticos, que buscan una solución exacta en forma cerrada, los métodos numéricos trabajan con aproximaciones sucesivas, lo que hace esencial el estudio de los errores involucrados en los cálculos. Comprender los distintos tipos de error es clave para evaluar la precisión y confiabilidad de los resultados obtenidos.

Entre los errores más comunes se encuentran:

- [***Error absoluto***](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Tema_1.md#error-absoluto): Es la diferencia directa entre el valor real (verdadero) y el valor aproximado.
- ***Error cuadrático medio (MSE)***: Se utiliza principalmente para evaluar el rendimiento global de un conjunto de estimaciones en relación con los valores reales. Es común en estadística, machine learning y simulaciones numéricas.
- [***Error relativo***]: Representa el error absoluto en proporción al valor real. Es útil para comparar errores en magnitudes diferentes.
- ***Error de redondeo***: Ocurre al limitar el número de cifras decimales que se pueden representar o usar en un cálculo. Este tipo de error es inherente al uso de números finitos en computadoras.
- ***Error de truncamiento***: Aparece cuando se interrumpe un proceso infinito, como una serie numérica, después de un número finito de términos. Es común al usar aproximaciones como series de Taylor o métodos iterativos.


## Algoritmos

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

1. Leer el número original (con todas sus cifras).
2. Leer el número redondeado.
3. Calcular la diferencia absoluta entre ellos: |original - redondeado|.
4. El resultado es el error de redondeo.

### Error de Truncamiento
Se usa cuando se interrumpe un cálculo infinito (como una serie) en un punto determinado.
#### Pasos:

1. Leer el valor exacto o más preciso de una función.
2. Leer el valor truncado (calculado con menos términos o pasos).
3. Calcular la diferencia absoluta: |exacto - truncado|.
4. El resultado es el error de truncamiento.

## Error Absoluto

### Algoritmo

1. Tener una lista de pares de valores `[valor real, valor aproximado]`.
2. Inicializar una lista vacía `errores`.
3. Recorrer cada par:
   - Calcular el error absoluto: `|valor real - valor aproximado|`
   - Agregar el resultado a la lista `errores`.
4. Retornar la lista de errores absolutos.


### Pseudocodigo

```plaintext
Función calcularErrorAbsoluto(valores):
    errores ← lista vacía

    Para cada par en valores:
        vr ← par[0]
        va ← par[1]
        error ← valor absoluto de (vr - va)
        Agregar error a errores

    Retornar errores
```

### Codigo en Java

```java
import java.util.ArrayList;

public class Main {
    public static ArrayList<Double> calcularErrorAbsoluto(double[][] valores) {
        ArrayList<Double> errores = new ArrayList<>();
        for (double[] par : valores) {
            double vr = par[0];
            double va = par[1];
            errores.add(Math.abs(vr - va));
        }
        return errores;
    }

    public static void main(String[] args) {
        double[][] datos = {
            {120, 118},
            {85, 83},
            {95, 92}
        };

        System.out.println(calcularErrorAbsoluto(datos));
    }
}
```

### Caso de Prueba

Entrada
```
{120, 118}
{85, 83}
{95, 92}
```

Salida esperada

```
[2.0, 2.0, 3.0]
```

## Error Cuadratico Medio

### Algoritmo

1. Tener dos arreglos del mismo tamaño: uno con los valores reales y otro con los valores predichos.
2. Inicializar una variable `sumaError` en 0.
3. Recorrer ambos arreglos al mismo tiempo:
   - Restar el valor predicho del valor real.
   - Elevar al cuadrado el resultado.
   - Sumar el cuadrado del error a `sumaError`.
4. Dividir `sumaError` entre el número de elementos para obtener el MSE.
5. Retornar el MSE.

### Pseudocódigo

```
Función calcularMSE(reales, predichos):
    sumaError ← 0
    n ← longitud de reales

    Para i desde 0 hasta n - 1:
        error ← reales[i] - predichos[i]
        sumaError ← sumaError + (error)^2

    mse ← sumaError / n
    Retornar mse
```

### Codigo en Java

```java
public class MSEEjemplo1 {
  
    public static void main(String[] args) {
        int[] reales = {1, 2, 3, 4, 5};
        int[] predichos = {1, 2, 2, 4, 6};
        double mse = calcularMSE(reales, predichos);
        System.out.println("MSE: " + mse);
    }

    public static double calcularMSE(int[] reales, int[] predichos) {
        double sumaError = 0.0;
        int n = reales.length;
        for (int i = 0; i < n; i++) {
            sumaError += Math.pow(reales[i] - predichos[i], 2);
        }
        return sumaError / n;
    }
}

```

### Caso de prueba

Entrada

```
Reales:    [1, 2, 3, 4, 5]
Predichos: [1, 2, 2, 4, 6]
```

Salida esperada

```
MSE: 0.4
```

### Codigos

## Error Relativo

### Algoritmo

1. Tener una lista de pares `(valor_real, valor_aproximado)`.
2. Para cada par:
   - Restar el valor aproximado al valor real.
   - Tomar el valor absoluto del error.
   - Dividir ese valor entre el valor real.
   - Almacenar el resultado como el **error relativo**.
3. Mostrar todos los errores relativos.

### Pseudocódigo

```
Función calcularErroresRelativos(valores):
    errores ← lista vacía

    Para cada par en valores:
        vr ← par[0]
        va ← par[1]
        error ← |(vr - va) / vr|
        Agregar error a errores

    Retornar errores
```

### Codigo en Java

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        double[][] valores = {
            {30, 29},
            {42, 41},
            {55, 52}
        };

        ArrayList<Double> errores = new ArrayList<>();
        for (double[] par : valores) {
            double vr = par[0];
            double va = par[1];
            double error = Math.abs((vr - va) / vr);
            errores.add(error);
        }

        System.out.println("Errores Relativos: " + errores);
    }
}
```

### Caso de prueba

Valores de entrada
```
Valores:
(30, 29)
(42, 41)
(55, 52)
```

Salida esperada
```
Errores Relativos: [0.03, 0.024, 0.054]
```

### Codigos

## Error de Redondeo

### Algoritmo
### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos

## Error de Truncamiento

### Algoritmo
### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos
