package com.nakshatraiasacademy.services.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.nakshatraiasacademy.repository.UserRepository;
import com.nakshatraiasacademy.services.model.User;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
	
	    @Autowired
	    UserRepository userRepository;

	    @GetMapping("/users")
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    @GetMapping("/users/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
	        User note = userRepository.findOne(userId);
	        if(note == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(note);
	    }

	    @PostMapping("/users")
	    public User createUser(@Valid @RequestBody User user) {
	    	System.out.println("createUser");
	        return userRepository.save(user);
	    }

	    @PutMapping("/users/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
	                                           @Valid @RequestBody User userDetails) {
	        User note = userRepository.findOne(userId);
	        if(note == null) {
	            return ResponseEntity.notFound().build();
	        }
	        /*note.setTitle(noteDetails.getTitle());
	        note.setContent(noteDetails.getContent());*/

	        User updatedUser = userRepository.save(note);
	        return ResponseEntity.ok(updatedUser);
	    }

	    @DeleteMapping("/users/{id}")
	    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long userId) {
	        User note = userRepository.findOne(userId);
	        if(note == null) {
	            return ResponseEntity.notFound().build();
	        }

	        userRepository.delete(note);
	        return ResponseEntity.ok().build();
	    }
	
	
	
	
	
	
	
	
	
	
	/*ConcurrentHashMap<Long, User> userList = new ConcurrentHashMap<Long, User>();
	static AtomicInteger userId = new AtomicInteger(0);
	
	@PutMapping("/users")
	@CrossOrigin
	public User addUser(@Validated @RequestBody User user) {
		long userId = getNextUserId();
		user.setUserId(userId);
		userList.put(userId , user);
		return user;
	}
	
	public int getNextUserId() {
	    return userId.getAndIncrement();
	}
	
	// Get a Single User
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "userId") Integer userId) {
	    User user = userList.get(userId);
	    if(user == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(user);
	}
	
	// Get All Users
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
		List<String> result3 = userList.values().stream()
                .filter(x -> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());
	}
*/
	







}
