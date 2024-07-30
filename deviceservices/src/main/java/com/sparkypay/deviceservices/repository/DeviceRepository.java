package com.sparkypay.deviceservices.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sparkypay.deviceservices.model.Device;
@Repository
public interface DeviceRepository extends MongoRepository<Device, String>  {

	Optional<Device> findBy(String _Id, String _Id2);

}
