import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a quantidade de pessoas que serão registradas: ");
        int iQtdePessoas = sc.nextInt();

        List<Pessoa> listPessoasMasculino = new ArrayList<>();
        List<Pessoa> listPessoasFeminino = new ArrayList<>();

        for (int i = 0; i < iQtdePessoas; i++) {
            Pessoa pessoa = new Pessoa();

            System.out.printf("Digite o nome da %d° pessoa: ", i + 1);
            pessoa.setNome(sc.next());

            System.out.printf("Digite o sexo da %d° pessoa (M ou F): ", i + 1);
            pessoa.setSexo(sc.next());

            if (pessoa.getSexo().equals("M")) {
                listPessoasMasculino.add(pessoa);
            }
            else {
                listPessoasFeminino.add(pessoa);
            }
        }

        System.out.println("Grupo masculino: " + listPessoasMasculino);
        System.out.println("Grupo feminino: " + listPessoasFeminino);
    }
}