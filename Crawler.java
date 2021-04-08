import Crawler.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Crawler {

    public static void main(String[] args) throws IOException, InterruptedException {
        
		try{
			Acceso_Fichero entrada = new Acceso_Fichero();
			entrada.read();

			String url = "https://example.com";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending GET resquest to URL: " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine; 
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

		}catch(Exception e){
			System.out.println(e);
		}
	}	
}