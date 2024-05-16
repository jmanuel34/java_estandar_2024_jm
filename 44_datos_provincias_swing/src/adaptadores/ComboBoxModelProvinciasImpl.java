package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Provincia;
import service.DatosProvinciasService;
import service.DatosProvinciasServiceFactory;

public class ComboBoxModelProvinciasImpl extends DefaultComboBoxModel<Provincia> {
	List<Provincia> provincias;
	public ComboBoxModelProvinciasImpl(String comunidad) {
		DatosProvinciasService service=DatosProvinciasServiceFactory.getDatosProvinciasService();
		provincias=service.provinciasComunidad(comunidad);
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
