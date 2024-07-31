package com.sparkypay.userservices.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkypay.userservices.dto.UserDTO;
import com.sparkypay.userservices.entity.User;
import com.sparkypay.userservices.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	@Autowired
	private ModelMapper mapper;

	public UserService() {

	}

	public UserDTO save(User user) {
		User user2 = repo.save(user);
		UserDTO userDTO = mapper.map(user2, UserDTO.class);
		return userDTO;

	}

	public UserDTO getById(Long id) {
		User user = repo.findById(id).get();
		UserDTO userDTO = mapper.map(user, UserDTO.class);
		return userDTO;

	}

	public List<UserDTO> getAll() {

		List<User> all = repo.findAll();
		List<UserDTO> list = new ArrayList<>();
		for (User user : all) {
			UserDTO userDTO = mapper.map(user, UserDTO.class);
			list.add(userDTO);
		}
		return list;
	}

	public String deletById(Long id) {
		try {
			repo.deleteById(id);
			return "deleted successfully";
		} catch (Exception e) {
			return "not able to delete, something went wrong!!!!";
		}

	}

	public Map<UserDTO, String> updateById(Long id, User user) {
		Map<UserDTO, String> map = new HashMap<>();
		try {
			User user2 = repo.findById(id).get();
			user2.setFirstName(user.getFirstName());
			User user3 = repo.save(user2);
			String message = "updated successfully!!!!!!!";
			UserDTO userDTO = mapper.map(user3, UserDTO.class);
			map.put(userDTO, message);
			return map;
		} catch (Exception e) {
			return map;
		}

	}

}
