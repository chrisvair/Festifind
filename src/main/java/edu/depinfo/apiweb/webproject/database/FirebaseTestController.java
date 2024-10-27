package edu.depinfo.apiweb.webproject.database;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FirebaseTestController {
    public void Firebase() throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        // Create a Map to store the data we want to set
        Map<String, Object> docData = new HashMap<>();
        docData.put("name", "Los Angeles");
        docData.put("state", "CA");
        docData.put("country", "USA");
        docData.put("regions", Arrays.asList("west_coast", "socal"));
        // Add a new document (asynchronously) in collection "cities" with id "LA"
        ApiFuture<WriteResult> future = db.collection("cities").document("LA").set(docData);
        // ...
        // future.get() blocks on response
        System.out.println("HERE ////////////////////");
        System.out.println("Update time : " + future.get().getUpdateTime());
    }
}