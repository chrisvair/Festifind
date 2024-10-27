package edu.depinfo.apiweb.webproject;

import org.jsoup.nodes.Element;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Festival {

    private String nom_du_festival;
    private String periode_principale_de_deroulement_du_festival;
    private String commune_principale_de_deroulement;
    private String site_internet_du_festival;
    private Coord geocodage_xy;
    private String sous_categorie_musique;


    public String getNom_du_festival() {
        return nom_du_festival;
    }

    public String getPeriode_principale_de_deroulement_du_festival() {
        return periode_principale_de_deroulement_du_festival;
    }

    public String getCommune_principale_de_deroulement() {
        return commune_principale_de_deroulement;
    }

    public String getSite_internet_du_festival() {
        return fixUrl(site_internet_du_festival);
    }

    public Coord getGeocodage_xy() {
        return geocodage_xy;
    }

    public String getSous_categorie_musique() {
        return sous_categorie_musique;
    }

    public String fixUrl(String url) {
        // if the url is null, return null
        if (url == null) {
            return null;
        }
        if (url.startsWith("http://") || url.startsWith("https://")) {
            return url;
        } else {
            return "http://" + url;
        }
    }


}
