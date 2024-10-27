package edu.depinfo.apiweb.webproject.api;

import edu.depinfo.apiweb.webproject.Festival;
import edu.depinfo.apiweb.webproject.database.Comment;
import edu.depinfo.apiweb.webproject.database.FirebaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class FestivalControllerApi {

    private FestivalService festivalService = new FestivalService();
    private FirebaseService commentService = new FirebaseService();

    @GetMapping("/api/explore")
    public List<FestivalWithComments> getFestivalsAvecCommentaires(@RequestParam(value = "search", required = false) String search, @RequestParam(value = "value", required = false) String value) throws ExecutionException, InterruptedException {
        Festival[] festivals = festivalService.getAllFestivals(search, value);
        List<FestivalWithComments> festivalsAvecCommentaires = new ArrayList<>();

        for (Festival festival : festivals) {
            Comment[] commentaires = commentService.getComments(festival.getNom_du_festival()).getComments();
            FestivalWithComments festivalAvecCommentaires = new FestivalWithComments(festival, commentaires);
            festivalsAvecCommentaires.add(festivalAvecCommentaires);
        }

        return festivalsAvecCommentaires;
    }
}
