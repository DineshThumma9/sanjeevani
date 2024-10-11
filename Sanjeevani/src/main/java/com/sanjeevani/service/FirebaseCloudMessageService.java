package com.sanjeevani.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import org.springframework.stereotype.Service;




@Service
public class FirebaseCloudMessageService {
    public void sendNotification(String token, String title, String body) {
        Message message = Message.builder()
                .putData("title", title)
                .putData("body", body)
                .setToken(token)  // Device token from frontend
                .build();

        try {
            // Send the message via Firebase
            String response = FirebaseMessaging.getInstance().send(message);
            System.out.println("Successfully sent message: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
