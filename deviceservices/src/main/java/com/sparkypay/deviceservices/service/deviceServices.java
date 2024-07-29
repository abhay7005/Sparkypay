package com.sparkypay.deviceservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sparkypay.deviceservices.model.device;


public interface deviceServices {

	Optional<device> getdeviceById(String _Id);

	device postDeviceData(device entity);

	List<device> getAllDevice();

	device updateDeviceData(String id, device dev);

	void deleteDevice(String _Id);

}
