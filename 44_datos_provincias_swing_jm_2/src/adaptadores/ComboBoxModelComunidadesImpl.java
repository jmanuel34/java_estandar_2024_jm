package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.DatosServiceFactory;

public class ComboBoxModelComunidadesImpl extends DefaultComboBoxModel<String> {
	List<String> continentes;
	
	public ComboBoxModelComunidadesImpl() {
		var datosService=DatosServiceFactory.getDatos();
		continentes=datosService.comunidades();
	}
	
	@Override
	public int getSize() {
		return continentes.size();
	}
	
	@Override
	public String getElementAt(int index) {
		return continentes.get(index);
	}
	
}
