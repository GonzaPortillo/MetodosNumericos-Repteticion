import java.text.DecimalFormat;

public class SistemasDeEcuacionesDiferencialesOrdinariasMétodoDeEuler {

    public static double f(double x, double y) {
        return x + y;
    }

    public static double yExacta(double x) {
        return -x - 1 + 2 * Math.exp(x);
    }

    public static void metodoEulerConError(double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;
        DecimalFormat df = new DecimalFormat("#.###");

        System.out.println("x\t\tyEuler\t\tyExacta\t\tError");
        for (int i = 0; i <= n; i++) {
            double yEx = yExacta(x);
            double error = Math.abs(yEx - y);
            System.out.println(df.format(x) + "\t\t" + df.format(y) + "\t\t" + df.format(yEx) + "\t\t" + df.format(error));

            y = y + h * f(x, y);
            x = x + h;
        }
    }

    public static void main(String[] args) {
        double x0 = 0;
        double y0 = 1;
        double h = 0.1;
        int n = 10;

        metodoEulerConError(x0, y0, h, n);
    }
}
