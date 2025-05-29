import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[][] valores = {
            {30, 29},
            {42, 41},
            {55, 52}
        };

        ArrayList<Double> errores = new ArrayList<>();
        for (double[] par : valores) {
            double vr = par[0];
            double va = par[1];
            double error = Math.abs((vr - va) / vr);
            errores.add(error);
        }

        System.out.println("Errores Relativos: " + errores);
    }
}
