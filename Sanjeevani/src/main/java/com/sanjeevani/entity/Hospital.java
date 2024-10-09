package com.sanjeevani.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;


@Data
@NoArgsConstructor
@Document(collection = "hospitals")
public class Hospital {


    @Id
    private ObjectId id;
    private String name;
    private String location;
    private String capacity;
    private String status;
    private String phone;
}
