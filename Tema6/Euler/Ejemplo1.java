import java.text.DecimalFormat;

public class SistemasDeEcuacionesDiferencialesOrdinariasMétodoDeEuler {

    // Función f(x,y) = dy/dx
    public static double f(double x, double y) {
        return x + y;
    }

    // Método de Euler para resolver y' = f(x,y)
    public static void metodoEuler(double x0, double y0, double h, int n) {
        double x = x0, y = y0;
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.println("x\t\ty");
        for (int i = 0; i <= n; i++) {
            System.out.println(df.format(x) + "\t\t" + df.format(y));
            y = y + h * f(x, y);
            x = x + h;
        }
    }

    public static void main(String[] args) {
        metodoEuler(0, 1, 0.1, 10);
    }
}
