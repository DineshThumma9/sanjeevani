package com.sanjeevani.repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.sanjeevani.entity.User;





public interface UserRepository  extends MongoRepository<User , ObjectId> {

}
