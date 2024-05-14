package dao;

import model.Cliente;

public interface ClientesDao {
	Cliente findByUsuario(String usuario);
}
