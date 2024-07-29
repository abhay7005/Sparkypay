package com.sparkypay.deviceservices.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sparkypay.deviceservices.model.device;
@Repository
public interface deviceRepository extends MongoRepository<device, String>  {

	Optional<device> findBy(String _Id, String _Id2);

}
