package com.sanjeevani.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "patients")
@Data
@NoArgsConstructor
public class Patient {


        @Id
       private ObjectId  Id;


        private String name;
        private Integer age;
        private  List<String> medicalHistory = new ArrayList<>();
        private String phoneNumber;et
        private String address;
        private String emergencyDescription;
        private Location location;
        private LocalDateTime registrationDate;
        private String status;
        private String criticalLevel;



    public Patient(ObjectId id, String name, Integer age, List<String> medicalHistory, String phoneNumber, String address, String emergencyDetails,Location location, LocalDateTime registrationDate, String status, String criticalLevel) {
        Id = id;
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.emergencyDescription = emergencyDescription;
        this.location = location;
        this.registrationDate = registrationDate;
        this.status = status;
        this.criticalLevel = criticalLevel;
    }


 public ObjectId getId() {
  return Id;
 }

 public void setId(ObjectId id) {
  Id = id;
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

 public String getPhoneNumber() {
  return phoneNumber;
 }

 public void setPhoneNumber(String phoneNumber) {
  this.phoneNumber = phoneNumber;
 }

 public String getAddress() {
  return address;
 }

 public void setAddress(String address) {
  this.address = address;
 }

 public String getEmergencyDescription() {
  return emergencyDescription;
 }

 public void setEmergencyDescription(String emergencyDetails) {
  this.emergencyDescription = emergencyDescription;
 }

 public Location getLocation() {
  return location;
 }

 public void setLocation(Location location) {
  this.location = location;
 }

 public LocalDateTime getRegistrationDate() {
  return registrationDate;
 }

 public void setRegistrationDate(LocalDateTime registrationDate) {
  this.registrationDate = registrationDate;
 }

 public String getStatus() {
  return status;
 }

 public void setStatus(String status) {
  this.status = status;
 }

 public String getCriticalLevel() {
  return criticalLevel;
 }

 public void setCriticalLevel(String criticalLevel) {
  this.criticalLevel = criticalLevel;
 }
}
