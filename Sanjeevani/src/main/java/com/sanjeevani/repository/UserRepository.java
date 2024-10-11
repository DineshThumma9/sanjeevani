package com.sanjeevani.repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.sanjeevani.model.User;





@Repository
public interface UserRepository  extends MongoRepository<User , ObjectId> {



}

