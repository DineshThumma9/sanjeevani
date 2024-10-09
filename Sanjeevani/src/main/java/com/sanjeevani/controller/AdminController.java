package com.sanjeevani.controller;



import com.sanjeevani.entity.Ambulance;
import com.sanjeevani.entity.Hospital;
import com.sanjeevani.entity.User;
import com.sanjeevani.service.AmbulanceService;
import com.sanjeevani.service.HospitalService;
import com.sanjeevani.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public class AdminController {


    @Autowired
    private UserService userService;



    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers()
    {
        List<User> all_users = userService.getAll();

        if(all_users == null || all_users.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No users found");
        }

       return ResponseEntity.status(HttpStatus.OK).body(all_users);
    }


    @GetMapping("/all-ambulance")
    public ResponseEntity<?> getAllAmbu()
    {
        List<Ambulance> all_ambu = ambulanceService.getAll();
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






}
