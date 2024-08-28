package com.e_plasticpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_plasticpe.entity.User;
import com.e_plasticpe.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User userDetails) {
		User user = userRepository.findById(id).orElse(null);
		if (user != null) {
			user.setName(userDetails.getName());
			user.setEmail(userDetails.getEmail());
			user.setAddress(userDetails.getAddress());
			user.setLandmark(userDetails.getLandmark());
			user.setPincode(userDetails.getPincode());
			user.setPhone(userDetails.getPhone());
			user.setStatus(userDetails.getStatus());
			user.setRole(userDetails.getRole());
			return userRepository.save(user);
		}
		return null;
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
