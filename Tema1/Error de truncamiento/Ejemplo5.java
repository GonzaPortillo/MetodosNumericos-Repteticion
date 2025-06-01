import java.util.ArrayList;

public class TruncamientoEjemplo5 {

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
        double[] valores = {123.456789, 987.654321, 456.789123};
        int decimales = 4;
        System.out.println("Ejemplo 5 - Errores de Truncamiento: " + calcularErrorTruncamiento(valores, decimales));
    }
}
