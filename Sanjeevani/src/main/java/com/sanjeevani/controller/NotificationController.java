package com.sanjeevani.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sanjeevani.service.FirebaseCloudMessageService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/fcm")
public class NotificationController {

    @Autowired
    private FirebaseCloudMessageService fcmService;

    @PostMapping("/send")
    public String sendNotification(@RequestParam String token,
                                   @RequestParam String title,
                                   @RequestParam String body) {
        fcmService.sendNotification(token, title, body);
        return "Notification sent!";
    }
}
