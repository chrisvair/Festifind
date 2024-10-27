package edu.depinfo.apiweb.webproject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class MyController {

    @GetMapping(value="/")
    public String home() {
        return "index";
    }

    @GetMapping(value="/home")
    public String index(Model model) {
        return "index";
    }
    @GetMapping(value="/map")
    public String map() {
        return "map";
    }

    @GetMapping(value="/map-search")
    public String mapsearch(){return "mapsearch";}

    @GetMapping(value="/api")
    public String api() {
        return "api";
    }

    @GetMapping(value="/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping(value="/testFesti")
    public String testPing() {
        return "findit";
    }
}
