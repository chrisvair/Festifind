package edu.depinfo.apiweb.webproject.database;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String content;
    private String author;
    private String date;
    private String festivalId;

    public Comment(String id, String content, String author, String date, String festivalId) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.date = date;
        this.festivalId = festivalId;
    }

    public Comment() {
    }
    @Id
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getFestivalId() {
        return festivalId;
    }

    public String getContentOfComment() {
        return content;
    }
}
