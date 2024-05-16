package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Provincia;
import service.DatosServiceFactory;

public class ComboBoxModelProvinciasImpl extends DefaultComboBoxModel<Provincia> {
	List<Provincia> provincias;
	
	public ComboBoxModelProvinciasImpl(String comunidad) {
		var datosService=DatosServiceFactory.getDatos();
		provincias=datosService.provinciasComunidad(comunidad);
	}

	@Override
	public int getSize() {		
		return provincias.size();
	}

	@Override
	public Provincia getElementAt(int index) {
		return provincias.get(index);
	}
	
}