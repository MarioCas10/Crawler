import Crawler1.*;		//Primero realizo el import para crear la carpeta que contendra mis clases.java 

import java.io.File;	//Luego importo las librerias que esatre usando, desde la linea 3 hasta la 9
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {		//Primeramente creo mi Main que es en donde esatre llamando a mis funciones
	public static void main(String[] args) throws IOException {		//Aqui genero que me lanze el IOException para ver si se me produce algun error
		Utilidades util = new Utilidades();		//Llamo a mi clase Utilidades.java el cual contine las diferentes funciones que se esatrana ultilizando durante el codigo
		File file = util.createLog(nameLog);	//Aqui tal como el proyecto lo pide, con la variable util creo un archivo log en donde estare archivando las urls, que simplemnete la llamo desde la clase utilidades
		Crawler parser = new Crawler();			//Aqui creo a mi metodo Crawler, el cual me devuelve simplemente dos listas de Arrays, una de urls procesados y otra que no.
		parser.noProcess = util.readFile(urlTxt);	//Aqui me devuelve los urls no procesados, el cual los va leyendo con la funcion que cree en utilidades que es readFile, para que me lea el contenidos de als urls.
		Integer numUrl = 1;	//Aqui simplemente inicializo una variable en 1
		Integer indice = 0;	//Aqui inicializo una variable en 0 
		while ((numUrl < maxHTTP) && (indice < parser.noProcess.size())) {	//Luego creo un bucle while en donde me recorra las lista de Arrays y lo hace la siguinete manera
			String actualUrl = parser.noProcess.get(indice);	//Si el numero de Urls que esta en 1 es menor que el maxHTTP o el indice es menor que la cadena de Strings de links no procesados, me va tomando los links actuales noPorcesados desde la posicion 0. 
			System.out.println(" * a: " + actualUrl );	//Luego cuando me los tome vaya imprimiendo String por String.
			parser.urlList.add(actualUrl);	//Luego la Lista de String con el parser, me los vaya añadiendo en la variable del link actual
			numUrl = parser.crawl(actualUrl, numUrl );	//Luego llamo a mi metodo crawl en donde inserta el link actual y el numero de urls a la lista de String de Arrays. 
			indice++;	//Aqui solo llamo a la variable para que me vaya recorriendo las posciones cada vez que cumpla con lo que contiene el while.
		}
	
		util.deleteProcesados(urlTxt, parser.urlList, parser.noProcess);	// Borrar de urls.txt la lista de procesados, en donde hace una rutina que dado un url chequee si esta en la lista parser.urlList y si esta lo elimine
		util.agregarNoprocesa(urlTxt, parser.noProcess);	// Como siguiente, agregar a urls.txt los no procesados
		util.writeLog(file, parser.urlList);	//Luego que me los vaya escribiendo en el archivo log

		System.out.println("Crawler finished. Total No procesados: " + parser.noProcess.size()); //Con este print muestra la cantidad de links no procesados
		System.out.println("Crawler finished. Total URLs: " + parser.urlList.size());	//Con este print muestra la cantidad de links procesados 
	}
	

	private ArrayList<String> urlList;	//Lista de Urls Procesados 
	private ArrayList<String> noProcess;	//Lista de Urls NoProcesados 
	public static final String nameLog = "/home/mario/Grado2/JavaCrawler/links.log";	//Aqui para poder leer los archivos que ya estan creados, simplemente los busco a traves de las carpetas de mi ordenador. 
	public static final String urlTxt = "/home/mario/Grado2/JavaCrawler/urls.txt";		//A1ui realizo el mismo proceso que ne la linea de arriba, esto se hace para generar permisos hacia los archivos que yo quiero tener accesos. 
	public static final Integer maxHTTP = 10;	//Como se puede ver, arriba en el while no especifico el maxHTTP, pero el maximo es 10, el cual ese numero es tentaivo ya que se puede cambiar como desees, para ver la cantidad de links procesados.
	
	public Crawler() {		//Esta funcion tambien la llamo en el MaIN, en me devuelve los listas de Arrays
		this.urlList = new ArrayList<String>();	//Lista de los urls
		this.noProcess = new ArrayList<String>();	//Lista de los urls no procesados. 
	}
	
	public int crawl(String url, Integer numUrl) throws IOException {	//Esta en mi funcion crawl, en donde le inserto como parametros String url y la variable que creo arriba numUrl
		if (numUrl > maxHTTP)	//Aqui creo un if, en donde si el numero de urls es mayor el su maximo.
			return numUrl;		//Me retorne a numero de urls 
		Document doc = Jsoup.connect(url).get();	//Este metodo, asi como lo tengo es neceasrio decir que me apoye de internet, en donde con la libreria de documentes y Jsoup, las conecto para obterner los urls
		Elements links = doc.select("a[href]");		//Esta linea lo que hace es crearme hyperlinks que contenga cada urls de cierta pagina
		for (Element link : links) {	//Aqui realizo un bucle for en donde si el link es igual a los links, em haga lo siguiente
			String actualUrl = link.attr("abs:href"); //En donde si quiero obtener un link completo de cierta pagina es necesario implementar esto y escribir lo que esta en comillas, ya que eso me obtiene la direccion HTTP
			noProcess.add(actualUrl);	//Luego aqui, los links no Procesados me los vaya añadiendo a los actuales, de esa forma puedo saber cuales son ya me los añade al Array.
		}
		noProcess.remove(url);	//Luego aqui como tuve conflictos ya que me escribia los links no procesados, una vez que se cumplan el bucle de arriba me los elimine, ya de esa forma no se imprime por pantalla
		for (Element link : links) {	//Luego repito el mismo metodo que el bucle for pasado.
			if (numUrl > maxHTTP) break;	//Solo que aqui controlo que cuando el numero de urls sea mayor el maximo que tengo asignado, se detenga.
			String actualUrl = link.attr("abs:href");	//Y me escriba la direccion de los urls.
			
			if (!(urlList.contains(actualUrl))) { 	//Aqui creo la condicion, en donde si la lista de Arrays contiene el url actual, me lo imprima.
				System.out.println(" * a: " + actualUrl + " " + link.text());	//Aqui me imprime el ink actual, mas el texto que contiene cada link.
				urlList.add(actualUrl);		//Luego que me vaya añadiendo los links de la lista de urls a la actual
				numUrl++;	//Llamo a la variable en donde con el ++ me los va seguir agregando hasta que la condicion se cumpla
				numUrl = crawl(actualUrl, numUrl); //De misma forma que en el main escribo esta linea en donde inserta el link actual y el numero de urls a la lista de String de Arrays, solo que aqui lo llamo con el crawler y arriba le agrego el parser.crawler
			}
		}
		return numUrl;	//Y luego despues que termine todo, me retorne al numero de urls. 
	}

}