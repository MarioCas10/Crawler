package Crawler;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;


public class StatusCode {
    public static int getStatusConnectionCode(String url) {		
	    Response response = null;

	    try {
	    	response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
		} catch (IOException ex) {
	    	System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
	    }
	    return response.statusCode();
	}
}
