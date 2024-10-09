package com.sanjeevani.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;


@Document(collection = "ambulances")
@Data
@NoArgsConstructor
public class Ambulance {

    @Id
    private ObjectId  id;
    private ObjectId hospitalId;
    private String status;
    private String location;
    private String driverName;
    private String driverPhone;

}
