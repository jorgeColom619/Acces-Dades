import java.io.*;

public class Main {

    public static void main(String[] args) {

        int totalCaracters = 0;
        int totalLinies = 0;
        int totalParaules = 0;
        boolean dinsParaula = false;
        int[] aparicions = new int[65536];

        try (FileReader fr = new FileReader("text.txt")) {

            int llegit;

            while ((llegit = fr.read()) != -1) {

                char caracter = (char) llegit;

                boolean esSeparador = caracter == ' ' || caracter == '\t' || caracter == '\n' || caracter == '\r';

                if (caracter != '\n' && caracter != '\r') totalCaracters++;
                if (caracter == '\n') totalLinies++;

                if (!esSeparador && !dinsParaula) {
                    totalParaules++;
                    dinsParaula = true;
                } else if (esSeparador) {
                    dinsParaula = false;
                }

                if (!esSeparador) aparicions[caracter]++;
            }

            if (totalCaracters > 0) totalLinies++;

            int maxAparicions = 0;
            char caracterMesRepetit = ' ';
            for (int i = 0; i < aparicions.length; i++) {
                if (aparicions[i] > maxAparicions) {
                    maxAparicions = aparicions[i];
                    caracterMesRepetit = (char) i;
                }
            }

            System.out.println("Nombre de caràcters: " + totalCaracters);
            System.out.println("Nombre de línies: " + totalLinies);
            System.out.println("Nombre de paraules: " + totalParaules);
            System.out.println("Caràcter més repetit: " + caracterMesRepetit);

        } catch (FileNotFoundException e) {
            System.out.println("El fitxer no existeix.");
        } catch (IOException e) {
            System.out.println("Error de lectura.");
        }
    }
}