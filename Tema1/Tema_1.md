[ <- Regresar](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/tree/main)

# Introduccion a Metodos Numericos

## Introduccion

En el mundo real, muchos problemas matemáticos no pueden resolverse de forma exacta debido a su complejidad o porque involucran datos experimentales, infinitos decimales o funciones no analíticas. Para abordar estos desafíos, utilizamos los métodos numéricos, un conjunto de técnicas que nos permiten encontrar soluciones aproximadas a problemas matemáticos utilizando algoritmos sistemáticos y computación.

A diferencia de los métodos analíticos, que buscan una solución exacta en forma cerrada, los métodos numéricos trabajan con aproximaciones sucesivas, lo que hace esencial el estudio de los errores involucrados en los cálculos. Comprender los distintos tipos de error es clave para evaluar la precisión y confiabilidad de los resultados obtenidos.

Entre los errores más comunes se encuentran:

- [**Error absoluto**](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Tema_1.md#error-absoluto): Es la diferencia directa entre el valor real (verdadero) y el valor aproximado.
- [**Error cuadrático medio (MSE)**](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Tema_1.md#error-cuadratico-medio): Se utiliza principalmente para evaluar el rendimiento global de un conjunto de estimaciones en relación con los valores reales. Es común en estadística, machine learning y simulaciones numéricas.
- [**Error relativo**](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Tema_1.md#error-relativo): Representa el error absoluto en proporción al valor real. Es útil para comparar errores en magnitudes diferentes.
- [**Error de redondeo**](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Tema_1.md#error-de-redondeo): Ocurre al limitar el número de cifras decimales que se pueden representar o usar en un cálculo. Este tipo de error es inherente al uso de números finitos en computadoras.
- [**Error de truncamiento**](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Tema_1.md#error-de-truncamiento): Aparece cuando se interrumpe un proceso infinito, como una serie numérica, después de un número finito de términos. Es común al usar aproximaciones como series de Taylor o métodos iterativos.


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

### Codigos
1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Absoluto/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Absoluto/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Absoluto/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Absoluto/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Absoluto/Ejemplo5.java)

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
1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Cuatratico%20medio/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Cuatratico%20medio/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Cuatratico%20medio/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Cuatratico%20medio/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Cuatratico%20medio/Ejemplo5.java)

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
1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Relativo/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Relativo/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Relativo/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Relativo/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20Relativo/Ejemplo5.java)

## Error de Redondeo

### Algoritmo


1. Tener una lista de **valores reales**.
2. Para cada valor:
   - Redondear el número a cierto número de decimales (por ejemplo, 2).
   - Calcular el error como:  
     `error = |valor_real - valor_redondeado|`
   - Guardar el error en una lista.
3. Mostrar todos los errores de redondeo.

### Pseudocódigo

```plaintext
Función calcularErroresRedondeo(valores, decimales):
    errores ← lista vacía

    Para cada valor en valores:
        valor_redondeado ← redondear(valor, decimales)
        error ← |valor - valor_redondeado|
        Agregar error a errores

    Retornar errores

```

### Codigo en Java

```java
import java.util.ArrayList;

public class ErrorRedondeo {
    public static void main(String[] args) {
        double[] valores = {3.14159, 2.71828, 1.61803};
        int decimales = 2;

        ArrayList<Double> errores = new ArrayList<>();

        for (double valor : valores) {
            double valorRedondeado = Math.round(valor * Math.pow(10, decimales)) / Math.pow(10, decimales);
            double error = Math.abs(valor - valorRedondeado);
            errores.add(error);
        }

        System.out.println("Errores de Redondeo: " + errores);
    }
}
```

### Caso de prueba

Valores de entrada
```
Valores reales: [3.14159, 2.71828, 1.61803]
Número de decimales: 2
```

Salida esperada
```
Errores de Redondeo: [0.0015, 0.0017, 0.0019]
```

### Codigos
1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20de%20redondeo/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20de%20redondeo/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20de%20redondeo/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20de%20redondeo/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20de%20redondeo/Ejemplo5.java)

## Error de Truncamiento

### Algoritmo

1. Definir un arreglo o lista de valores reales con decimales.
2. Definir el número de decimales a los que se truncará cada valor.
3. Para cada valor en la lista:
    1. Truncar el valor al número de decimales especificado.
    2. Calcular el error de truncamiento: valor original - valor truncado.
4. Guardar cada error en una lista.
5. Retornar o mostrar la lista de errores de truncamiento.

### Pseudocódigo

```
Función CalcularErrorTruncamiento(valores, decimales):
    errores ← lista vacía
    factor ← 10 ^ decimales

    Para cada valor en valores:
        truncado ← (entero(valor * factor)) / factor
        error ← valor - truncado
        agregar error a errores

    Retornar errores

```

### Codigo en Java

```java
import java.util.ArrayList;

public class TruncamientoEjemplo4 {

    public static ArrayList<Double> calcularErrorTruncamiento(double[] valores, int decimales) {
        ArrayList<Double> errores = new ArrayList<>();
        double factor = Math.pow(10, decimales);

        for (double valor : valores) {
            double truncado = ((int)(valor * factor)) / factor;
            double error = Math.abs(valor - truncado);
            errores.add(error);
        }
        return errores;
    }

    public static void main(String[] args) {
        double[] valores = {1.005, 2.675, 3.456};
        int decimales = 2;
        System.out.println("Ejemplo 4 - Errores de Truncamiento: " + calcularErrorTruncamiento(valores, decimales));
    }
}
```

### Caso de prueba

Valor de entrada
```
valores = [3.14159, 2.71828, 1.61803]
decimales = 2
```

Salida esperada
```
Errores de truncamiento ≈ [0.00159, 0.00828, 0.01803]
```

### Codigos
1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20de%20truncamiento/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20de%20truncamiento/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20de%20truncamiento/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20de%20truncamiento/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema1/Error%20de%20truncamiento/Ejemplo5.java)
