package com.sanjeevani.dtos;


import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import  com.sanjeevani.model.Location;




@Data
@NoArgsConstructor
public class PatientRegistrationDTO {

    private String name;
    private Integer age;
    private List<String> medicalHistory = new ArrayList<>();
    private String accidentDetails;
    private Location location;




    public PatientRegistrationDTO(String name, Integer age, List<String> medicalHistory, String accidentDetails, Location location) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.accidentDetails = accidentDetails;
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAccidentDetails() {
        return accidentDetails;
    }

    public void setAccidentDetails(String accidentDetails) {
        this.accidentDetails = accidentDetails;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
