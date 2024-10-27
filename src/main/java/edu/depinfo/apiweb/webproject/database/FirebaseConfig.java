package edu.depinfo.apiweb.webproject.database;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream("serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                // The database URL depends on the location of the database
                .setDatabaseUrl("https://festifind-webproject.europe-west1.firebaseddatabase.app")
                .build();

        if (FirebaseApp.getApps().isEmpty()){
            return FirebaseApp.initializeApp(options);
        }
        else{
            return FirebaseApp.getInstance();
        }
    }


/*
    @Bean
    public Firestore firestore() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirestoreOptions firestoreOptions = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        return firestoreOptions.getService();
    }*/
}

