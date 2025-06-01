import java.util.ArrayList;

public class Ejemplo4 {

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
        double[] valores = {1.005, 2.675, 3.456};
        int decimales = 2;
        System.out.println("Ejemplo 4 - Errores de Redondeo: " + calcularErrorRedondeo(valores, decimales));
    }
}
