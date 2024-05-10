package dao;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Pedido;
import serializacion.DeserializadorFecha;

public class TiendasJsonDaoImpl implements TiendasJsonDao {

	@Override
		public  List<Pedido> getPedidos(String ruta, String tienda) {
			String rutaCompleta= (ruta+tienda+".json");
			Gson gson=new GsonBuilder()//GsonBuilder
			.registerTypeAdapter(LocalDate.class, new DeserializadorFecha()) //GsonBuilder
			.create();
			try(FileReader reader=new FileReader(rutaCompleta);){
				return Arrays.stream(gson.fromJson(new FileReader(rutaCompleta), Pedido[].class)).toList();
			} catch (JsonSyntaxException | JsonIOException | IOException e) {
				e.printStackTrace();
				return new ArrayList<Pedido>();
				//				return Stream.empty().toList();			
		}
	}
}