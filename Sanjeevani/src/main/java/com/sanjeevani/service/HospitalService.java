package com.sanjeevani.service;

import com.sanjeevani.model.Location;
import com.sanjeevani.repository.HospitalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sanjeevani.model.Hospital;
import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;


    public void create(Hospital hospital) {
        hospitalRepository.save(hospital);
    }


    public void delete(ObjectId id) {
        hospitalRepository.deleteById(id);
    }

    public void updateName(ObjectId id, String name) {
        hospitalRepository.updateName( id , name);
    }

    public void updateLocation(ObjectId id, Location location) {
        hospitalRepository.updateLocation(id , location);
    }

    public void updateStatus(ObjectId id, String status) {
        hospitalRepository.updateStatus(id, status);
    }

    public void updatePhone(ObjectId id, String phone) {
        hospitalRepository.updatePhone(id, phone);
    }

    public void updateAmbulanceCount(ObjectId id, int count) {
        hospitalRepository.updateAmbulanceCount(id, count);
    }

    public void updateAmbulanceCapacity(ObjectId id, int capacity) {
        hospitalRepository.updateAmbulanceCapacity(id, capacity);
    }


    public List<Hospital> getAll() {
        return hospitalRepository.findAll();
    }



}