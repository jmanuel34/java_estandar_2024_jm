package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NotasService {
	Path pt = Path.of("notas.txt");
	
	public void borrarNotas() {
		try {
			Files.deleteIfExists(pt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void agregarNota(double nota) {	
		try {
//			Files.writeString(pt, Double.toString(nota), StandardOpenOption.APPEND);
			Files.writeString(pt, Double.toString(nota), StandardOpenOption.APPEND, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		/*
		try(FileOutputStream fos=new FileOutputStream(fichero,true);
				PrintStream out=new PrintStream(fos)){
			out.println(nota);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		//*/
	}
	public double media() {
		try {
			return Files.lines(pt)		//Stream<String>
				.collect(Collectors.averagingDouble(s->Double.parseDouble(s)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}
		/*
		double media=0;
		int contador=0;
		String linea;
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			//mientras haya una nota que leer
			while((linea=bf.readLine())!=null) {
				contador++;
				media+=Double.parseDouble(linea);
			}
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return contador>0?media/contador:0;
//*/
	}
	public double max() {
		try {
			return Files.lines(pt)		//Stream<String>
					.max(Comparator.comparingDouble(s->Double.parseDouble(s)))   //Optional<String>
					.map(s->Double.parseDouble(s))   	//Optional<Dpouble>
					.orElse(0.0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (0.0);
		}
/*		double max=Double.MIN_VALUE;		
		String linea;
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			//mientras haya una nota que leer
			while((linea=bf.readLine())!=null) {
				
				if(Double.parseDouble(linea)>max) {
					max=Double.parseDouble(linea);
				}
			}
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return max; 
//*/
	}
	public double min() {
		try {
			return Files.lines(pt)		//Stream<String>
					.min(Comparator.comparingDouble(s->Double.parseDouble(s)))   //Optional<String>
					.map(s->Double.parseDouble(s))   	//Optional<Dpouble>
					.orElse(0.0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (0.0);
		}
/*
		double min=Double.MAX_VALUE;
		String linea;
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			//mientras haya una nota que leer
			while((linea=bf.readLine())!=null) {
				
				if(Double.parseDouble(linea)<min) {
					min=Double.parseDouble(linea);
				}
			}
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return min;
//*/
	}
	public List<Double> obtenerNotas() {
		try {
			return Files.lines(pt)		//Stream<String>
					.map(s->Double.parseDouble(s))
					.toList();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return List.of(0.0);
/*
		ArrayList<Double> aux=new ArrayList<Double>();
		String linea;
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			//mientras haya una nota que leer
			while((linea=bf.readLine())!=null) {
				
				aux.add(Double.parseDouble(linea));
			}
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return aux;
//*/
	}
}
}
