package com.sparkypay.deviceservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkypay.deviceservices.model.Device;
import com.sparkypay.deviceservices.repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements DeviceServices {

	@Autowired
	DeviceRepository repository;

	@Override
	public Optional<Device> getdeviceById(String _Id) {

		return repository.findById(_Id);
	}

	@Override
	public Device postDeviceData(Device entity) {

		return repository.save(entity);
	}

	@Override
	public List<Device> getAllDevice() {

		return repository.findAll();
	}

	@Override
	public Device updateDeviceData(String id, Device dev) {
		Optional<Device> existingDeviceOpt = repository.findById(id);

		if (existingDeviceOpt.isPresent()) {
			Device existingDevice = existingDeviceOpt.get();

			existingDevice.setAppVersion(dev.getAppVersion());
			existingDevice.setDeviceLocation(dev.getDeviceLocation());
			existingDevice.setDeviceType(dev.getDeviceType());
			existingDevice.setOsVersion(dev.getOsVersion());

			return repository.save(existingDevice);
		} else {
			throw new RuntimeException("Device with ID " + id + " not found");
		}
	}

	@Override
	public void deleteDevice(String id) {
		Optional<Device> deviceOpt = repository.findById(id);

		if (deviceOpt.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RuntimeException("Device with ID " + id + " not found");
		}
	}

}
