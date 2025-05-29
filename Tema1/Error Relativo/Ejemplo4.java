public class Main {
    public static double calcularErrorRelativo(double vReal, double vAprox) {
        return Math.abs((vReal - vAprox) / vReal);
    }

    public static void main(String[] args) {
        System.out.println(calcularErrorRelativo(25.4, 24.8));
    }
}
