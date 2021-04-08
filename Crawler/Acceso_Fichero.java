package  Crawler;
import java.io.*;
import java.net.URI;
import java.net.http.HttpResponse;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import javax.swing.text.Document;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.*;



public class Acceso_Fichero{

    public void read() throws InterruptedException{
        String URL = "https://example.com";
        try{
            
            HttpClient Client = HttpClient.newHttpClient();
            HttpRequest Request = HttpRequest.newBuilder()
            .uri(URI.create(URL))
            .build();
            HttpResponse<String> response = Client.send(Request, HttpResponse.BodyHandlers.ofString());
            String code = response.body();
            System.out.println(code);
            
            URL url = new URL("https://example.com/");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(url.openStream()));
            File file = new File ("body.html");
            File text = new File("urls.txt");
            BufferedWriter salida = new BufferedWriter(new FileWriter(file));
            
            String valor; 
            while ((valor = entrada.readLine()) !=null ){
            salida.write(valor);
            }

            entrada.close();
            salida.close();
            System.out.println("Generado exitosamente");//si todo sale bien mostramos un mensaje de guardado exitoso
      

            Document doc = Jsoup.parse(file, "UTF-8", url.toString());
            Elements links = doc.select("a[href]");
            BufferedWriter linkWriter = new BufferedWriter(new FileWriter(text));
            for (Element link: links){
                String sublink = link.attr("href");
                linkWriter.write(sublink);

            }
        linkWriter.close();
        }catch(IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }
}


