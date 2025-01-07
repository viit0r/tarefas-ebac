import dao.ClienteMapDAO;
import dao.IClienteDAO;
import domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;
    private static final String OPCAO_CADASTRAR = "1";
    private static final String OPCAO_CONSULTAR = "2";
    private static final String OPCAO_EXCLUIR = "3";
    private static final String OPCAO_SAIR = "4";

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();
        String dados;

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão e 4 para sair.",
                "",
                JOptionPane.INFORMATION_MESSAGE);
        
        while (!isOpcaoValida(opcao)){
            if("".equals(opcao)){
                sair();
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consultar, 3 para exclusão e 4 para sair.",
                    "",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)){
            if (isOpcaoSelecionada(OPCAO_SAIR, opcao)){
                sair();
            }

            else if (isOpcaoSelecionada(OPCAO_CADASTRAR, opcao)){
                dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado",
                        "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE);

                cadastrar(dados);
            }

            else if (isOpcaoSelecionada(OPCAO_CONSULTAR, opcao)){
                dados = JOptionPane.showInputDialog(null,
                        "Informe o CPF",
                        "Consulta",
                        JOptionPane.INFORMATION_MESSAGE);
                
                consultar(dados);
            }

            else if (isOpcaoSelecionada(OPCAO_EXCLUIR, opcao)){
                dados = JOptionPane.showInputDialog(null,
                        "Informe o CPF",
                        "Exclusão",
                        JOptionPane.INFORMATION_MESSAGE);

                excluir(dados);
            }
        }
    }

    private static void excluir(String dados) {
        Cliente cliente = iClienteDAO.consultar(dados);

        if (cliente != null){
            iClienteDAO.excluir(dados);

            JOptionPane.showMessageDialog(null,
                    "Cliente excluído com sucesso!",
                    "Exclusão",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(dados);

        JOptionPane.showMessageDialog(null,
                cliente != null ? "Cliente encontrado: " + cliente : "Cliente não encontrado",
                "Consulta",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");

        Cliente cliente = new Cliente(
                dadosSeparados[0],
                dadosSeparados[1],
                dadosSeparados[2],
                dadosSeparados[3],
                dadosSeparados[4],
                dadosSeparados[5],
                dadosSeparados[6]
        );

        boolean isCadastrado = iClienteDAO.cadastrar(cliente);

        if(isCadastrado)
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!", "Erro", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoSelecionada(String opcaoEsperada, String opcaoSelecionada){
        return opcaoEsperada.equals(opcaoSelecionada);
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }
}
