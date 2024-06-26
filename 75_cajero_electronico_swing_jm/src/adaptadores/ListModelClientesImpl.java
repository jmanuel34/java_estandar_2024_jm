package adaptadores;

import java.util.List;

import javax.swing.DefaultListModel;

import model.Cliente;
import model.Titular;
import service.CajeroServiceFactory;

public class ListModelClientesImpl extends DefaultListModel<Cliente> {
	List<Cliente> titulares;

	public ListModelClientesImpl(int idCuenta) {
		var cajeroService = CajeroServiceFactory.getCajeroService();
		titulares = cajeroService.obtenerTitulares(idCuenta);
	}
	
	@Override
	public int getSize() {
		return titulares.size();
	}

	@Override
	public Cliente getElementAt(int index) {
		return titulares.get(index);
//		return new Cliente();
	}
	
}
