package com.sanjeevani.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;

@Document(collection = "patients")
@Data
@NoArgsConstructor
public class Patient {


    @Id
    private ObjectId  Id;
    private String name;
    private String phone;
    private Integer age;
    private List<String>  medicalHistory = new ArrayList<>();
    private String bloodGroup;
    private  List<String> otherDetails = new ArrayList<>();


}
