import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;


public class WebScrapper {
    public static void main(String[] args) {

        String baseUrl = "https://news.ycombinator.com/";

        //To make a http request
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        //To make the site load faster
        webClient.getOptions().setJavaScriptEnabled(false);

        try {
            HtmlPage htmlPage = null;
            try {
                htmlPage = webClient.getPage(baseUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Locate the entire hacker news and loops through the web elements you need
            List<HtmlElement> classElements = htmlPage.getByXPath("//tr[@class='athing']");
            for(HtmlElement classElement: classElements) {
                int position = Integer.parseInt(
                        ((HtmlElement) classElement.getFirstByXPath("./td/span"))
                                .asText()
                                .replace(".", ""));


                    String author = ((HtmlElement) classElement
                            .getFirstByXPath("./following-sibling::tr/td[@class='subtext']/a[@class='hnuser']"))
                            .asText();
                    System.out.println(author);

                    //asText() converts webElement to a String
                    String firstByXPath = ((HtmlElement) classElement.getFirstByXPath("./following-sibling::tr/td[@class='subtext']/span[@class='score']")).asText();
                  int Score = Integer.parseInt(firstByXPath.replace(" points",""));
                    System.out.println(Score);
             //Converting Object to Json Using Jackson library
            HackerNewsItem hackerNewsItem = new HackerNewsItem(position,author,Score);
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    String jsonString = objectMapper.writeValueAsString(hackerNewsItem);
                    System.out.println("Json String: "+jsonString);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }




        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }
}
