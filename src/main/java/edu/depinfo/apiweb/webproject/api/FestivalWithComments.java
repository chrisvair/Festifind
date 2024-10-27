package edu.depinfo.apiweb.webproject.api;

import edu.depinfo.apiweb.webproject.Festival;
import edu.depinfo.apiweb.webproject.database.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FestivalWithComments {
    private Festival festival;
    private Comment[] commentaires;

    public FestivalWithComments(Festival festival, Comment[] commentaires) {
        this.festival = festival;
        this.commentaires = commentaires;
    }

}

