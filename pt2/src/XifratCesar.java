import java.io.*;
import java.util.Scanner;

public class XifratCesar {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Clau: ");
        int clau = sc.nextInt();

        // xifrar
        BufferedReader br = new BufferedReader(new FileReader("entrada.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("xifrat.txt"));

        String linia;
        while ((linia = br.readLine()) != null) {
            // invertir
            String inv = new StringBuilder(linia).reverse().toString();
            // cesar
            String xifrada = "";
            for (int i = 0; i < inv.length(); i++) {
                xifrada += (char)(inv.charAt(i) + clau);
            }
            bw.write(xifrada);
            bw.newLine();
        }
        br.close();
        bw.close();
        System.out.println("Fitxer xifrat creat");

        // desxifrar
        br = new BufferedReader(new FileReader("xifrat.txt"));
        bw = new BufferedWriter(new FileWriter("desxifrat.txt"));

        while ((linia = br.readLine()) != null) {
            // cesar invers
            String desxifrada = "";
            for (int i = 0; i < linia.length(); i++) {
                desxifrada += (char)(linia.charAt(i) - clau);
            }
            // invertir
            String original = new StringBuilder(desxifrada).reverse().toString();
            bw.write(original);
            bw.newLine();
        }
        br.close();
        bw.close();
        System.out.println("Fitxer desxifrat creat");
    }
}
