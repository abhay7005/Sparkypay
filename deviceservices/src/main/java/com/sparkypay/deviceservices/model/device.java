package com.sparkypay.deviceservices.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "DeviceInfo")
public class device {
	@Id
	String deviceId;
	String deviceType;
	String osVersion;
	String appVersion;
	String deviceLocation;
	
	
	

}
