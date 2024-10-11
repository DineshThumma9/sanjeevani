package com.sanjeevani.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.sanjeevani.model.User;
import com.sanjeevani.service.FirebaseAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/api")
public class AuthController {


    private static final Logger log = LoggerFactory.getLogger(AuthController.class);



    @Autowired
    FirebaseAuthService firebaseAuthService;

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            UserRecord userRecord = firebaseAuthService.createUser(user);
            log.info("User created: {}", userRecord.getUid());
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
        } catch (FirebaseAuthException e) {
            log.error("Error creating user", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating user: " + e.getMessage());
        }
    }


//    // src/main/java/com/sanjeevani/controller/AuthController.java
//  //  @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody User user) {
//        try {
//
//            // Verify the ID token
//            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
//
//            // Retrieve the user information using the UID from the decoded token
//            UserRecord userRecord = FirebaseAuth.getInstance().getUser(decodedToken.getUid());
//            log.info("User logged in successfully: {}", userRecord.getEmail());
//            return ResponseEntity.ok("User logged in successfully.");
//        } catch (FirebaseAuthException e) {
//            log.error("Error while logging in", e);
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong email or password.");
//        }
//    }




    @GetMapping("/get-user/{uid}")
    public ResponseEntity<UserRecord> getUser(@PathVariable String uid) {
        try {
            UserRecord userRecord = firebaseAuthService.getUserByUid(uid);
            return ResponseEntity.ok(userRecord);
        } catch (FirebaseAuthException e) {
            log.error("Error retrieving user", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete-user/{uid}")
    public ResponseEntity<String> deleteUser(@PathVariable String uid) {
        try {
            firebaseAuthService.deleteUser(uid);
            return ResponseEntity.ok("User deleted successfully.");
        } catch (FirebaseAuthException e) {
            log.error("Error deleting user", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting user: " + e.getMessage());
        }
    }
}
