package adaptadores;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Cliente;
import service.CajeroServiceFactory;

public class TableModelClientesImpl extends AbstractTableModel {
	List<Cliente> clientes;
	public TableModelClientesImpl(int idCuenta) {
		var clientesService = CajeroServiceFactory.getCajeroService();
		clientes = clientesService.obtenerTitulares(idCuenta);
	}
	@Override
	public int getRowCount() {
		return clientes.size();
	}
	@Override
	public int getColumnCount() {
		return 4;
	}
	@Override
	public String getColumnName(int column) {
		return switch(column) {
			case 0->"Dni";
			case 1->"Nombre";
			case 2->"Direccion";
			case 3->"Telefono";
			default->"";
		};
	}
	@Override
	public Object getValueAt(int row, int column) {
		return switch(column) {
			case 0->clientes.get(row).getDni();
			case 1->clientes.get(row).getNombre();
			case 2->clientes.get(row).getDireccion();
			case 3->clientes.get(row).getTelefono();
			default->"";
		};
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return switch(columnIndex) {
			case 0->int.class;
			case 1->String.class;
			case 2->String.class;
			case 3->int.class;
			default->String.class;
		};
	}
	
}
