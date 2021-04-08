package Crawler;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Jsoup {

public static class JsoupFindLink {

    public static void main(String[] args) throws IOException {

        for (String link : findLinks("https://google.com")) {
            System.out.println(link);
        }

    }

    private static Set<String> findLinks(String url) throws IOException {

        Set<String> links = new HashSet<>();

        Document doc = ((Object) Jsoup.connect(url))
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .get();

        Elements elements = doc.select("a[href]");
        for (Element element : elements) {
            links.add(element.attr("href"));
        }

        return links;

    }

}

public static Object connect(String url) {
    return null;
}

public static javax.swing.text.Document parse(File input, String string, String string2) {
    return null;
}
    
}
