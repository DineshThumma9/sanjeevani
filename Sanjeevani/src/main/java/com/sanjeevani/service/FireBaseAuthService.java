package com.sanjeevani.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import com.sanjeevani.entity.User;
import com.sanjeevani.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class FireBaseAuthService {

    @Autowired
    private UserRepository userRepository;

    public UserRecord createUser(User user) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setPhoneNumber(user.getPhoneNumber());

        user.setRoles(Arrays.asList("user"));
        userRepository.save(user);
        return FirebaseAuth.getInstance().createUser(request);
    }

    public void createAdmin(User user) throws FirebaseAuthException {
        // Add admin role to the existing roles
        user.getRoles().add("admin");
        userRepository.save(user); // Ensure user is updated in MongoDB

        // Create a request to update the user's roles
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(user.getUid());
        Optional.ofNullable(user.getEmail()).ifPresent(request::setEmail);
        Optional.ofNullable(user.getName()).ifPresent(request::setDisplayName);
        Optional.ofNullable(user.getPhoneNumber()).ifPresent(request::setPhoneNumber);

        // Update user in Firebase
        FirebaseAuth.getInstance().updateUser(request);
    }

    public UserRecord getUserByUid(String uid) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().getUser(uid);
    }

    public void deleteUser(String uid) throws FirebaseAuthException {
        FirebaseAuth.getInstance().deleteUser(uid);
    }

    public UserRecord updateUser(User user) throws FirebaseAuthException {
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(user.getId());
        Optional.ofNullable(user.getEmail()).ifPresent(request::setEmail);
        Optional.ofNullable(user.getName()).ifPresent(request::setDisplayName);
        Optional.ofNullable(user.getPhoneNumber()).ifPresent(request::setPhoneNumber);
        return FirebaseAuth.getInstance().updateUser(request);
    }

    public FirebaseToken loginWithEmailAndPassword(User user) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().verifyIdToken(user.getEmail());
    }

    public FirebaseToken verifyToken(String token) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().verifyIdToken(token);
    }
}
