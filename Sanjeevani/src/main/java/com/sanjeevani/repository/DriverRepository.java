package com.sanjeevani.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.sanjeevani.model.Driver;




@Repository
public interface DriverRepository extends MongoRepository<Driver,ObjectId> {



}
