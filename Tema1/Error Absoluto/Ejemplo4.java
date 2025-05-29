public class Ejemplo4 {
  
    public static void main(String[] args) {
      
        double[][] valores = {{150, 148}, {60, 59}, {200, 195}};

        for (double[] par : valores) {
            System.out.printf("Error Absoluto: %.2f%n", Math.abs(par[0] - par[1]));
        }
      
    }
  
}
