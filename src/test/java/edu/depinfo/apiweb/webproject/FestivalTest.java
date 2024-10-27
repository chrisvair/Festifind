package edu.depinfo.apiweb.webproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(FestivalController.class) // Web tests for FestivalController
public class FestivalTest {

    @Autowired
    private MockMvc mockMvc; // Inject MockMcv
    private TestRestTemplate restTemplate;

    @Test
    public void getNom_du_festival() throws JsonProcessingException {
        //test en réduisant la liste des festivals au 1er de la liste, avec un json en dur
        String festivalsjson = "{\"total_count\": 1, \"results\": [{\"nom_du_festival\": \"Les Nuits (Re)Belles\", \"envergure_territoriale\": null, \"region_principale_de_deroulement\": \"Bourgogne-Franche-Comté\", \"departement_principal_de_deroulement\": \"Jura\", \"commune_principale_de_deroulement\": \"Brainans\", \"code_postal_de_la_commune_principale_de_deroulement\": \"39800\", \"code_insee_commune\": \"39073\", \"code_insee_epci_collage_en_valeur\": \"200071595\", \"libelle_epci_collage_en_valeur\": \"CC Arbois, Poligny, Salins, Cœur du Jura\", \"numero_de_voie\": null, \"type_de_voie_rue_avenue_boulevard_etc\": null, \"nom_de_la_voie\": null, \"adresse_postale\": null, \"complement_d_adresse_facultatif\": null, \"site_internet_du_festival\": \"http://www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf\", \"adresse_e_mail\": null, \"decennie_de_creation_du_festival\": \"2010 et après\", \"annee_de_creation_du_festival\": \"2014\", \"discipline_dominante\": \"Musique\", \"sous_categorie_spectacle_vivant\": null, \"sous_categorie_musique\": null, \"sous_categorie_musique_cnm\": \"07- Musiques actuelles sans distinction\", \"sous_categorie_cinema_et_audiovisuel\": null, \"sous_categorie_arts_visuels_et_arts_numeriques\": null, \"sous_categorie_livre_et_litterature\": null, \"periode_principale_de_deroulement_du_festival\": \"Saison (21 juin - 5 septembre)\", \"identifiant_agence_a\": null, \"identifiant\": \"FEST_39073_1020\", \"geocodage_xy\": {\"lon\": 5.6278782462, \"lat\": 46.8746666632}, \"identifiant_cnm\": 2980}]}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Festivals festivals = objectMapper.readValue(festivalsjson, Festivals.class);
            Assert.assertEquals(festivals.getResults()[0].getNom_du_festival(),"Les Nuits (Re)Belles");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPeriode_principale_de_deroulement_du_festival() throws JsonProcessingException {
        //test en réduisant la liste des festivals au 1er de la liste, avec un json en dur
        String festivalsjson = "{\"total_count\": 1, \"results\": [{\"nom_du_festival\": \"Les Nuits (Re)Belles\", \"envergure_territoriale\": null, \"region_principale_de_deroulement\": \"Bourgogne-Franche-Comté\", \"departement_principal_de_deroulement\": \"Jura\", \"commune_principale_de_deroulement\": \"Brainans\", \"code_postal_de_la_commune_principale_de_deroulement\": \"39800\", \"code_insee_commune\": \"39073\", \"code_insee_epci_collage_en_valeur\": \"200071595\", \"libelle_epci_collage_en_valeur\": \"CC Arbois, Poligny, Salins, Cœur du Jura\", \"numero_de_voie\": null, \"type_de_voie_rue_avenue_boulevard_etc\": null, \"nom_de_la_voie\": null, \"adresse_postale\": null, \"complement_d_adresse_facultatif\": null, \"site_internet_du_festival\": \"http://www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf\", \"adresse_e_mail\": null, \"decennie_de_creation_du_festival\": \"2010 et après\", \"annee_de_creation_du_festival\": \"2014\", \"discipline_dominante\": \"Musique\", \"sous_categorie_spectacle_vivant\": null, \"sous_categorie_musique\": null, \"sous_categorie_musique_cnm\": \"07- Musiques actuelles sans distinction\", \"sous_categorie_cinema_et_audiovisuel\": null, \"sous_categorie_arts_visuels_et_arts_numeriques\": null, \"sous_categorie_livre_et_litterature\": null, \"periode_principale_de_deroulement_du_festival\": \"Saison (21 juin - 5 septembre)\", \"identifiant_agence_a\": null, \"identifiant\": \"FEST_39073_1020\", \"geocodage_xy\": {\"lon\": 5.6278782462, \"lat\": 46.8746666632}, \"identifiant_cnm\": 2980}]}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Festivals festivals = objectMapper.readValue(festivalsjson, Festivals.class);
            Assert.assertEquals(festivals.getResults()[0].getPeriode_principale_de_deroulement_du_festival(),"Saison (21 juin - 5 septembre)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCommune_principale_de_deroulement() throws JsonProcessingException {
        //test en réduisant la liste des festivals au 1er de la liste, avec un json en dur
        String festivalsjson = "{\"total_count\": 1, \"results\": [{\"nom_du_festival\": \"Les Nuits (Re)Belles\", \"envergure_territoriale\": null, \"region_principale_de_deroulement\": \"Bourgogne-Franche-Comté\", \"departement_principal_de_deroulement\": \"Jura\", \"commune_principale_de_deroulement\": \"Brainans\", \"code_postal_de_la_commune_principale_de_deroulement\": \"39800\", \"code_insee_commune\": \"39073\", \"code_insee_epci_collage_en_valeur\": \"200071595\", \"libelle_epci_collage_en_valeur\": \"CC Arbois, Poligny, Salins, Cœur du Jura\", \"numero_de_voie\": null, \"type_de_voie_rue_avenue_boulevard_etc\": null, \"nom_de_la_voie\": null, \"adresse_postale\": null, \"complement_d_adresse_facultatif\": null, \"site_internet_du_festival\": \"http://www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf\", \"adresse_e_mail\": null, \"decennie_de_creation_du_festival\": \"2010 et après\", \"annee_de_creation_du_festival\": \"2014\", \"discipline_dominante\": \"Musique\", \"sous_categorie_spectacle_vivant\": null, \"sous_categorie_musique\": null, \"sous_categorie_musique_cnm\": \"07- Musiques actuelles sans distinction\", \"sous_categorie_cinema_et_audiovisuel\": null, \"sous_categorie_arts_visuels_et_arts_numeriques\": null, \"sous_categorie_livre_et_litterature\": null, \"periode_principale_de_deroulement_du_festival\": \"Saison (21 juin - 5 septembre)\", \"identifiant_agence_a\": null, \"identifiant\": \"FEST_39073_1020\", \"geocodage_xy\": {\"lon\": 5.6278782462, \"lat\": 46.8746666632}, \"identifiant_cnm\": 2980}]}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Festivals festivals = objectMapper.readValue(festivalsjson, Festivals.class);
            Assert.assertEquals(festivals.getResults()[0].getCommune_principale_de_deroulement(),"Brainans");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSite_internet_du_festival() throws JsonProcessingException {
        //test en réduisant la liste des festivals au 1er de la liste, avec un json en dur
        String festivalsjson = "{\"total_count\": 1, \"results\": [{\"nom_du_festival\": \"Les Nuits (Re)Belles\", \"envergure_territoriale\": null, \"region_principale_de_deroulement\": \"Bourgogne-Franche-Comté\", \"departement_principal_de_deroulement\": \"Jura\", \"commune_principale_de_deroulement\": \"Brainans\", \"code_postal_de_la_commune_principale_de_deroulement\": \"39800\", \"code_insee_commune\": \"39073\", \"code_insee_epci_collage_en_valeur\": \"200071595\", \"libelle_epci_collage_en_valeur\": \"CC Arbois, Poligny, Salins, Cœur du Jura\", \"numero_de_voie\": null, \"type_de_voie_rue_avenue_boulevard_etc\": null, \"nom_de_la_voie\": null, \"adresse_postale\": null, \"complement_d_adresse_facultatif\": null, \"site_internet_du_festival\": \"http://www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf\", \"adresse_e_mail\": null, \"decennie_de_creation_du_festival\": \"2010 et après\", \"annee_de_creation_du_festival\": \"2014\", \"discipline_dominante\": \"Musique\", \"sous_categorie_spectacle_vivant\": null, \"sous_categorie_musique\": null, \"sous_categorie_musique_cnm\": \"07- Musiques actuelles sans distinction\", \"sous_categorie_cinema_et_audiovisuel\": null, \"sous_categorie_arts_visuels_et_arts_numeriques\": null, \"sous_categorie_livre_et_litterature\": null, \"periode_principale_de_deroulement_du_festival\": \"Saison (21 juin - 5 septembre)\", \"identifiant_agence_a\": null, \"identifiant\": \"FEST_39073_1020\", \"geocodage_xy\": {\"lon\": 5.6278782462, \"lat\": 46.8746666632}, \"identifiant_cnm\": 2980}]}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Festivals festivals = objectMapper.readValue(festivalsjson, Festivals.class);
            Assert.assertEquals(festivals.getResults()[0].getSite_internet_du_festival(),"http://www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getGeocodage_xy() throws JsonProcessingException {
        //test en réduisant la liste des festivals au 1er de la liste, avec un json en dur
        String festivalsjson = "{\"total_count\": 1, \"results\": [{\"nom_du_festival\": \"Les Nuits (Re)Belles\", \"envergure_territoriale\": null, \"region_principale_de_deroulement\": \"Bourgogne-Franche-Comté\", \"departement_principal_de_deroulement\": \"Jura\", \"commune_principale_de_deroulement\": \"Brainans\", \"code_postal_de_la_commune_principale_de_deroulement\": \"39800\", \"code_insee_commune\": \"39073\", \"code_insee_epci_collage_en_valeur\": \"200071595\", \"libelle_epci_collage_en_valeur\": \"CC Arbois, Poligny, Salins, Cœur du Jura\", \"numero_de_voie\": null, \"type_de_voie_rue_avenue_boulevard_etc\": null, \"nom_de_la_voie\": null, \"adresse_postale\": null, \"complement_d_adresse_facultatif\": null, \"site_internet_du_festival\": \"http://www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf\", \"adresse_e_mail\": null, \"decennie_de_creation_du_festival\": \"2010 et après\", \"annee_de_creation_du_festival\": \"2014\", \"discipline_dominante\": \"Musique\", \"sous_categorie_spectacle_vivant\": null, \"sous_categorie_musique\": null, \"sous_categorie_musique_cnm\": \"07- Musiques actuelles sans distinction\", \"sous_categorie_cinema_et_audiovisuel\": null, \"sous_categorie_arts_visuels_et_arts_numeriques\": null, \"sous_categorie_livre_et_litterature\": null, \"periode_principale_de_deroulement_du_festival\": \"Saison (21 juin - 5 septembre)\", \"identifiant_agence_a\": null, \"identifiant\": \"FEST_39073_1020\", \"geocodage_xy\": {\"lon\": 5.6278782462, \"lat\": 46.8746666632}, \"identifiant_cnm\": 2980}]}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Festivals festivals = objectMapper.readValue(festivalsjson, Festivals.class);
            Coord geocodage = festivals.getResults()[0].getGeocodage_xy();
            Assert.assertEquals(geocodage.getLon(),5.6278782462,0.0000000001);
            Assert.assertEquals(geocodage.getLat(),46.8746666632,0.0000000001);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSous_categorie_musique() throws JsonProcessingException {
        //test en réduisant la liste des festivals au 1er de la liste, avec un json en dur
        String festivalsjson = "{\"total_count\": 1, \"results\": [{\"nom_du_festival\": \"Les Nuits (Re)Belles\", \"envergure_territoriale\": null, \"region_principale_de_deroulement\": \"Bourgogne-Franche-Comté\", \"departement_principal_de_deroulement\": \"Jura\", \"commune_principale_de_deroulement\": \"Brainans\", \"code_postal_de_la_commune_principale_de_deroulement\": \"39800\", \"code_insee_commune\": \"39073\", \"code_insee_epci_collage_en_valeur\": \"200071595\", \"libelle_epci_collage_en_valeur\": \"CC Arbois, Poligny, Salins, Cœur du Jura\", \"numero_de_voie\": null, \"type_de_voie_rue_avenue_boulevard_etc\": null, \"nom_de_la_voie\": null, \"adresse_postale\": null, \"complement_d_adresse_facultatif\": null, \"site_internet_du_festival\": \"http://www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf\", \"adresse_e_mail\": null, \"decennie_de_creation_du_festival\": \"2010 et après\", \"annee_de_creation_du_festival\": \"2014\", \"discipline_dominante\": \"Musique\", \"sous_categorie_spectacle_vivant\": null, \"sous_categorie_musique\": null, \"sous_categorie_musique_cnm\": \"07- Musiques actuelles sans distinction\", \"sous_categorie_cinema_et_audiovisuel\": null, \"sous_categorie_arts_visuels_et_arts_numeriques\": null, \"sous_categorie_livre_et_litterature\": null, \"periode_principale_de_deroulement_du_festival\": \"Saison (21 juin - 5 septembre)\", \"identifiant_agence_a\": null, \"identifiant\": \"FEST_39073_1020\", \"geocodage_xy\": {\"lon\": 5.6278782462, \"lat\": 46.8746666632}, \"identifiant_cnm\": 2980}]}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Festivals festivals = objectMapper.readValue(festivalsjson, Festivals.class);
            Assert.assertEquals(festivals.getResults()[0].getSous_categorie_musique(),null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fixUrl() {
        Festival festival = new Festival();
        String url1 = null;
        Assertions.assertNull(festival.fixUrl(url1));
        String url2 = "http://www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf";
        Assertions.assertEquals(festival.fixUrl(url2), "http://www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf");
        String url3 = "www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf";
        Assertions.assertEquals(festival.fixUrl(url3), "http://www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf");
        String url4 = "https://www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf";
        Assertions.assertEquals(festival.fixUrl(url4), "https://www.moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf");
        String url5 = "moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf";
        Assertions.assertEquals(festival.fixUrl(url5), "http://moulindebrainans.com/wp-content/uploads/2017/06/Depliant_LesNuitsReBelles4.pdf");
    }
}