import java.util.ArrayList;

/**
 * @author vitor.dev
 */
public class Media {
    private ArrayList<Integer> notas;

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }

    public String calculaMedia() {
        int somaNotas = 0;

        for(int nota : notas) {
            somaNotas += nota;
        }

        return "A média é: " + (somaNotas / notas.size());
    }
}
