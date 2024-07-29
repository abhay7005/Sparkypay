package com.sparkypay.deviceservices.service;

import java.util.List;
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
	public Optional<device> getdeviceById(String _Id) {

		return repository.findById(_Id);
	}

	@Override
	public device postDeviceData(device entity) {
		
		return repository.save(entity);
	}

	@Override
	public List<device> getAllDevice() {
		
		return repository.findAll();
	}

	
	@Override
	public device updateDeviceData(String id, device dev) {
		Optional<device> existingDeviceOpt = repository.findById(id);

	    if (existingDeviceOpt.isPresent()) {
	        device existingDevice = existingDeviceOpt.get();

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
	        Optional<device> deviceOpt = repository.findById(id);

	        if (deviceOpt.isPresent()) {
	            repository.deleteById(id);
	        } else {
	            throw new RuntimeException("Device with ID " + id + " not found");
	        }
	    }

}
