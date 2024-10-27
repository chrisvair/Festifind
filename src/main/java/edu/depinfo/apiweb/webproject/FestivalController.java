package edu.depinfo.apiweb.webproject;

import edu.depinfo.apiweb.webproject.database.Comment;
import edu.depinfo.apiweb.webproject.database.Comments;
import edu.depinfo.apiweb.webproject.database.FirebaseController;
import edu.depinfo.apiweb.webproject.database.FirebaseService;
import org.jsoup.nodes.Element;

import edu.depinfo.apiweb.webproject.mapsearch.Feature;
import edu.depinfo.apiweb.webproject.mapsearch.Geometry;
import edu.depinfo.apiweb.webproject.mapsearch.Properties;
import edu.depinfo.apiweb.webproject.mapsearch.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.Objects;


@Controller
public class FestivalController {
    String baseUrl = "https://data.culture.gouv.fr/api/explore/v2.1/catalog/datasets/festivals-global-festivals-_-pl/records?";
    String baseUrl2 = "https://data.geopf.fr/geocodage/search";
    String limit = "1";
    String type = "municipality";
  
    @GetMapping(value="/festival")
    public String getFestival(@RequestParam(value = "search", required = false) String search,@RequestParam(value = "value", required = false) String value, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url;
        double radius = 50;
        if (search != null && !search.isEmpty()) {

            if (Objects.equals(value, "Festival")) {
                url = baseUrl + "where='"+search+"'&limit=30";
            }
            else if (Objects.equals(value, "Month")) {
                url = baseUrl + "where='"+search+"'&limit=30";
            }
            else if (Objects.equals(value,"Location")){
                url = baseUrl + "where='"+search+"'&limit=100";
                System.out.println(url);
            }
            else if (Objects.equals(value,"Style")){
                url = baseUrl + "where=search(sous_categorie_musique,'"+search+"')&limit=30";
                System.out.println(url);
            }
            else {
                url = baseUrl + "limit=20";
            }
        } else {
            url = baseUrl + "limit=50";
        }
        Festivals festivals = restTemplate.getForObject(url, Festivals.class);

        if (Objects.equals(value, "Location")){
            Festivals toKeep = new Festivals();
            Coord coordFromCity = getCoordFromName(search);
            for (int i = 0; i < festivals.getResults().length ; i++ ) {
                if (festivals.getResults()[i].getGeocodage_xy()!= null && calculateDistance(festivals.getResults()[i].getGeocodage_xy().getLat(), festivals.getResults()[i].getGeocodage_xy().getLon(),coordFromCity.getLon(),coordFromCity.getLat()) <= radius){
                    toKeep.add(festivals.getResults()[i]);
                }
                if (toKeep.getResults().length == 20) {
                    break;
                }
            }
            model.addAttribute("festivals", toKeep);
        }
        else {
            model.addAttribute("festivals", festivals);
        }

        return "festivals";
    }

    @GetMapping(value="/festival-details")
    public String getFestivalByName(@RequestParam(value = "search", required = false) String search, Model model){
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "where='"+search+"'";

        // Récupérer le festival
        Festivals festivals = restTemplate.getForObject(url, Festivals.class);
        model.addAttribute("festival", festivals.getResults()[0]);
        // Récupérer les commentaires pour le festival
        FirebaseService firebaseService = new FirebaseService();
        Comments comments = getAllComments(festivals, firebaseService);
        model.addAttribute("comments", comments);
        return "festival";
    }

    private Comments getAllComments(Festivals festivals, FirebaseService firebaseService) {
        List<Comment> commentsList = new ArrayList<>();
        for (Festival festival : festivals.getResults()) {
            try {
                Comments commentsForFestival = firebaseService.getComments(festival.getNom_du_festival());
                for (Comment comment : commentsForFestival.getComments()) {
                    commentsList.add(comment);
                    //System.out.println("length of COMMENTS : " + comments.getComments().length);
                }

            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Créer un objet Comments à partir de la liste de commentaires
        Comments comments = new Comments();
        comments.setComments(commentsList.toArray(new Comment[0]));

        return comments;
    }

    @GetMapping(value="/festivalCoords")
    public String getFestivalCoords(@RequestParam(value = "search", required = false) String search,@RequestParam(value = "value", required = false) String value) {
        RestTemplate restTemplate = new RestTemplate();
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
        return restTemplate.getForObject(url, String.class);
    }

    public static double calculateDistance(double lat1d, double lon1d, double lat2d, double lon2d) {
        double lat1 = Math.toRadians(lat1d);
        double lon1 = Math.toRadians(lon1d);
        double lat2 = Math.toRadians(lat2d);
        double lon2 = Math.toRadians(lon2d);

        // Rayon de la Terre en kilomètres
        final double R = 6371.0;

        // Différence de latitude et de longitude entre les deux points
        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        // Formule de la distance haversine
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        return distance;
    }

    public Coord getCoordFromName(String q) {
        String url = baseUrl2 + "?q=" + q + "&limit=" + limit + "&type=" + type;

        RestTemplate restTemplate = new RestTemplate();

        Query query = restTemplate.getForObject(url, Query.class);
        Feature feature = query.getFeatures()[0];
        Properties properties = feature.getProperties();
        String city = properties.getCity();
        double x, y;
        Geometry geometry = feature.getGeometry();

        Coord coordToGet = new Coord();
        coordToGet.setLat(geometry.getCoordinates()[0]);
        coordToGet.setLon(geometry.getCoordinates()[1]);
        return coordToGet;
    }
}