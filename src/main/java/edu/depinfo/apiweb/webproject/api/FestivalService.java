package edu.depinfo.apiweb.webproject.api;

import edu.depinfo.apiweb.webproject.Festival;
import edu.depinfo.apiweb.webproject.FestivalController;
import edu.depinfo.apiweb.webproject.Festivals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class FestivalService {
    public Festival[] getAllFestivals(@RequestParam(value = "search", required = false) String search,@RequestParam(value = "value", required = false) String value) {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "https://data.culture.gouv.fr/api/explore/v2.1/catalog/datasets/festivals-global-festivals-_-pl/records?";
        String url;
        if (search != null && !search.isEmpty()) {

            if (Objects.equals(value, "Festival")) {
                url = baseUrl + "where='"+search+"'&limit=20";
            }
            else if (Objects.equals(value, "Month")) {
                url = baseUrl + "where='"+search+"'&limit=20";
            }
            else if (Objects.equals(value,"Location")){
                url = baseUrl + "where='"+search+"'&limit=100";
            }
            else {
                url = baseUrl + "limit=20";
            }
        } else {
            url = baseUrl + "limit=50";
        }
        Festivals festivals = restTemplate.getForObject(url, Festivals.class);

        assert festivals != null;
        return festivals.getResults();
    }
}
