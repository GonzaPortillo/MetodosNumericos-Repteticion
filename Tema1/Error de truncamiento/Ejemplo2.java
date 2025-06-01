import java.util.ArrayList;

public class TruncamientoEjemplo2 {

    public static ArrayList<Double> calcularErrorTruncamiento(double[] valores, int decimales) {
        ArrayList<Double> errores = new ArrayList<>();
        double factor = Math.pow(10, decimales);

        for (double valor : valores) {
            double truncado = ((int)(valor * factor)) / factor;
            double error = Math.abs(valor - truncado);
            errores.add(error);
        }
        return errores;
    }

    public static void main(String[] args) {
        double[] valores = {9.87654, 7.12345, 6.99999};
        int decimales = 3;
        System.out.println("Ejemplo 2 - Errores de Truncamiento: " + calcularErrorTruncamiento(valores, decimales));
    }
}
