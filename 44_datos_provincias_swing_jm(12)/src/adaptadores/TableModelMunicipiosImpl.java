package adaptadores;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Municipio;
import service.DatosServiceFactory;

public class TableModelMunicipiosImpl extends AbstractTableModel {
	List<Municipio> municipios;
	public TableModelMunicipiosImpl(String id) {
		var datosService=DatosServiceFactory.getDatos();
		municipios = datosService.municipiosComunidad(id);
		
	}
	@Override
	public int getRowCount() {
		return municipios.size();
	}
	@Override
	public int getColumnCount() {
		return 5;
	}
	@Override
	public String getColumnName(int column) {
		return switch(column) {
			case 0->"Nombre";
			case 1->"Nombre Provincia";
			case 2->"Poblacion";
			case 3->"Altitud";
			case 4->"Superficie";
			default->"";
		};
	}
	@Override
	public Object getValueAt(int row, int column) {
		return switch(column) {
			case 0->municipios.get(row).getNombreMunicipio();
			case 1->municipios.get(row).getNombreProvincia();
			case 2->municipios.get(row).getPoblacion();
			case 3->municipios.get(row).getAltitud();
			case 4->municipios.get(row).getSuperficie();
			default->"";
		};
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return switch(columnIndex) {
			case 0->String.class;
			case 1->String.class;
			case 2->String.class;
			case 3->Integer.class;
			case 4->Double.class;		
			default->String.class;
		};
	}
	
}
