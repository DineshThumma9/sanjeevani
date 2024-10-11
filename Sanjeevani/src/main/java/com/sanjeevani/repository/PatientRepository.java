package com.sanjeevani.repository;

import com.sanjeevani.model.Patient;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;




@Repository
public interface PatientRepository extends MongoRepository<Patient,ObjectId> {


}
