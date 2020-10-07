import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            //System.out.println(htmlPage.asXml());
            HtmlElement element = htmlPage.getHtmlElementById("24709868");
           //System.out.println(element);

            List<HtmlElement> classElements = htmlPage.getByXPath("//tr[@class='athing']");
           // System.out.println( classElements.get(2));
           // List<HtmlElement> PositionList = htmlPage.getByXPath(".//td/span[@class='rank']");
            for(HtmlElement classElement: classElements) {
                int position = Integer.parseInt(
                        ((HtmlElement) classElement.getFirstByXPath("./td/span"))
                                .asText()
                                .replace(".", ""));

                String author = classElement.getFirstByXPath("//a[@class='hnuser']").toString();
                String replace = author.replace("(?<=id\\=).*", " ");
               // System.out.println(replace);
                String pattern = "(?<=id\\=).*";

                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(author);
                if (m.find( )) {
                   System.out.println("Found value: " + m.group(0) );

                }else {
                    System.out.println("NO MATCH");
                }

                String[] split = m.toString().split("\"");
                System.out.println("split"+split[0]);



             //   System.out.println(author);
//                String positionString = position.getTextContent().replace(".", " ");
//                System.out.println(positionString);
//                int positionInt = Integer.parseInt(positionString);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
