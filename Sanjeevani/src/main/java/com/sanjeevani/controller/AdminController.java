package com.sanjeevani.controller;
import com.google.firebase.auth.FirebaseAuthException;
import com.sanjeevani.model.Ambulance;
import com.sanjeevani.model.Hospital;
import com.sanjeevani.model.User;
import com.sanjeevani.service.FirebaseAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.sanjeevani.service.AmbulanceService;
import com.sanjeevani.service.HospitalService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private FirebaseAuthService firebaseAuthService;
    @Autowired
    private AmbulanceService ambulanceService;
    @Autowired
    private HospitalService hospitalService;


    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers()
    {
        List<User> all_users = firebaseAuthService.getAll();

        if(all_users == null || all_users.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No users found");
        }

       return ResponseEntity.status(HttpStatus.OK).body(all_users);
    }


    @GetMapping("/all-ambulance")
    public ResponseEntity<?> getAllAmbu()
    {
        List<Ambulance> all_ambu = ambulanceService.getAmbulance();
        if(all_ambu == null || all_ambu.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No ambulances found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(all_ambu);
    }


    @GetMapping("/all-hospitals")
    public ResponseEntity<?> getAllHospitals()
    {
        List<Hospital> all_hospitals = hospitalService.getAll();
        if(all_hospitals == null || all_hospitals.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hospitals found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(all_hospitals);
    }

    @PostMapping("/create-admin")
    public ResponseEntity<String> createAdmin(@RequestBody User user) {
        try {
            firebaseAuthService.createAdmin(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Admin created successfully.");
        } catch (FirebaseAuthException e) {
            log.error("Error creating admin", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating admin: " + e.getMessage());
        }
    }

    @PostMapping("/create-driver")
    public ResponseEntity<String> createDriver(@RequestBody User user) {
        try {
            firebaseAuthService.createDriver(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Driver created successfully.");
        } catch (FirebaseAuthException e) {
            log.error("Error creating driver", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating driver: " + e.getMessage());
        }
    }



    @PostMapping("/create-hospital")
    public ResponseEntity<String> createHospital(@RequestBody Hospital hospital) {
        try
        {
            hospitalService.create(hospital);
            return ResponseEntity.status(HttpStatus.CREATED).body("Hospital created successfully.");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hospital creation failed");
        }
    }




}
