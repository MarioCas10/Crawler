package Crawler1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Utilidades {

	public ArrayList<String> readFile(String urlsTxt) throws IOException {
		File file = new File(urlsTxt);

		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<String> arreglo = new ArrayList<>();
		String st;
		while ((st = br.readLine()) != null)
			arreglo.add(st);
		br.close();
		return arreglo;
	}

	
	public File createLog(String name) throws IOException {
		File file = new File(name);
		file.createNewFile();
		return file;
	}
	
	public void writeLog(File file, ArrayList<String> urlList) throws IOException {
		
		FileWriter writer = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		
		for (String url : urlList) {
			bufferedWriter.write(url);
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}
	
	public void writeLog(File file, String url) throws IOException {

		FileWriter writer = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
	
		bufferedWriter.write(url);
		bufferedWriter.newLine();
		bufferedWriter.close();
	}

	public void writeNoprocesa(String urlsTxt, ArrayList<String> noProcesa) throws IOException {
		FileWriter writer = new FileWriter(urlsTxt);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);

		for (int i = 0; i < noProcesa.size(); i++) {
			bufferedWriter.write(noProcesa.get(i));
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}

	// Agrega a un archivo ya existente
	public void agregarNoprocesa(String urlsTxt, ArrayList<String> noProcess) throws IOException {
		FileWriter fw = new FileWriter(urlsTxt, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fw);
		for (int i = 0; i < noProcess.size(); i++) {
			bufferedWriter.write(noProcess.get(i));
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}

	public void deleteProcesados(String urlsTxt, ArrayList<String> procesados, ArrayList<String> noProcess) throws IOException {

		File file = new File(urlsTxt);
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<String> nuevos = new ArrayList<>(); // Arreglo que va a tener los no procesados
		String st;
		// Creo en nuevos todos los no procesados
		while ((st = br.readLine()) != null) {
			if (!procesados.contains(st)) {
				noProcess.remove(st);
				nuevos.add(st);
			}
		}
		br.close();
		// Se borra el archivo urlsTxt para despues crearlo con los no procesados
		boolean result = Files.deleteIfExists(file.toPath());
		if (result)
			writeNoprocesa(urlsTxt, nuevos);
		else
			System.out.println("Error borrando el archivo: " + urlsTxt);

	}
	
}
