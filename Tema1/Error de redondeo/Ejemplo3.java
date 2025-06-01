import java.util.ArrayList;

public class Ejemplo3 {

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
        double[] valores = {0.33333, 0.66666, 0.99999};
        int decimales = 1;
        System.out.println("Ejemplo 3 - Errores de Redondeo: " + calcularErrorRedondeo(valores, decimales));
    }
}
