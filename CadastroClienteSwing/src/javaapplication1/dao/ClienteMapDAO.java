package javaapplication1.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javaapplication1.domain.Cliente;

public class ClienteMapDAO implements IClienteDAO {

    private Map<String, Cliente> map = new HashMap<>();

    @Override
    public Boolean salvar(Cliente cliente) {
        if (map.containsKey(cliente.getCpf())) {
            return false; // já existe
        }
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(String cpf) {
        map.remove(cpf);
    }

    @Override
    public Boolean atualizar(Cliente cliente) {
        if (!map.containsKey(cliente.getCpf())) {
            return false; // não existe para atualizar
        }
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public Cliente consultar(String cpf) {
        return map.get(cpf);
    }

    @Override
    public Collection<Cliente> listarTodos() {
        return map.values();
    }
}
