package  Crawler;
import java.io.*;
import java.net.*;

public class Acceso_Fichero{

    public void read(){
              
        try{

            URL url = new URL("https://example.com");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(url.openStream()));
            File file = new File ("body.html");
            BufferedWriter salida = new BufferedWriter(new FileWriter(file));
            
            String valor; 
            while ((valor = entrada.readLine()) !=null )
            salida.write(valor);

            entrada.close();
            salida.close();
            System.out.println("Generado exitosamente");//si todo sale bien mostramos un mensaje de guardado exitoso

        }catch(IOException e) {
            System.out.println("No se ha encontrado el archivo seleccionado");
        }
    }
}



