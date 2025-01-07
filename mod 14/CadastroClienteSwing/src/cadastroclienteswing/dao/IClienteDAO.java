package cadastroclienteswing.dao;

import cadastroclienteswing.domain.Cliente;

public interface IClienteDAO {

    Boolean cadastrar(Cliente cliente);

    void excluir(String cpf);

    void alterar(Cliente cliente);

    Cliente consultar(String cpf);
}
