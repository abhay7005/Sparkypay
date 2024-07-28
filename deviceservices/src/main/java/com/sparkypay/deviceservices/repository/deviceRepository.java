package com.sparkypay.deviceservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sparkypay.deviceservices.model.device;

public interface deviceRepository extends MongoRepository<device, String>  {

}
