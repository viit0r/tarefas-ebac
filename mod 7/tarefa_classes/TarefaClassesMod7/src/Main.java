public class Main {
    public static void main(String[] args) {
        Computador computador = new Computador();

        computador.setPlacaMae("B550M Aorus Elite");

        computador.setCpu("AMD Ryzen 5600");

        computador.setGpu("MSI RTX 2060");

        computador.setMemoriaRam("Asgard");
        computador.setQtdeGbMemoriaRam(32);

        computador.setFonte("MAG A650BN");
        computador.setPotenciaFonte(650);

        computador.setTemSsd(true);
        computador.setSsd("Kingstom 1TB M2");

        computador.setGabinete("Aigo Darkflash C285");

        computador.setQtdeFans(6);

        System.out.println(computador);
    }
}