package com.sanjeevani.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;



@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initFirebase() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("C:\\Users\\dines\\Downloads\\sanjeevani-108e1-firebase-adminsdk-ib94s-0dbf81aaa7.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
    }
}

