package com.nakshatraiasacademy.services.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nakshatraiasacademy.repository.UserRepository;
import com.nakshatraiasacademy.services.model.User;

@RestController
@RequestMapping("/api/authenticate")
@CrossOrigin
public class AuthenticationController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public @ResponseBody ResponseEntity<User> login(@Valid @RequestBody User user) {
		System.out.println("login");
		String message = "Failure";
		if (user.getUserName() == null || user.getPassword() == null) {
			return ResponseEntity.badRequest().build();
		}
		
		List<User> users = userRepository.findByUserName(user.getUserName());
		if (CollectionUtils.isEmpty(users)) {
			return ResponseEntity.notFound().build();
			//return ResponseEntity.ok().body(message);
		}

		User loginUser = users.get(0);
		
		if (user.getUserName().equals(loginUser.getUserName())
				&& user.getPassword().equals(loginUser.getPassword())) {
			message = "Success";
		} else {
			message = "Failure";
		}

		return ResponseEntity.ok().body(loginUser);
	}


	/*@GetMapping("/login")
	public ResponseEntity<String> login(@RequestParam("userName") String userName, 
            @RequestParam("password") String password) {
		String message = "Failure";
		if (userName == null || password == null) {
			return ResponseEntity.badRequest().build();
		}
		
		List<User> users = userRepository.findByUserName(userName);
		if (CollectionUtils.isEmpty(users)) {
			//return ResponseEntity.notFound().build();
			return ResponseEntity.ok().body(message);
		}

		User loginUser = users.get(0);
		
		if (userName.equals(loginUser.getUserName())
				&& password.equals(loginUser.getPassword())) {
			message = "Success";
		} else {
			message = "Failure";
		}

		return ResponseEntity.ok().body(message);
	}
*/
}
