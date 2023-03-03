import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input  = new Scanner(System.in);

        System.out.println("Escreva uma frase ou palavra qualquer");
        String texto = input.nextLine();

        char[] caracteres = texto.toCharArray();

        for (int i = 0; i < caracteres.length / 2; i++) {
            char temp = caracteres[i];
            caracteres[i] = caracteres[caracteres.length - 1 - i];
            caracteres[caracteres.length - 1 - i] = temp;
        }

        String textoInvertido = new String(caracteres);

        System.out.println(textoInvertido);

    }
}