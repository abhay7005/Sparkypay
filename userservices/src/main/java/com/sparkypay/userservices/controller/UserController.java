package com.sparkypay.userservices.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparkypay.userservices.dto.UserDTO;
import com.sparkypay.userservices.entity.User;
import com.sparkypay.userservices.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/save")
	public ResponseEntity<UserDTO> save(@RequestBody User user) {
		UserDTO userDTO = service.save(user);
		return ResponseEntity.of(Optional.of(userDTO));
	}

	@GetMapping("getById/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable("id") Long id) {
		UserDTO userDTO = service.getById(id);
		return ResponseEntity.of(Optional.of(userDTO));
	}

	@GetMapping("getAll")
	public ResponseEntity<List<UserDTO>> getAll() {
		List<UserDTO> userDTO = service.getAll();
		return ResponseEntity.of(Optional.of(userDTO));
	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<String> deletById(@PathVariable("id") Long id) {
		String message = service.deletById(id);
		return ResponseEntity.of(Optional.of(message));
	}

	@PutMapping("updateById/{id}")
	public ResponseEntity<Map<UserDTO, String>> updateById(@PathVariable("id") Long id, @RequestBody User user) {

		Map<UserDTO, String> map = service.updateById(id, user);

		return ResponseEntity.ok(map);
	}

}
