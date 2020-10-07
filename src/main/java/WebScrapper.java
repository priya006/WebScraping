import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class WebScrapper {
    public static void main(String[] args) {

        String baseUrl = "https://news.ycombinator.com/";

        //To make a http request
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        //To make the site load faster
        webClient.getOptions().setJavaScriptEnabled(false);

        try {
            HtmlPage htmlPage = webClient.getPage(baseUrl);
            System.out.println(htmlPage.asXml());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
