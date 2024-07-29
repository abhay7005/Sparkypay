package com.sparkypay.deviceservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkypay.deviceservices.model.device;
import com.sparkypay.deviceservices.repository.deviceRepository;
@Service
public class deviceServiceImpl implements deviceServices {

	@Autowired
	deviceRepository repository;

	@Override
	public Optional<device> getdeviceById(String id) {

		return repository.findById(id);
	}

	@Override
	public device postDeviceData(device entity) {
		
		return repository.save(entity);
	}

}
