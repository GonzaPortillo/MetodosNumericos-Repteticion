import java.text.DecimalFormat;

public class SistemasDeEcuacionesDiferencialesOrdinariasMétodoDeEuler {

    // Derivada dy/dx = f(x, y)
    public static double f(double x, double y) {
        return y - 2 * x;
    }

    // Solución exacta y(x) = -e^x + 2x + 2
    public static double solucionExacta(double x) {
        return -Math.exp(x) + 2 * x + 2;
    }

    public static void metodoEuler(double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;
        DecimalFormat df = new DecimalFormat("#.####");

        System.out.println("x\t\tEuler y\t\tExacta y\tError absoluto");
        for (int i = 0; i <= n; i++) {
            double yExacta = solucionExacta(x);
            double error = Math.abs(yExacta - y);
            System.out.println(df.format(x) + "\t\t" + df.format(y) + "\t\t" + df.format(yExacta) + "\t\t" + df.format(error));

            y = y + h * f(x, y);
            x = x + h;
        }
    }

    public static void main(String[] args) {
        double x0 = 0;
        double y0 = 1;
        double h = 0.1;
        int n = 15;

        metodoEuler(x0, y0, h, n);
    }
}
