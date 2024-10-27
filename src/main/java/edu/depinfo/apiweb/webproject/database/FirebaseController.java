package edu.depinfo.apiweb.webproject.database;

import edu.depinfo.apiweb.webproject.Festival;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@Controller
public class FirebaseController {
    public FirebaseService firebaseService;

    public FirebaseController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @PostMapping("/addComment")
    public String addComment(@RequestParam("festivalId") String festivalId,
                             @RequestParam("author") String author,
                             @RequestParam("content") String content,
                             @RequestParam("date") String date,
                             @RequestParam("id") String id) throws InterruptedException, ExecutionException {

        System.out.println("addComment");
        firebaseService.addComment(new Comment(id, content, author, date, festivalId));
        return "redirect:/festival";
    }

    @GetMapping("/getComments")
    public void getComments(@RequestParam String FestivalId) throws InterruptedException, ExecutionException {
        firebaseService.getComments(FestivalId);
    }

    @PostMapping("/addFestival")
    public void addFestival(@RequestBody FestivalDB festival) throws InterruptedException, ExecutionException {
        firebaseService.addFestival(festival);
    }
}
