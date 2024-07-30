package com.sparkypay.deviceservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sparkypay.deviceservices.model.Device;


public interface DeviceServices {

	Optional<Device> getdeviceById(String _Id);

	Device postDeviceData(Device entity);

	List<Device> getAllDevice();

	Device updateDeviceData(String id, Device dev);

	void deleteDevice(String _Id);

}
