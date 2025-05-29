public class Main {
    public static double errorRelativo(double valorReal, double valorAproximado) {
        return Math.abs((valorReal - valorAproximado) / valorReal);
    }

    public static void main(String[] args) {
        double valorReal = 50;
        double valorAproximado = 47;

        System.out.printf("Error Relativo: %.4f%n", errorRelativo(valorReal, valorAproximado));
    }
}
