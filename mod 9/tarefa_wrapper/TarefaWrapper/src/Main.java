import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um valor numérico: ");
        int valorLido = scanner.nextInt();

        Integer valorWrapper = valorLido;
        System.out.println("Valor wrapper: " + valorWrapper);
    }
}