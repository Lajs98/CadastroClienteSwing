package javaapplication1.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javaapplication1.domain.Cliente;

public class ClienteSetDAO implements IClienteDAO {

    private Set<Cliente> set = new HashSet<>();

    @Override
    public Boolean salvar(Cliente cliente) {
        return set.add(cliente); // retorna false se já existir (pelo equals/hashcode do CPF)
    }

    @Override
    public void excluir(String cpf) {
        Cliente cliente = consultar(cpf);
        if (cliente != null) {
            set.remove(cliente);
        }
    }

    @Override
    public Boolean atualizar(Cliente cliente) {
        Cliente existente = consultar(cliente.getCpf());
        if (existente != null) {
            set.remove(existente);
            set.add(cliente);
            return true;
        }
        return false; // não existe para atualizar
    }

    @Override
    public Cliente consultar(String cpf) {
        for (Cliente c : set) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> listarTodos() {
        return set;
    }
}
