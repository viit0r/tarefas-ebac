package cadastroclienteswing.dao;

import cadastroclienteswing.domain.Cliente;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO {

    private final Map<String, Cliente> map;

    public ClienteMapDAO(){
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(map.containsKey(cliente.getCpf())) {
            return false;
        }

        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(String cpf) {
        Cliente clienteCadastrado = map.get(cpf);

        if(clienteCadastrado != null) {
            map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = map.get(cliente.getCpf());

        if(clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTelefone(cliente.getTelefone());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setEndereco(cliente.getEndereco());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
        }

        map.put(cliente.getCpf(), clienteCadastrado);
    }

    @Override
    public Cliente consultar(String cpf) {
        return map.get(cpf);
    }
}
