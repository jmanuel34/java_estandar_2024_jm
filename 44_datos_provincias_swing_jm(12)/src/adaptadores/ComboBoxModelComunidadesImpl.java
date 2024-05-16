package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.DatosServiceFactory;

public class ComboBoxModelComunidadesImpl extends DefaultComboBoxModel<String> {
	List<String> comunidades;
	
	public ComboBoxModelComunidadesImpl() {
		var datosService=DatosServiceFactory.getDatos();
		comunidades=datosService.comunidades();
	}
	
	@Override
	public int getSize() {
		return comunidades.size();
	}
	
	@Override
	public String getElementAt(int index) {
		return comunidades.get(index);
	}
	
}
