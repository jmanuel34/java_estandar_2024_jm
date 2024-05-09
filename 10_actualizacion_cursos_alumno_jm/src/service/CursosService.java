package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class CursosService {

	String cadenaConexion = "jdbc:mysql://localhost:3306/formacion";
	String usuario = "root";
	String password = "root";

	public boolean cursoPorId(int idCurso) {
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
			String sql = "select * from cursos where idCurso=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, idCurso);
			ResultSet rs = st.executeQuery();
			// debemos movernos a la primera y única fila, para poder extraer
			// el valor de dicha fila
			if (rs.next()) {
				return true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean agregar(Curso curso) {
		if (!cursoPorId(curso.getIdCurso())) {
			try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
				String sql = "insert into curso(curso,duracion,precio) values(?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				// sustituimos parámetros por valores
				ps.setString(1, curso.getCurso());
				ps.setInt(2, curso.getDuracion());
				ps.setDouble(3, curso.getPrecio());
				ps.execute();// NO se manda otra vez la SQL
				return true;

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}

	public List<Curso> mostrarCursos() {
		List<Curso> cursos = new ArrayList<Curso>();
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {

			String sql = "select * from cursos";
			PreparedStatement ps = con.prepareStatement(sql);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				cursos.add(new Curso(rs.getInt("idCurso"), rs.getString("curso"), rs.getInt("duracion"),
						rs.getDouble("precio"), null));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return cursos;

	}

	public Curso buscarPorNombre(String nombre) {
		Curso curso = null;
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {

			String sql = "select * from contactos where email = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, nombre);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				curso = new Curso(rs.getInt("idCurso"), (rs.getString("curso")), (rs.getInt("duracion")),
						(rs.getDouble("precio")), null);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return curso;
	}

}
