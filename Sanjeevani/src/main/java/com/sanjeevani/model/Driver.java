package com.sanjeevani.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;




    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Document(collection = "drivers")
    public class Driver {

        @Id
        private String id;
        private String name;
        private String phoneNumber;
        private Boolean available;
        private List<String> ambulanceIds;
    }
