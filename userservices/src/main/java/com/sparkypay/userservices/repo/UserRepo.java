package com.sparkypay.userservices.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sparkypay.userservices.entity.User;
@Repository
public interface UserRepo extends MongoRepository<User, Long>{

}
