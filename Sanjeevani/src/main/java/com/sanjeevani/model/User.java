package com.sanjeevani.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import java.util.List;

import lombok.Getter;
import lombok.Setter;



@Data
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "users")
public class User {

    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private List<String> roles ;




    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUid() {
        return id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return username;
    }
}