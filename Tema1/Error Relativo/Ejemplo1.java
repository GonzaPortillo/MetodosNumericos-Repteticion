public class Main {
    public static void main(String[] args) {
        double valorReal = 100.0;
        double valorAproximado = 98.5;

        double errorRelativo = Math.abs((valorReal - valorAproximado) / valorReal);
        System.out.printf("Error Relativo: %.4f%n", errorRelativo);
    }
}

