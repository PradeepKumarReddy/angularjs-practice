package com.nakshatraiasacademy.services.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nakshatraiasacademy.services.model.User;

@RestController
public class UserController {
	
	ConcurrentHashMap<Integer, User> userList = new ConcurrentHashMap<Integer, User>();
	static AtomicInteger userId = new AtomicInteger(0);
	
	@PutMapping("/users")
	public User addUser(@Validated @RequestBody User user) {
		int userId = getNextUserId();
		user.setUserId(userId);
		userList.put(userId , user);
		return user;
	}
	
	public int getNextUserId() {
	    return userId.getAndIncrement();
	}
	
	// Get a Single Note
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getNoteById(@PathVariable(value = "userId") Integer userId) {
	    User user = userList.get(userId);
	    if(user == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(user);
	}
	
	// Get All Notes
	@GetMapping("/users")
	public List<User> getAllUsers() {
		// Java 8, Convert all Map values  to a List
		
		//List<User> result4 = userList.values().stream().collect(Collectors.toList());
		Collection<User> list = userList.values();
		List<User> ret = new ArrayList<User>(list);
	    return ret;
	}
	
	private User findUserByUserId(Integer userId) {
		return userList.get(userId);
		/*List<String> result3 = userList.values().stream()
                .filter(x -> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());*/
	}
}
