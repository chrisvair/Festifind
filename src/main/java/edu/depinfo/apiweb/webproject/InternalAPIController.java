package edu.depinfo.apiweb.webproject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InternalAPIController {

    //@Autowired
    //private YourAPIService yourAPIService;

    @GetMapping("/api/data")
    public ResponseEntity<?> getData(@RequestParam(value = "search", required = false) String search, @RequestParam(value = "value", required = false) String value) {
        FestivalController festivalController = new FestivalController();
        // Appelez la méthode getFestivalCoords de votre contrôleur
        String data = festivalController.getFestivalCoords(search, "Festival");

        return ResponseEntity.ok(data);
    }
}
