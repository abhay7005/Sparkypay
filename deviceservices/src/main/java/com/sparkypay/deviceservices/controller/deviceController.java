package com.sparkypay.deviceservices.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sparkypay.deviceservices.model.device;
import com.sparkypay.deviceservices.service.deviceServiceImpl;
import com.sparkypay.deviceservices.service.deviceServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("device/")
public class deviceController {

	@Autowired
	deviceServices deviceServices;

	@GetMapping("getby/{id}")
	public Optional<device> getdeviceById(@RequestParam String id) {
		return deviceServices.getdeviceById(id);
	}

	@PostMapping("save/")
	public device postDeviceData(@RequestBody device entity) {

		
		 
		 return  deviceServices.postDeviceData(entity);
	}
//
//	@PutMapping("updateBy/{id}")
//	public String updateDeviceData(@PathVariable String id, @RequestBody String entity) {
//		// TODO: process PUT request
//
//		return entity;
//	}
//
//	@GetMapping("getAllDevice")
//	public String getAllDevice(@RequestParam String param) {
//		return new String();
//	}

}
