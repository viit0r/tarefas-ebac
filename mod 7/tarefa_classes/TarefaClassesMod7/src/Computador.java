/**
 * @author vitor.dev
 */
public class Computador {

    private String placaMae;
    private String cpu;
    private String gpu;
    private String memoriaRam;
    private int qtdeGbMemoriaRam;
    private String fonte;
    private int potenciaFonte;
    private boolean temSsd;
    private String ssd;
    private boolean temHd;
    private String hd;
    private String gabinete;
    private int qtdeFans;

    public String getPlacaMae() {
        return placaMae;
    }

    public void setPlacaMae(String placaMae) {
        this.placaMae = placaMae;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(String memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public int getQtdeGbMemoriaRam() {
        return qtdeGbMemoriaRam;
    }

    public void setQtdeGbMemoriaRam(int qtdeGbMemoriaRam) {
        this.qtdeGbMemoriaRam = qtdeGbMemoriaRam;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public int getPotenciaFonte() {
        return potenciaFonte;
    }

    public void setPotenciaFonte(int potenciaFonte) {
        this.potenciaFonte = potenciaFonte;
    }

    public boolean isTemSsd() {
        return temSsd;
    }

    public void setTemSsd(boolean temSsd) {
        this.temSsd = temSsd;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public boolean isTemHd() {
        return temHd;
    }

    public void setTemHd(boolean temHd) {
        this.temHd = temHd;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getGabinete() {
        return gabinete;
    }

    public void setGabinete(String gabinete) {
        this.gabinete = gabinete;
    }

    public int getQtdeFans() {
        return qtdeFans;
    }

    public void setQtdeFans(int qtdeFans) {
        this.qtdeFans = qtdeFans;
    }

    /**
     * Método sobrescrito do padrão toString() do Java.
     *
     * @since 1.0
     * @return Retorna um texto formatado com as informações do computador.
     */
    @Override
    public String toString() {
        return "Computador:\n" +
                "{" +
                "\n placaMae=" + getPlacaMae() +
                ",\n cpu=" + getCpu() +
                ",\n gpu=" + getGpu() +
                ",\n memoriaRam=" + getMemoriaRam() +
                ",\n qtdeGbMemoriaRam=" + getQtdeGbMemoriaRam() +
                ",\n fonte=" + getFonte() +
                ",\n potenciaFonte=" + getPotenciaFonte() +
                ",\n temSsd=" + isTemSsd() +
                ",\n ssd=" + getSsd() +
                ",\n temHd=" + isTemHd() +
                ",\n hd=" + getHd() +
                ",\n gabinete=" + getGabinete() +
                ",\n qtdeFans=" + getQtdeFans() +
                "\n}";
    }
}
