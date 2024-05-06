package service;

import model.Alumno;

public interface AlumnosService {

	Alumno alumnoPorDni(String dni);

	boolean guardarAlumno(Alumno alumno);

}