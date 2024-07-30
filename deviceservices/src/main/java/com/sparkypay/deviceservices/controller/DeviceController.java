package com.sparkypay.deviceservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparkypay.deviceservices.model.Device;
import com.sparkypay.deviceservices.service.DeviceServices;

@RestController
@RequestMapping("device/")
public class DeviceController {

	@Autowired
	DeviceServices deviceServices;

	@GetMapping("getby/{_Id}")
	public ResponseEntity<Device> getdeviceById(@PathVariable String _Id) {
		Optional<Device> deviceOpt = deviceServices.getdeviceById(_Id);
		return deviceOpt.map(device -> new ResponseEntity<>(device, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("save/")
	public ResponseEntity<Device> postDeviceData(@RequestBody Device device) {
		Device savedDevice = deviceServices.postDeviceData(device);
		return new ResponseEntity<>(savedDevice, HttpStatus.CREATED);
	}

	@PutMapping("updateBy/{_Id}")
	public ResponseEntity<Device> updateDeviceData(@PathVariable String _Id, @RequestBody Device device) {
		try {
			Device updatedDevice = deviceServices.updateDeviceData(_Id, device);
			return new ResponseEntity<>(updatedDevice, HttpStatus.OK);
		} catch (RuntimeException e) {
			// You can define a custom exception for better error handling
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("getAllDevice/")
	public ResponseEntity<List<Device>> getAllDevice() {
		List<Device> devices = deviceServices.getAllDevice();
		return new ResponseEntity<>(devices, HttpStatus.OK);
	}

	@DeleteMapping("delete/{_Id}")
	public ResponseEntity<String> deleteDevice(@PathVariable String _Id) {
		try {
			deviceServices.deleteDevice(_Id);
			return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK); // Successfully deleted
		} catch (RuntimeException e) {
			// Handle custom exception or return a generic not found status
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
