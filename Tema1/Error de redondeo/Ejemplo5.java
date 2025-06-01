import java.util.ArrayList;

public class Ejemplo5 {

    public static ArrayList<Double> calcularErrorRedondeo(double[] valores, int decimales) {
        ArrayList<Double> errores = new ArrayList<>();
        double factor = Math.pow(10, decimales);

        for (double valor : valores) {
            double valorRedondeado = Math.round(valor * factor) / factor;
            double error = Math.abs(valor - valorRedondeado);
            errores.add(error);
        }
        return errores;
    }

    public static void main(String[] args) {
        double[] valores = {123.456789, 987.654321, 456.789123};
        int decimales = 4;
        System.out.println("Ejemplo 5 - Errores de Redondeo: " + calcularErrorRedondeo(valores, decimales));
    }
}
