package com.sanjeevani.repository;

import com.sanjeevani.model.Hospital;
import com.sanjeevani.model.Location;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface HospitalRepository extends MongoRepository<Hospital, ObjectId> {

       void  updateName(ObjectId id, String name);
       void  updateLocation(ObjectId id, Location location);
        void  updateStatus(ObjectId id, String status);
        void   updatePhone(ObjectId id, String phone);
        void  updateAmbulanceCount(ObjectId id, int count);
        void  updateAmbulanceCapacity(ObjectId id, int capacity);



}