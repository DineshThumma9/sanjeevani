package com.sanjeevani.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import com.sanjeevani.entity.User;
import com.sanjeevani.service.FireBaseAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;


@RestController
@RequestMapping("/api")
@Slf4j
public class AuthController {

    @Autowired
    FireBaseAuthService firebaseAuthService;

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

    @PostMapping("/create-admin")
    public ResponseEntity<String> createAdmin(@RequestBody User user) {
        try {
            firebaseAuthService.createAdmin(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Admin created successfully.");
        } catch (FirebaseAuthException e) {
            log.error("Error creating admin", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating admin: " + e.getMessage());
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
