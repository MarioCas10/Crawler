import Crawler.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Crawler {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        Acceso_Fichero entrada = new Acceso_Fichero();
        entrada.read();

        String Crawler = System.getProperty("user.dir")+"/";
	    //long inicio = System.currentTimeMillis();
	    String Url = "https://example.com";
	    String Text = "urls.txt";
	    int codigo = StatusCode.getStatusConnectionCode(Url);
	    if(codigo==200){
	        crearOComprobarArchivo(Url, Crawler+Text);
            System.out.println(codigo);
	    }else{
	        JOptionPane.showMessageDialog(new JFrame(),"No se ha podido cargar la página.\nEl Status code que "+"devuelve la página es: "+codigo);
	   }
		System.exit(0);
        
        Set<String> visitedUrls = new HashSet<>();
        String url = "https://example.com";
        crawl(url, visitedUrls);
	}

    private static void crearOComprobarArchivo(String url, String crawler){}
    private static void crawl(String url, Set<String> visited) {}
}