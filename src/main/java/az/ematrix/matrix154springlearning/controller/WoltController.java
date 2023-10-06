package az.ematrix.matrix154springlearning.controller;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WoltController {


    @GetMapping("wolt")
    public void hello() throws IOException {
        String blogUrl = "https://wolt.com/en/aze/baku/venue/port-bazar";
        Document doc = Jsoup.connect(blogUrl).get();
        Elements p = doc.getElementsByTag("p");

        System.out.println(doc);
    }

}
