package Crawler1;					//Este lo archivo en el package Crawler, el cual luego llamo en el main

import java.io.BufferedReader;		//Al igual que la clase anterior, importo las librerias que estare utilizando desde la linea 3 hasta la 10
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Utilidades {		//Esta es mi clase utilidades, el cual me devuelve una lista de String de Arrays, el cual me lee el archivo

	public ArrayList<String> readFile(String urlsTxt) throws IOException { 	//Lanzo una exception para controlar los errores y ingreso un parametro urlsTxt
		File file = new File(urlsTxt);										//Luego creo mi metodo file, que contine los Strings en urls

		BufferedReader br = new BufferedReader(new FileReader(file));		//Luego para poder leer el archivo, lo hago con la libreria Buffer y luego que me lea el archivo con el filereader
		ArrayList<String> arreglo = new ArrayList<>();						//Seguido creo un metodo de arreglo de lista para ir añadiendo los Strings urls
		String st;															//Escribo una variable 
		while ((st = br.readLine()) != null)	//En donde luego realizo un bucle while en el que si me lea el archivo y sino esta vacio que me añada los urls al arrgeglo de strings
			arreglo.add(st);					//Los añade al arrglo
		br.close();								//Cierra el buffer
		return arreglo;							//Mientras que siempre retorne al archivo, ya que lo llamo en el main 
	}

	
	public File createLog(String name) throws IOException {	//En esta funcion simplemente creo mi archivo que estare utilizando para el log, es que el que llamo luego en el Main
		File file = new File(name);	//Creo el metodo
		file.createNewFile();	//Luego con el .createNewFile creo el archivo
		return file;	//Y luego que me retorne, ya que lo llamo al main 
	}
	
	public void writeLog(File file, ArrayList<String> urlList) throws IOException {		//Esta funcion la genero para escribir los datos en el archivo log el cual lo paso por una lista de urls
		
		FileWriter writer = new FileWriter(file);		//creo mi metodo file
		BufferedWriter bufferedWriter = new BufferedWriter(writer);		//Luego creo el metodo writer en donde mientras lea el docuemento lo vaya leyendo
		
		for (String url : urlList) {	//Luego genero un bucle for, con el url lo igualo a la lista de urls
			bufferedWriter.write(url);	//Luego que me escriba los String de urls
			bufferedWriter.newLine();	//Luego que el siguiente lo haga en una linea nueva hasta que se termine
		}
		bufferedWriter.close();			//Luego que me cierre el buffer
	}
	
	public void writeLog(File file, String url) throws IOException {	//En este tengo escrito los parametros similares a la funcion pasada, excepto que aqui no me devuelve un Array de urls sino un string de url

		FileWriter writer = new FileWriter(file);		//Creo mi metodo del file
		BufferedWriter bufferedWriter = new BufferedWriter(writer);	//Luego el metodo del buffer
	
		bufferedWriter.write(url);	//Luego que me escriba los String de urls
		bufferedWriter.newLine();	//Luego que el siguiente lo haga en una linea nueva hasta que se termine
		bufferedWriter.close();		//Luego que me cierre el buffer
	}

	public void writeNoprocesa(String urlsTxt, ArrayList<String> noProcesa) throws IOException {	//En esta funcion la creo apra que me escriba los link Noprocesados
		FileWriter writer = new FileWriter(urlsTxt);	//Creo mi metodo para que me escriba las urls 
		BufferedWriter bufferedWriter = new BufferedWriter(writer);	//Luego con el buffer writer las deberia escribir

		for (int i = 0; i < noProcesa.size(); i++) {	//En donde luego realizo un bucle for, el cual me recorre desde la posicion 0 y si es menor
			bufferedWriter.write(noProcesa.get(i));		//Que me vaya escribiendo los urls no Procesados
			bufferedWriter.newLine();					//Luego cuando lea la nueva linea lo siga haciendo hasta que se terimen los links
		}
		bufferedWriter.close();							//Luego que cierre el buffer
	}

	// Agrega a un archivo ya existente
	public void agregarNoprocesa(String urlsTxt, ArrayList<String> noProcess) throws IOException {		//En esta funcion agrego los links no procesados
		FileWriter fw = new FileWriter(urlsTxt, true);		//creo mi metodo y le agregto el verdadero, de manera que me escriba si agrego links por procesar de mas me los deje y escriba la lista de los que faltan
		BufferedWriter bufferedWriter = new BufferedWriter(fw);		//Luego con el buffer que los escriba
		for (int i = 0; i < noProcess.size(); i++) {				//Similar a la funcion pasada creo un bucle for en poscion 0, en donde me vaya agregarndo los links
			bufferedWriter.write(noProcess.get(i));					//Los vaya obteniendo como la variable i 
			bufferedWriter.newLine();								//Y luego siga en la siguiente linea
		}
		bufferedWriter.close();										//Luego que se cierre el buffer
	}

	public void deleteProcesados(String urlsTxt, ArrayList<String> procesados, ArrayList<String> noProcess) throws IOException {	//Aqui creo esta funcion para eliminar los procesados, ya que antes me imprian tantos los que proceso como los quue no juntos

		File file = new File(urlsTxt);		//Creo mi metodo en donde ingreo por parametros lo urls
		BufferedReader br = new BufferedReader(new FileReader(file));	//Con el buffer para que me lea el archivo
		ArrayList<String> nuevos = new ArrayList<>(); //Este Arreglo que va a tener los no procesados
		String st;	//Luego una variable st que utilizo en el bucle while
		// Creo en nuevos todos los no procesados
		while ((st = br.readLine()) != null) {	//En donde me lea el archivo mientras no este vacio
			if (!procesados.contains(st)) {		//Y si contiene los procesados, que lleva la variable
				noProcess.remove(st);			//Que me elimine los no procesados 
				nuevos.add(st);					//Y que los nuevos me los añada
			}
		}
		br.close();		//Luego que me cierre el buffer
		boolean result = Files.deleteIfExists(file.toPath()); // Luego Se borra el archivo urlsTxt para despues crearlo con los no procesados
		if (result) //Si el resultado esta
			writeNoprocesa(urlsTxt, nuevos); //Que me escriba la lista de los nuevos y los Noprocesados juntos
		else //Y si pasa algo
			System.out.println("Error borrando el archivo: " + urlsTxt); //Un mensaje de error

	}
	
}
