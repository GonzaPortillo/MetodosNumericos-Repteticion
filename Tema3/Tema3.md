# Métodos de Solución de Sistemas de Ecuaciones


## Introduccion

Los métodos de solución de sistemas de ecuaciones son procedimientos matemáticos que se utilizan para encontrar las soluciones de un conjunto de ecuaciones simultáneas. En el contexto de la materia de Métodos Numéricos, se abordan técnicas específicas para resolver sistemas de ecuaciones de manera aproximada, especialmente cuando las soluciones exactas no son prácticas de obtener o cuando se trabaja con sistemas grandes y complejos.

Los metodos que veremos en esta ocacion son:

1. Eliminacion Gaussiana: Es un método algebraico utilizado para resolver sistemas de ecuaciones lineales. Consiste en transformar el sistema de ecuaciones en una forma escalonada (triangular superior) utilizando operaciones elementales de fila. Una vez en esta forma, se aplica la sustitución regresiva para encontrar las soluciones del sistema.
2. Gauss-Jordan: Es una extensión del método de eliminación gaussiana que transforma una matriz en su forma reducida por filas (forma escalonada reducida). Este método no solo convierte la matriz en una forma triangular superior, sino que también elimina todos los coeficientes por debajo y por encima de los pivotes, resultando en una matriz identidad en el lado izquierdo de la matriz aumentada.
3. Gauss-Seidel: Es un método iterativo utilizado para resolver sistemas de ecuaciones lineales. A diferencia de los métodos directos como la eliminación gaussiana, los métodos iterativos generan una sucesión de aproximaciones que convergen a la solución exacta.
4. Metodo de Jacobi: Método iterativo utilizado para resolver sistemas de ecuaciones lineales. En este método, cada componente del vector solución se calcula utilizando únicamente los valores de la iteración anterior. A diferencia del método de Gauss-Seidel, el método de Jacobi no usa las aproximaciones más recientes dentro de la misma iteración.

## Eliminacion Gaussiana

### Algoritmo

1. **Inicializar** la matriz aumentada del sistema de ecuaciones.

2. **Para** cada fila \( i \) desde la primera hasta la penúltima:
    1. **Para** cada fila \( k \) debajo de la fila \( i \) (es decir, \( k = i+1 \) hasta el final):
        1. Calcular el **factor**:  
           \[
           \text{factor} = \frac{a_{k,i}}{a_{i,i}}
           \]
        2. **Para** cada columna \( j \) desde la columna \( i \) hasta la última (incluyendo términos independientes):
           - Actualizar el elemento:  
             \[
             a_{k,j} = a_{k,j} - \text{factor} \times a_{i,j}
             \]
3. **Inicializar** un vector solución con tamaño igual al número de incógnitas.
4. **Para** cada fila \( i \) desde la última hasta la primera (en orden inverso):
    1. Asignar el término independiente como valor inicial para \( x_i \):  
       \[
       x_i = a_{i,n}
       \]
    2. **Para** cada columna \( j \) desde \( i+1 \) hasta el número de incógnitas:
       - Restar el producto de los coeficientes y soluciones ya calculadas:  
         \[
         x_i = x_i - a_{i,j} \times x_j
         \]
    3. Dividir por el coeficiente diagonal para despejar \( x_i \):  
       \[
       x_i = \frac{x_i}{a_{i,i}}
       \]
5. **Retornar** el vector solución con los valores de las incógnitas.

### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos

## Gauss Jordan

### Algoritmo
### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos

## Gauss Seidel

### Algoritmo
### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos

## Metodo de Jacobi

### Algoritmo
### Pseudocódigo
### Codigo en Java
### Caso de prueba
### Codigos
