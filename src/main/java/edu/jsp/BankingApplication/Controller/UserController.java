package edu.jsp.BankingApplication.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.BankingApplication.Entity.User;
import edu.jsp.BankingApplication.Service.UserService;
import edu.jsp.BankingApplication.exception.NotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

	private UserService service;
	
	@PostMapping
	public User createUser(@Valid @RequestBody User user) {
		return service.createUser(user);
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable long id) {
		return service.getUserById(id);
	}
	
//	public User updateUser(long id) {
//		return service.updateUser(id);
//	}
	
	@DeleteMapping("{id}")
	public String deleteUserById(@PathVariable long id) {
		return service.deleteUserById(id);
	}
	
	@GetMapping("/search")
	public List<User> searchByName(String name){
		return service.searchByName(name);
	}
}
