package com.sanjeevani.service;

import com.sanjeevani.dtos.PatientRegistrationDTO;
import com.sanjeevani.dtos.PatientUpdateDTO;
import com.sanjeevani.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Service;
import com.sanjeevani.model.Patient;
import org.bson.types.ObjectId;
import java.util.List;
import com.sanjeevani.model.Location;


@Service
public class PatientService {


    @Autowired
    private PatientRepository patientRepository;


    public List<Patient>  getAll(){
        return patientRepository.findAll();
    }

    public ResponseEntity<String> registerPatient(@RequestBody PatientRegistrationDTO patientRegistrationDTO) {
        if (patientRegistrationDTO.getName() == null || patientRegistrationDTO.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Name is required.");
        }
        if (patientRegistrationDTO.getAge() == null || patientRegistrationDTO.getAge() <= 0) {
            return ResponseEntity.badRequest().body("Valid age is required.");
        }
        if (patientRegistrationDTO.getAccidentDetails() == null || patientRegistrationDTO.getAccidentDetails().isEmpty()) {
            return ResponseEntity.badRequest().body("Accident details are required.");
        }
        if (patientRegistrationDTO.getLocation() == null) {
            return ResponseEntity.badRequest().body("Location is required.");
        }


        return ResponseEntity.ok("Ambulance booked successfully. You can fill in additional details later.");
    }



    public Patient updatePatient(ObjectId id, PatientUpdateDTO dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        if (dto.getName() != null) patient.setName(dto.getName());
        if (dto.getAge() != 0) patient.setAge(dto.getAge());
        if (dto.getMedicalHistory() != null) patient.setMedicalHistory(dto.getMedicalHistory());
        if (dto.getPhoneNumber() != null) patient.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getAddress() != null) patient.setAddress(dto.getAddress());

        return patientRepository.save(patient);
    }


     public void create(Patient patient) {
         patientRepository.save(patient);
     }


     public void delete(ObjectId id) {
         patientRepository.deleteById(id);
     }


        public Patient getById(ObjectId id) {
            return patientRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        }

        public void updateLocation(ObjectId id, Location location) {
            Patient patient = patientRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
            patient.setLocation(location);
            patientRepository.save(patient);
        }

        public void updateStatus(ObjectId id, String status) {
            Patient patient = patientRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
            patient.setStatus(status);
            patientRepository.save(patient);
        }




}
