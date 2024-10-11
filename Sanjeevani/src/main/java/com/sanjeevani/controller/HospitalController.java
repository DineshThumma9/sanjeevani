package com.sanjeevani.controller;

import com.sanjeevani.model.Hospital;
import com.sanjeevani.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.bson.types.ObjectId;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Hospital hospital) {
        try {
            hospitalService.create(hospital);
            return new ResponseEntity<>("Hospital created successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Hospital creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<Hospital> getAll() {
        return hospitalService.getAll();
    }
//
//    @PutMapping
//    public ResponseEntity<String> update(@RequestParam String id, @RequestBody Hospital hospital) {
//        try {
//            hospitalService.update(hospital);
//            return new ResponseEntity<>("Hospital updated successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Hospital updation failed", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam ObjectId id) {
        try {
            hospitalService.delete(id);
            return new ResponseEntity<>("Hospital deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Hospital deletion failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}