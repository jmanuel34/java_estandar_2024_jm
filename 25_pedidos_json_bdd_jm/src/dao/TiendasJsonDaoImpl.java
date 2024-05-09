package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Pedido;
import model.Tienda;

public class TiendasJsonDaoImpl implements TiendasJsonDao {

	@Override
		public  List<Pedido> getPedidos(String ruta) {
			Gson gson = new Gson();
			try {
				return Arrays.stream(gson.fromJson(new FileReader(ruta), Pedido[].class)).toList();
			} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}

}

