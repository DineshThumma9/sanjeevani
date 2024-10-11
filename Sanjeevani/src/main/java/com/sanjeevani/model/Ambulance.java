package com.sanjeevani.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ambulances")
public class Ambulance {

    @Id
    private String id;
    private String type;
    private Boolean available;
    private String currentDriverId;
    private Location location;
    @DBRef
    private Driver driver;
}
