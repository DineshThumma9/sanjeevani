package com.sanjeevani.dtos;


import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
public class PatientUpdateDTO {


    private String name;
    private Integer age;
    private List<String> medicalHistory = new ArrayList<>();
    private String phoneNumber;
    private String address;



    public PatientUpdateDTO(String name,Integer age, List<String> medicalHistory, String phoneNumber, String address) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
