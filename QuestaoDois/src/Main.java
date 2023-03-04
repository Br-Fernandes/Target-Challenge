import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int num = input.nextInt();

        int a = 0;
        int b = 1;

        while (b < num) {
            int temp = b;
            b = a + b;
            a = temp;
        }

        if (b == num) {
            System.out.printf("O número %d pertence à sequência de Fibonacci.\n", num);
        } else {
            System.out.printf("O número %d não pertence à sequência de Fibonacci.\n", num);
        }
    }
}