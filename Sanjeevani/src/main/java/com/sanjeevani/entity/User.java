package com.sanjeevani.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;
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

    // Add getter methods if not using Lombok's @Data
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