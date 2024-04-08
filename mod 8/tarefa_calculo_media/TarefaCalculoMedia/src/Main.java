import java.util.ArrayList;

/**
 * @author vitor.dev
 */
public class Main {
    public static void main(String[] args) {

        int notaUm = 10;
        int notaDois = 8;
        int notaTres = 8;
        int notaQuatro = 10;
        ArrayList<Integer> notas = new ArrayList<>();

        notas.add(notaUm);
        notas.add(notaDois);
        notas.add(notaTres);
        notas.add(notaQuatro);

        Media media = new Media();
        media.setNotas(notas);

        System.out.println(media.calculaMedia());
    }
}