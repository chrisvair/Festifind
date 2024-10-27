package edu.depinfo.apiweb.webproject.database;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Comments {

    private Comment[] comments;

    public Comments() {
    }

    public Comment[] getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        // Créer un nouveau tableau avec une taille augmentée de 1
        Comment[] newComments = new Comment[comments.length + 1];

        // Copier les commentaires existants dans le nouveau tableau
        System.arraycopy(comments, 0, newComments, 0, comments.length);

        // Ajouter le nouveau commentaire à la fin du nouveau tableau
        newComments[comments.length] = comment;

        // Mettre à jour la référence vers le nouveau tableau
        this.comments = newComments;
    }


    public void setComments(Comment[] array) {
        this.comments = array;
    }

    public Comments getCommentsOf(String FestivalId) throws ExecutionException, InterruptedException {
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
}
