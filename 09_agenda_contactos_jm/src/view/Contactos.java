package view;

import java.util.Scanner;

import model.Contacto;
import service.ContactosService;
/*
 * 
 * 1.-Nuevo Contacto
 * 2.-Eliminar Contacto
 * 3.-Actualizar edad
 * 4.-Salir
 * 1: Se piden los datos del nuevo contacto y se guarda
 * 2: Solicita el email y borra el contacto con dicho email
 * 3: Solicita email y nueva edad, y sustituye la edad anterior por la nueva en ese contacto 
 */
// */
public class Contactos {
	static ContactosService service = new ContactosService();

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		do {
			//presentar menu
			//leer opción y comprobar opcion elegida
			presentarMenu();
			try{
				opcion=Integer.parseInt(sc.nextLine());
				switch(opcion) {
					case 1:
						agregarContacto();
						break;
					case 2:
						eliminarContacto();
						break;
					case 3:
						actualizarContacto();
						break;
					case 4:
						System.out.println("Adios!");
						break;				
					default:
						System.out.println("Opción no válida!");
				}
			}
			catch(NumberFormatException ex) {
				System.out.println("Debe ser un valor numérico!!");
			}
		}while(opcion!=4);
	}
	
	static void presentarMenu() {
		System.out.println("""
				1.- Agregar Contacto
				2.- Eliminar Contacto
				3.- Actualizar Contacto
				4.- Salir
				
				""");
	}
	
	public static void agregarContacto() {	
		String nombre;
		String email;
		int edad;
		Contacto contacto;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca el nombre del contacto: ");
		nombre = sc.nextLine();
		System.out.println("Introduzca el email del contacto: ");
		email = sc.nextLine();
		System.out.println("Introduzca la edad: ");
		edad = Integer.parseInt(sc.nextLine());
//		contacto = new Contacto(nombre, email, edad);
		service.agregar(new Contacto(nombre, email, edad));

	}
	
	public static void eliminarContacto() {
		String email;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca el email del contacto a eliminar: ");
		email = sc.nextLine();
		service.eliminarContacto(email);	
	}
	
	public static void actualizarContacto() {
		String email;
		int edad;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca el email del contacto para actualizar: ");
		email = sc.nextLine();
		System.out.println("Introduzca la nueva edad: ");
		edad = Integer.parseInt(sc.nextLine());
		service.actualizarEdad(email, edad);
	}
	
}