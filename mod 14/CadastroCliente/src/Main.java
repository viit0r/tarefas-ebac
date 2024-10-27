import dao.ClienteMapDAO;
import dao.IClienteDAO;
import domain.Cliente;

import javax.swing.*;

public class Main {

    private static IClienteDAO iClienteDAO;

    private static final String OPCAO_CADASTRO = "1";
    private static final String OPCAO_CONSULTA = "2";
    private static final String OPCAO_EXCLUSAO = "3";
    private static final String OPCAO_ALTERACAO = "4";
    private static final String OPCAO_SAIR = "5";

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = coletaOpcaoValida();

        continuaProcessamentoOpcaoSelecionada(opcao);
    }

    private static String coletaOpcaoValida() {
        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair.",
                "Cadastro",
                JOptionPane.INFORMATION_MESSAGE);

        while(!isOpcaoValida(opcao)) {
            if (opcao.isEmpty()) {
                sair();
                break;
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida!\nDigite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair.",
                    "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        return opcao;
    }

    private static void continuaProcessamentoOpcaoSelecionada(String opcao) {
        while(isOpcaoValida(opcao)) {
            switch (opcao) {
                case OPCAO_CADASTRO: {
                    String dados = JOptionPane.showInputDialog(null,
                            "Digite os dados do cliente, separando-os por vírgula na seguinte sequência: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado",
                            "Cadastro",
                            JOptionPane.INFORMATION_MESSAGE);

                    cadastrar(dados);
                    break;
                }
                case OPCAO_CONSULTA: {
                    String cpf = JOptionPane.showInputDialog(null,
                            "Digite o CPF",
                            "Consultar",
                            JOptionPane.INFORMATION_MESSAGE);

                    consultar(cpf);
                    break;
                }
                case OPCAO_EXCLUSAO: {
                    String cpf = JOptionPane.showInputDialog(null,
                            "Digite o CPF",
                            "Excluir",
                            JOptionPane.INFORMATION_MESSAGE);

                    excluir(cpf);
                    break;
                }
                case OPCAO_ALTERACAO: {
                    String cpf = JOptionPane.showInputDialog(null,
                            "Digite o CPF",
                            "Alterar",
                            JOptionPane.INFORMATION_MESSAGE);

                    Cliente clienteRecuperado = iClienteDAO.consultar(cpf);

                    if(clienteRecuperado != null) {
                        String dadosFormatados = clienteRecuperado.getNome() + "," +  clienteRecuperado.getTelefone() + "," + clienteRecuperado.getEndereco() + "," + clienteRecuperado.getNumero() + "," + clienteRecuperado.getCidade() + "," + clienteRecuperado.getEstado();

                        String dadosAtualizados = (String) JOptionPane.showInputDialog(null,
                                "Atualize os dados abaixo para o CPF " + clienteRecuperado.getCpf(),
                                "Alterar",
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                null,
                                dadosFormatados);

                        alterar(clienteRecuperado, dadosAtualizados);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Cliente com este CPF não encontrado na base de dados!",
                                "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                }
                case OPCAO_SAIR: {
                    sair();
                    break;
                }
                default: {
                    break;
                }
            }

            opcao = coletaOpcaoValida();
            continuaProcessamentoOpcaoSelecionada(opcao);
        }
    }

    private static boolean isOpcaoValida(String opcao) {
        return opcao.equals("1") ||
                opcao.equals("2") ||
                opcao.equals("3") ||
                opcao.equals("4") ||
                opcao.equals("5");
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null,
                "Até logo!",
                "Saindo...",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");

        Cliente cliente = new Cliente(dadosSeparados[0].trim(), dadosSeparados[1].trim(), dadosSeparados[2].trim(), dadosSeparados[3].trim(), dadosSeparados[4].trim(), dadosSeparados[5].trim(), dadosSeparados[6].trim());
        boolean isClienteCadastrado = iClienteDAO.cadastrar(cliente);

        if (isClienteCadastrado) {
            JOptionPane.showMessageDialog(null,
                    "Cliente cadastrado com sucesso!",
                    "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Cliente já possui cadastro!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void consultar(String cpf) {
        Cliente clienteRecuperado = iClienteDAO.consultar(cpf);

        if(clienteRecuperado != null) {
            JOptionPane.showMessageDialog(null,
                    "Cliente encontrado: " + clienteRecuperado,
                    "Consultar",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Cliente com este CPF não encontrado na base de dados!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void excluir(String cpf) {
        Cliente clienteRecuperado = iClienteDAO.consultar(cpf);

        if(clienteRecuperado != null) {
            iClienteDAO.excluir(clienteRecuperado.getCpf());

            JOptionPane.showMessageDialog(null,
                    "Cliente excluído com sucesso!",
                    "Excluir",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Cliente com este CPF não encontrado na base de dados!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void alterar(Cliente clienteRecuperado, String dados) {
        String[] dadosSeparados = dados.split(",");

        Cliente cliente = new Cliente(dadosSeparados[0].trim(), clienteRecuperado.getCpf(), dadosSeparados[1].trim(), dadosSeparados[2].trim(), dadosSeparados[3].trim(), dadosSeparados[4].trim(), dadosSeparados[5].trim());
        iClienteDAO.alterar(cliente);

        JOptionPane.showMessageDialog(null,
                "Dados alterados com sucesso!",
                "Alterar",
                JOptionPane.INFORMATION_MESSAGE);
    }
}