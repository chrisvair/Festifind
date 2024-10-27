package edu.depinfo.apiweb.webproject.database;

public class FestivalDB {
    private String nom_du_festival;

    public FestivalDB(String nomDuFestival) {
        this.nom_du_festival = nomDuFestival;
    }

    public String getNom_du_festival() {
        return nom_du_festival;
    }
}
