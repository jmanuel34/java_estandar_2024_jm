package service;

import dao.ClientesDao;
import model.Cliente;

public class ClientesServiceImpl implements ClientesService {
	
	ClientesDao clientesDao;
	
	@Override
	public boolean autenticar(String nombre, String password) {
		Cliente c = clientesDao.getCliente(nombre, password);
		if (c!=null && c.getUsuario().equals(nombre) && c.getPassword().equals(password))
				return true;
		return false;
	}

	@Override
	public boolean registrar(Cliente cliente) {
		if (clientesDao.getCliente(cliente.getUsuario(), cliente.getPassword())!=null) {
			clientesDao.registrar(cliente);
			return true;
		}
		else return false;
	}

}
