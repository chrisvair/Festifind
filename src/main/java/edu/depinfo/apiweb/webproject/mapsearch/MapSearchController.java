package edu.depinfo.apiweb.webproject.mapsearch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MapSearchController {
    String baseUrl = "https://data.geopf.fr/geocodage/search";
    String limit = "1";
    String type = "municipality";


    @GetMapping(value="/mapsearch")
    public String getMunicipalities(@RequestParam(value = "search", required = false) String q, Model model) {
        String url = baseUrl + "?q=" + q + "&limit=" + limit + "&type=" + type;

        RestTemplate restTemplate = new RestTemplate();

        Query query = restTemplate.getForObject(url, Query.class);
        Feature feature = query.getFeatures()[0];
        Properties properties = feature.getProperties();
        String city = properties.getCity();
        double x, y;
        Geometry geometry = feature.getGeometry();
        x = geometry.getCoordinates()[0];
        y = geometry.getCoordinates()[1];
        model.addAttribute("city", city);
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "mapsearch";
    }

}
