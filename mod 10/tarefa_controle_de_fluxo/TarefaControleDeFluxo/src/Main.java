import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> notas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 4; i++) {
            System.out.print("Digite a " + i + "° nota: ");
            int notaDigitada = scanner.nextInt();
            notas.add(notaDigitada);
        }



        int media = 0;

        Integer teste = 0;

        teste = media;

        for (int nota : notas) {
            media += nota;
        }

        media = media / notas.size();

        System.out.println("Média do aluno: " + media);

        if(media >= 7) {
            System.out.println("Aluno aprovado!!");
        }
        else if (media >= 5) {
            System.out.println("Aluno de recuperação!!");
        }
        else {
            System.out.println("Aluno reprovado!!");
        }
    }
}