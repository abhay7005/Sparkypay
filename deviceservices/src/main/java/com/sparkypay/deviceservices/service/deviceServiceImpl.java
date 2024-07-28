package com.sparkypay.deviceservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sparkypay.deviceservices.model.device;
import com.sparkypay.deviceservices.repository.deviceRepository;

public class deviceServiceImpl implements deviceServices {

	@Autowired
	deviceRepository repository;

	@Override
	public Optional<device> getdeviceById(String id) {

		return repository.findById(id);
	}

}
