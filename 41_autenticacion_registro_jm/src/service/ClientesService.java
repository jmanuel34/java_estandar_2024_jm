package service;

import model.Cliente;

public interface ClientesService {

	boolean autenticar(String nombre, String password);
	boolean registrar (Cliente cliente);
}