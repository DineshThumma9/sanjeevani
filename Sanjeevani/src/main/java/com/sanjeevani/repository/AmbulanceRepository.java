package com.sanjeevani.repository;

import com.sanjeevani.model.Ambulance;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.sanjeevani.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface AmbulanceRepository extends MongoRepository<Ambulance , ObjectId> {

     void  updateName(ObjectId id, String name);
     void  updateLocation(ObjectId id, Location location);
     void  updateStatus(ObjectId id, String status);


     List<Ambulance> findByLocationNear(Location location);

     @Query("{ 'status' : 'available' }")
     List<Ambulance> findAvailableAmbulances();






}
