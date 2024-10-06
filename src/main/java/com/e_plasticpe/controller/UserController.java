package com.e_plasticpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_plasticpe.entity.User;
import com.e_plasticpe.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UserController {

	 @Autowired
	    private UserService userService;
	 
	 
	    @GetMapping
	    public List<User> getAllUsers() {
	        return userService.getAllUsers();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
	        User user = userService.getUserById(id);
	        if (user == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(user);
	    }

	    @PostMapping
	    public User createUser(@RequestBody User user) {
	        return userService.createUser(user);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody User userDetails) {
	        User updatedUser = userService.updateUser(id, userDetails);
	        if (updatedUser == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(updatedUser);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id) {
	        userService.deleteUser(id);
	        return ResponseEntity.ok().build();
	    }
}
