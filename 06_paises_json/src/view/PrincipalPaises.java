package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import service.PaisesService;

/*
 * Implementar lógica de negocio de una aplicación que proporcione información
 * sobre paises. Cada pais se caracteriza por: nombre,continente,capital,habitantes
 * 
 * -Lista de continentes
 * -Lista de paises a partir del continente
 * -Pais más poblado 
 * -Tabla con paises agrupados por continente
 * -Pais a partir de su capital  
 */
public class PrincipalPaises {
	static PaisesService service = new PaisesService();
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
						listaContinentes();
						break;
					case 2:
						paisesEnContinente();
						break;
					case 3:
						masPoblado();
						break;
					case 4:
						paisesPorContinentes();
						break;
					case 5:
						paisPorCapital();
						break;
					case 6:
						System.out.println("Adios!");
						break;				
					default:
						System.out.println("Opción no válida!");
				}
			}//end try
			catch(NumberFormatException ex) {
				System.out.println("Debe ser un valor numérico!!");
			}
		}while(opcion!=6);

	}
	static void presentarMenu() {
		System.out.println("""
				1.- Lista de continentes
				2.- Lista de paises a partir del continente
				3.- Pais más poblado
				4.- Tabla con paises agrupados por continente
				5.- Pais a partir de su capital
				6.- Salir
				
				""");
	}
	
	public static void listaContinentes() {
		service.continentes().stream()
				.forEach(p->System.out.println(p));
	}
	
	public static void paisesEnContinente() {
		String continente;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca el continente: ");
		continente = sc.nextLine();	
		service.paisesEnContinente(continente)
			.stream()
			.forEach(c->System.out.println(c.getNombre()));
	}

	//	-Pais más poblado
	public static void masPoblado() {
		service.masPoblado()
			.toString();
	}
	
	// -Tabla con paises agrupados por continente
	public static void paisesPorContinentes() {
//		service.listadoPorContinentes().
			
	}
	
//	-Pais a partir de su capital  
	public static void paisPorCapital() {
		String capital;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca la capital: ");
		capital = sc.nextLine();
		service.getPaisporCapital(capital)
			.ifPresentOrElse(p->{
				System.out.println(p.getNombre()+" ");
				System.out.println(p.getCapital()+ " ");
				System.out.println(p.getContinente());
				System.out.println(p.getHabitantes());
			}, ()->System.out.println("No existe pais con esa capital"));
			
	}

}
