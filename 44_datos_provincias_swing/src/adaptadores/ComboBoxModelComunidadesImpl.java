package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.DatosProvinciasService;
import service.DatosProvinciasServiceFactory;

public class ComboBoxModelComunidadesImpl extends DefaultComboBoxModel<String> {
	List<String> comunidades;
	public ComboBoxModelComunidadesImpl() {
		DatosProvinciasService service=DatosProvinciasServiceFactory.getDatosProvinciasService();
		comunidades=service.comunidades();
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
