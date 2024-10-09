package com.sanjeevani.repository;

import com.sanjeevani.entity.Patient;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;




public interface PatientRepository extends MongoRepository<Patient,ObjectId> {


}
