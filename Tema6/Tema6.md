[ <- Regresar](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/tree/main)

# Solución de Ecuaciones Diferenciales

## Introduccion
La solución de ecuaciones diferenciales en métodos numéricos se refiere a la implementación de técnicas computacionales para encontrar soluciones aproximadas a ecuaciones diferenciales, ya sean ordinarias o parciales, cuando no es posible obtener una solución analítica cerrada.

Algunos de los algoritmos que veremos son:

1. Euler: Es un método de integración numérica de primer orden para resolver ecuaciones diferenciales ordinarias. Aproxima la solución paso a paso, utilizando la pendiente inicial de la ecuación diferencial.
2. Runge Kutta: Es un método de integración numérica de orden superior (por ejemplo, Runge-Kutta de cuarto orden) para resolver ecuaciones diferenciales ordinarias. Utiliza una combinación de evaluaciones de la ecuación diferencial en diferentes puntos para obtener una aproximación más precisa.
3. Taylor: Es un método numérico para resolver ecuaciones diferenciales ordinarias. Se basa en expandir la solución de la ecuación diferencial en una serie de Taylor alrededor de un punto.
4. Un paso: Son algoritmos que calculan la solución en un nuevo punto utilizando exclusivamente la información del punto anterior. Ejemplos de estos métodos incluyen Euler y Runge-Kutta. Son sencillos de implementar y requieren menos memoria, pero pueden ser menos estables en problemas rígidos o cuando se requiere alta precisión en intervalos grandes.
5. Paso Multiple: Estos métodos utilizan varios puntos anteriores para calcular el siguiente valor, lo que permite aprovechar más información del comportamiento previo de la solución. Ejemplos incluyen los métodos de Adams-Bashforth y Adams-Moulton. Son más eficientes computacionalmente en problemas extensos, pero suelen requerir pasos de arranque iniciales con métodos de un solo paso.

## Euler

### Algoritmo

1. Definir la función f(x, y) = x + y que representa la derivada de y respecto a x.
2. Inicializar valores:
   - x ← x0
   - y ← y0
3. Repetir n+1 veces:
   - Imprimir x, y
   - Calcular y ← y + h * f(x, y)
   - Calcular x ← x + h

### Pseudocódigo

```
Función f(x, y):
    retornar x + y

Procedimiento metodoEuler(x0, y0, h, n):
    x ← x0
    y ← y0
    para i desde 0 hasta n:
        imprimir x, y
        y ← y + h * f(x, y)
        x ← x + h

Main:
    metodoEuler(0, 1, 0.1, 10)
```

### Codigo en Java

```java
import java.text.DecimalFormat;

public class SistemasDeEcuacionesDiferencialesOrdinariasMétodoDeEuler {

    // Función f(x,y) = dy/dx
    public static double f(double x, double y) {
        return x + y;
    }

    // Método de Euler para resolver y' = f(x,y)
    public static void metodoEuler(double x0, double y0, double h, int n) {
        double x = x0, y = y0;
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.println("x\t\ty");
        for (int i = 0; i <= n; i++) {
            System.out.println(df.format(x) + "\t\t" + df.format(y));
            y = y + h * f(x, y);
            x = x + h;
        }
    }

    public static void main(String[] args) {
        metodoEuler(0, 1, 0.1, 10);
    }
}
```

### Caso de prueba

Datos de entrada
```
    x0 = 0
    y0 = 1
    h = 0.1
    n = 10
```
Salida esperada
```
    x       y
    0.0     1.0
    0.1     1.1
    0.2     1.21
    0.3     1.331
    0.4     1.4641
    0.5     1.6105
    0.6     1.7716
    0.7     1.9488
    0.8     2.1437
    0.9     2.3581
    1.0     2.5939
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Euler/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Euler/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Euler/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Euler/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Euler/Ejemplo5.java)

## Runge Kutta

### Algoritmo

1. Definir constantes:
   - k = 0.1 (constante de enfriamiento)
   - Tamb = 20.0 (temperatura ambiente)

2. Definir función `f(t, T)` que calcula la derivada dT/dt = -k * (T - Tamb).

3. Implementar método `rungeKutta(t0, T0, tf, h)` para resolver la ecuación diferencial usando Runge-Kutta de 4to orden:
   - Inicializar t = t0, T = T0
   - Mientras t <= tf:
     - Calcular k1 = h * f(t, T)
     - Calcular k2 = h * f(t + h/2, T + k1/2)
     - Calcular k3 = h * f(t + h/2, T + k2/2)
     - Calcular k4 = h * f(t + h, T + k3)
     - Actualizar T = T + (k1 + 2*k2 + 2*k3 + k4) / 6
     - Actualizar t = t + h
     - Imprimir t y T

4. En main:
   - Llamar rungeKutta con t0=0, T0=90, tf=5, h=1

### Pseudocódigo

```
Constantes:
    k ← 0.1
    Tamb ← 20.0

Función f(t, T):
    Retornar -k * (T - Tamb)

Procedimiento rungeKutta(t0, T0, tf, h):
    t ← t0
    T ← T0
    Mientras t ≤ tf hacer:
        k1 ← h * f(t, T)
        k2 ← h * f(t + h/2, T + k1/2)
        k3 ← h * f(t + h/2, T + k2/2)
        k4 ← h * f(t + h, T + k3)
        T ← T + (k1 + 2*k2 + 2*k3 + k4) / 6
        t ← t + h
        Imprimir t, T

Main:
    Imprimir encabezado
    rungeKutta(0, 90, 5, 1)
```

### Codigo en Java

```java
public class Ejercicio2 {

    static double k = 0.1;
    static double Tamb = 20.0;

    public static double f(double t, double T) {
        return -k * (T - Tamb);
    }

    public static void rungeKutta(double t0, double T0, double tf, double h) {
        double t = t0;
        double T = T0;

        while (t < tf + 1e-6) {
            double k1 = h * f(t, T);
            double k2 = h * f(t + h / 2.0, T + k1 / 2.0);
            double k3 = h * f(t + h / 2.0, T + k2 / 2.0);
            double k4 = h * f(t + h, T + k3);

            T += (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;
            t += h;

            System.out.printf("%.2f \t%.6f%n", t, T);
        }
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio 2 - Enfriamiento");
        System.out.println("t \tT");
        rungeKutta(0, 90, 5, 1);
    }
}
```

### Caso de prueba

Datos de entrada
```
t0 = 0
T0 = 90
tf = 5
h = 1
```

Salida esperada
```
t T
1.00 74.21
2.00 61.33
3.00 50.94
4.00 42.65
5.00 36.11
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Runge-Kuta/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Runge-Kuta/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Runge-Kuta/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Runge-Kuta/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Runge-Kuta/Ejemplo5.java)

## Taylor 

### Algoritmo


1. Definir la función `derivative(n, a)` que siempre retorna `exp(a)` ya que todas las derivadas de `e^x` son `e^x`.
2. Definir función `taylor(a, x, n)` para calcular la aproximación de `e^x` mediante la serie de Taylor centrada en `a`, evaluada en `x`, hasta el orden `n`:
   - Inicializar `resultado ← 0`, `potencia ← 1`, `factorial ← 1`.
   - Para i desde 0 hasta n:
     - Si i > 0:  
       - potencia ← potencia * (x - a)  
       - factorial ← factorial * i
     - resultado ← resultado + (derivative(i, a) * potencia) / factorial
3. En main():
   - Establecer `a = 0`, `x = 1`, `n = 10`.
   - Calcular aproximación ← taylor(a, x, n)
   - Imprimir:
     - aproximación
     - valor real con `exp(x)`
     - error absoluto ← |exp(x) - aproximación|

### Pseudocódigo

```
Función derivative(n, a):
    Retornar exp(a)

Función taylor(a, x, n):
    resultado ← 0
    potencia ← 1
    factorial ← 1
    Para i ← 0 hasta n hacer:
        Si i > 0:
            potencia ← potencia * (x - a)
            factorial ← factorial * i
        resultado ← resultado + derivative(i, a) * potencia / factorial
    Retornar resultado

Main:
    a ← 0
    x ← 1
    n ← 10
    aproximacion ← taylor(a, x, n)
    valorReal ← exp(x)
    error ← |valorReal - aproximacion|
    Imprimir aproximacion, valorReal, error
```

### Codigo en Java

```java
public class TaylorExp {
    public static double derivative(int n, double a) {
        return Math.exp(a); // Todas las derivadas de e^x son e^a
    }

    public static double taylor(double a, double x, int n) {
        double resultado = 0, potencia = 1, factorial = 1;
        for (int i = 0; i <= n; i++) {
            if (i > 0) {
                potencia *= (x - a);
                factorial *= i;
            }
            resultado += (derivative(i, a) * potencia) / factorial;
        }
        return resultado;
    }

    public static void main(String[] args) {
        double a = 0, x = 1;
        int n = 10;
        double aproximacion = taylor(a, x, n);
        System.out.println("Taylor e^x ≈ " + aproximacion);
        System.out.println("Valor real e^x = " + Math.exp(x));
        System.out.println("Error = " + Math.abs(Math.exp(x) - aproximacion));
    }
}
```

### Caso de prueba

Datos de entrada
```
  a = 0  
  x = 1  
  n = 10
```

Salida esperada
```
Taylor e^x ≈ 2.7182818011463845  
Valor real e^x = 2.718281828459045  
Error = 0.0000000273126606
```


### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Taylor/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Taylor/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Taylor/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Taylor/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Taylor/Ejemplo5.java)

## Un paso

### Algoritmo

1. Definir la función f(x, y) = x + y, que representa la derivada dy/dx.

2. Implementar el método `metodoEuler(x0, y0, h, n)` para resolver la EDO con el método de Euler:
   - Inicializar x = x0, y = y0
   - Repetir n+1 veces:
     - Imprimir x, y
     - Calcular y ← y + h * f(x, y)
     - Calcular x ← x + h

3. En main:
   - Llamar a `metodoEuler` con los valores iniciales:
     - x0 = 0
     - y0 = 1
     - h = 0.1
     - n = 10

### Pseudocódigo

```
Función f(x, y):
    Retornar x + y

Procedimiento metodoEuler(x0, y0, h, n):
    x ← x0
    y ← y0
    Para i desde 0 hasta n hacer:
        Imprimir x, y
        y ← y + h * f(x, y)
        x ← x + h

Main:
    metodoEuler(0, 1, 0.1, 10)
```

### Codigo en Java

```java
import java.text.DecimalFormat;

public class MetodoUnPaso {

    // Función f(x, y) que representa la derivada dy/dx
    public static double f(double x, double y) {
        return x + y; // Ejemplo: dy/dx = x + y
    }

    // Método de Euler para aproximar soluciones a EDOs
    public static void metodoEuler(double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("x\t\ty");
        for (int i = 0; i <= n; i++) {
            System.out.println(df.format(x) + "\t\t" + df.format(y));
            y = y + h * f(x, y); // y_{i+1} = y_i + h*f(x_i, y_i)
            x = x + h;           // x_{i+1} = x_i + h
        }
    }

    public static void main(String[] args) {
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y
        double h = 0.1;   // Tamaño de paso
        int n = 10;       // Número de pasos

        metodoEuler(x0, y0, h, n);
    }
}
```

### Caso de prueba

Datos de entrada
```
x0 = 0
y0 = 1
h = 0.1
n = 10
```

Salida esperada
```
x y
0.00 1.00
0.10 1.10
0.20 1.21
0.30 1.33
0.40 1.46
0.50 1.60
0.60 1.76
0.70 1.93
0.80 2.12
0.90 2.33
1.00 2.56
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Un%20Paso/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Un%20Paso/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Un%20Paso/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Un%20Paso/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Un%20Paso/Ejemplo5.java)

## Paso Multiple

### Algoritmo

1. Definir la función `f(t, y)` como la derivada del problema (en este caso `dy/dt = y`).
2. Inicializar los valores: paso `h`, valores iniciales `t0`, `y0`, y final `tf`.
3. Calcular número de pasos `n = (tf - t0) / h`.
4. Crear arreglos `t`, `y` y `exacto` de tamaño `n + 1`.
5. Asignar valores iniciales a `t[0]`, `y[0]` y `exacto[0] = exp(t0)`.
6. Usar el método de Runge-Kutta 4 para obtener los primeros 4 valores:
   - Para i = 0 a 2:
     - Calcular k1, k2, k3, k4.
     - Calcular y[i+1] con fórmula de RK4.
     - Actualizar t[i+1] y exacto[i+1] = exp(t[i+1]).
7. Aplicar Adams-Bashforth de 4 pasos para i = 3 hasta n - 1:
   - y[i+1] = y[i] + h/24 * (55*f_i - 59*f_{i-1} + 37*f_{i-2} - 9*f_{i-3})
   - Actualizar t[i+1] y exacto[i+1] = exp(t[i+1])
8. Calcular e imprimir en cada paso: `t`, `y (AB4)`, `y (Exacto)`, y el error absoluto.
9. Al final, imprimir:
   - Error absoluto en `t = 1`
   - Error relativo en `t = 1`

### Pseudocódigo

```
Definir f(t, y) como y

Inicializar:
    h ← 0.2
    t0 ← 0.0
    y0 ← 1.0
    tf ← 1.0
    n ← (tf - t0) / h

Crear arreglos t[0...n], y[0...n], exacto[0...n]
t[0] ← t0
y[0] ← y0
exacto[0] ← exp(t0)
```

### Codigo en Java

```java
public class AdamsBashforthError {

    // Derivada dy/dt = f(t, y)
    public static double f(double t, double y) {
        return y; // Ejemplo: dy/dt = y
    }

    public static void main(String[] args) {
        double h = 0.2;     // Tamaño del paso
        double t0 = 0.0;    // Valor inicial de t
        double y0 = 1.0;    // Valor inicial de y
        double tf = 1.0;    // Valor final de t
        int n = (int) ((tf - t0) / h); // Número de pasos

        double[] t = new double[n + 1];
        double[] y = new double[n + 1];
        double[] exacto = new double[n + 1];

        t[0] = t0;
        y[0] = y0;
        exacto[0] = Math.exp(t0);

        // Uso de Runge-Kutta 4 para obtener los primeros 4 valores
        for (int i = 0; i < 3; i++) {
            double k1 = f(t[i], y[i]);
            double k2 = f(t[i] + h / 2, y[i] + h * k1 / 2);
            double k3 = f(t[i] + h / 2, y[i] + h * k2 / 2);
            double k4 = f(t[i] + h, y[i] + h * k3);
            y[i + 1] = y[i] + h * (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            t[i + 1] = t[i] + h;
            exacto[i + 1] = Math.exp(t[i + 1]);
        }

        // Método de Adams-Bashforth de 4 pasos
        for (int i = 3; i < n; i++) {
            y[i + 1] = y[i] + h * (
                    55 * f(t[i], y[i])
                  - 59 * f(t[i - 1], y[i - 1])
                  + 37 * f(t[i - 2], y[i - 2])
                  - 9 * f(t[i - 3], y[i - 3])
            ) / 24;

            t[i + 1] = t[i] + h;
            exacto[i + 1] = Math.exp(t[i + 1]);
        }

        // Mostrar resultados
        System.out.println("Paso\t t\t\t y (AB4)\t y (Exacto)\t Error Abs.");
        for (int i = 0; i <= n; i++) {
            double error = Math.abs(exacto[i] - y[i]);
            System.out.printf("%d\t %.2f\t %.6f\t %.6f\t %.6f%n",
                    i, t[i], y[i], exacto[i], error);
        }

        // Error absoluto y relativo en t = 1
        double errorFinal = Math.abs(exacto[n] - y[n]);
        System.out.printf("%nError absoluto en t = 1: %.6f%n", errorFinal);
        System.out.printf("Error relativo en t = 1: %.6f%%%n", (errorFinal / exacto[n]) * 100);
    }
}
```

### Caso de prueba

Datos de entrada
```
  h = 0.2  
  t0 = 0.0  
  y0 = 1.0  
  tf = 1.0  
  f(t, y) = y

```

Salida esperada
```
Paso t y (AB4) y (Exacto) Error Abs.
0 0.00 1.000000 1.000000 0.000000
1 0.20 1.221402 1.221403 0.000001
2 0.40 1.491825 1.491825 0.000000
3 0.60 1.822117 1.822119 0.000002
4 0.80 2.225541 2.225541 0.000000
5 1.00 2.718282 2.718282 0.000000

Error absoluto en t = 1: 0.000000
Error relativo en t = 1: 0.000000%
```

### Codigos

1. [Ejemplo 1](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Paso%20Multiple/Ejemplo1.java)
2. [Ejemplo 2](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Paso%20Multiple/Ejemplo2.java)
3. [Ejemplo 3](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Paso%20Multiple/Ejemplo3.java)
4. [Ejemplo 4](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Paso%20Multiple/Ejemplo4.java)
5. [Ejemplo 5](https://github.com/GonzaPortillo/MetodosNumericos-Repteticion/blob/main/Tema6/Paso%20Multiple/Ejemplo5.java)

