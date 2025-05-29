import java.util.ArrayList;

public class Main {
    public static ArrayList<Double> calcularErrorAbsoluto(double[][] valores) {
        ArrayList<Double> errores = new ArrayList<>();
        for (double[] par : valores) {
            double vr = par[0];
            double va = par[1];
            errores.add(Math.abs(vr - va));
        }
        return errores;
    }

    public static void main(String[] args) {
        double[][] datos = {
            {120, 118},
            {85, 83},
            {95, 92}
        };

        System.out.println(calcularErrorAbsoluto(datos));
    }
}
