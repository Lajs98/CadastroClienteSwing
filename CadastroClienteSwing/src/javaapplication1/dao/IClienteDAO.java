package javaapplication1.dao;

import javaapplication1.domain.Cliente;
import java.util.Collection;

public interface IClienteDAO {
    Boolean salvar(Cliente cliente);           
    void excluir(String cpf);                 
    Boolean atualizar(Cliente cliente);       
    Cliente consultar(String cpf);            
    Collection<Cliente> listarTodos();        
}
