import java.util.ArrayList;

public class TruncamientoEjemplo1 {

    public static ArrayList<Double> calcularErrorTruncamiento(double[] valores, int decimales) {
        ArrayList<Double> errores = new ArrayList<>();
        double factor = Math.pow(10, decimales);

        for (double valor : valores) {
            // Truncamiento simple usando casting a int tras multiplicar
            double truncado = ((int)(valor * factor)) / factor;
            double error = Math.abs(valor - truncado);
            errores.add(error);
        }
        return errores;
    }

    public static void main(String[] args) {
        double[] valores = {3.14159, 2.71828, 1.61803};
        int decimales = 2;
        System.out.println("Ejemplo 1 - Errores de Truncamiento: " + calcularErrorTruncamiento(valores, decimales));
    }
}

