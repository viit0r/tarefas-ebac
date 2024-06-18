import java.util.*;

public class Main {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        listaNomes();
        listaNomesGenero();
    }

    private static void listaNomes() {
        System.out.println("****** LISTA NOMES ******");

        System.out.print("Digite os nomes separando por vírgula: ");
        String nomes = sc.next();

        List<String> listaNomes = Arrays.asList(nomes.split(","));

        Collections.sort(listaNomes);

        System.out.println("Nomes em ordem alfabética: " + listaNomes + "\n");
    }

    private static void listaNomesGenero() {
        System.out.println("****** LISTA NOMES E GENERO ******");

        System.out.println("Digite os nomes e gêneros, separando por vírgula e no seguinte formato: Vitor-M ");
        String nomesGenerosLidos = sc.next();

        String[] nomesGenerosSeparados = nomesGenerosLidos.split(",");

        List<String> nomesMasculinos = new ArrayList<>();
        List<String> nomesFemininos = new ArrayList<>();

        for (String nomeGenero : nomesGenerosSeparados) {
            if (nomeGenero.toUpperCase().contains("-M")) {
                nomesMasculinos.add(nomeGenero);
            }
            else {
                nomesFemininos.add(nomeGenero);
            }
        }

        System.out.println("Nomes masculinos: " + nomesMasculinos);
        System.out.println("Nomes femininos: " + nomesFemininos);
    }
}