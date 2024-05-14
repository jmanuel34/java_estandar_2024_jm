package dao;

import model.Cliente;

public interface ClientesDao {

public Cliente getCliente(String usuario, String password);
public boolean registrar (Cliente cliente);

}
