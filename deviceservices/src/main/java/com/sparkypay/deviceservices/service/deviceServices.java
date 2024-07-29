package com.sparkypay.deviceservices.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sparkypay.deviceservices.model.device;


public interface deviceServices {

	Optional<device> getdeviceById(String id);

	device postDeviceData(device entity);

}
