public class Main {

    public static double calcularErrorRelativo(double real, double aprox) {
        return Math.abs((real - aprox) / real);
    }

    public static void main(String[] args) {
        System.out.println(calcularErrorRelativo(12.3, 11.9));
    }
}
