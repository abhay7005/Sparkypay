package com.sparkypay.deviceservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sparkypay.deviceservices.model.device;
@Repository
public interface deviceRepository extends MongoRepository<device, String>  {

}
