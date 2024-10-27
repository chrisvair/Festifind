package edu.depinfo.apiweb.webproject.database;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import edu.depinfo.apiweb.webproject.Festival;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {
    public void addComment(Comment comment) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        Map<String, Object> docData = new HashMap<>();
        docData.put("id", comment.getId());
        docData.put("festivalId", comment.getFestivalId());
        docData.put("content", comment.getContent());
        docData.put("author", comment.getAuthor());
        docData.put("date", comment.getDate());
        ApiFuture<WriteResult> future = db.collection("comments").document(comment.getId()).set(docData);
        System.out.println("Update time : " + future.get().getUpdateTime() + "with comment: " + comment.getContent());
    }

    public Comments getComments(String FestivalId) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();

        // Référence à la collection "comments"
        CollectionReference commentsRef = db.collection("comments");

        // Créer une liste pour stocker les commentaires
        List<Comment> commentsList = new ArrayList<>();

        // Filtrer les commentaires par FestivalId
        Query query = commentsRef.whereEqualTo("festivalId", FestivalId);

        // Exécuter la requête
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        // Parcourir les résultats de la requête
        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            // Convertir le document en objet Comment
            System.out.println(document.getId() + " => " + document.toObject(Comment.class));
            Comment comment = document.toObject(Comment.class);
            // Ajouter le commentaire à la liste
            commentsList.add(comment);
        }

        // Créer un objet Comments à partir de la liste de commentaires
        Comments comments = new Comments();
        comments.setComments(commentsList.toArray(new Comment[0]));

        return comments;
    }

    public void addFestival(FestivalDB festival) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        Map<String, Object> docData = new HashMap<>();
        String festivalId = festival.getNom_du_festival();
        docData.put("nom_du_festival", festival.getNom_du_festival());
        ApiFuture<WriteResult> future = db.collection("festivals").document(festivalId).set(docData);
        System.out.println("Update time : " + future.get().getUpdateTime() + "with festival: " + festivalId);
    }
}
