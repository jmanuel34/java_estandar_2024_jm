package adaptadores;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Provincia;
import service.DatosServiceFactory;

public class TableModelProvinciasImpl extends AbstractTableModel {
	List<Provincia> provincias;
	public TableModelProvinciasImpl(String comunidad) {
		var datosService=DatosServiceFactory.getDatos();
		provincias = datosService.provinciasComunidad(comunidad);
		
	}
	@Override
	public int getRowCount() {
		return provincias.size();
	}
	@Override
	public int getColumnCount() {
		return 3;
	}
	@Override
	public String getColumnName(int column) {
		return switch(column) {
			case 0->"Codigo";
			case 1->"Nombre";
			case 2->"Comunidad Autonoma";
			default->"";
		};
	}
	@Override
	public Object getValueAt(int row, int column) {
		return switch(column) {
			case 0->provincias.get(row).getCodigoProvincia();
			case 1->provincias.get(row).getNombreProvincia();
			case 2->provincias.get(row).getComunidadAutonoma();	
			default->"";
		};
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return switch(columnIndex) {
			case 0->String.class;
			case 1->String.class;
			case 2->String.class;
			default->String.class;
		};
	}
	
}
