import java.text.DecimalFormat;

public class SistemasDeEcuacionesDiferencialesOrdinariasMétodoDeEuler {

    public static double f(double x, double y) {
        return -2 * y + 3 * x;
    }

    public static void metodoEuler(double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;
        DecimalFormat df = new DecimalFormat("#.###");

        System.out.println("x\t\ty");
        for (int i = 0; i <= n; i++) {
            System.out.println(df.format(x) + "\t\t" + df.format(y));
            y = y + h * f(x, y);
            x = x + h;
        }
    }

    public static void main(String[] args) {
        double x0 = 0;
        double y0 = 1;
        double h = 0.1;
        int n = 12;

        metodoEuler(x0, y0, h, n);
    }
}
