public class Ejemplo2{
  public static void main(String []args){
    double valorreal = 75.2;
    double valoraprox = 73.5;

    double errorab = Math.abs(valorreal - valoraprox);

    System.out.printf("Error Absoluto %.2f%n", errorab);
  }
}
