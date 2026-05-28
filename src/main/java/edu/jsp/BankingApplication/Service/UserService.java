package edu.jsp.BankingApplication.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.jsp.BankingApplication.Entity.User;
import edu.jsp.BankingApplication.Repository.UserRepository;
import edu.jsp.BankingApplication.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor

public class UserService {
	
	private UserRepository repo;
	
	public User createUser(User user) {
		return repo.save(user);
	}
	
//	public User updateUser(long id) {
//		return repo.findById(id).orElseThrow()
//	}
	
	public User getUserById(long id) {
		return repo.findById(id)
				.orElseThrow(()-> new NotFoundException("user","id",id));
	}
	
	public String deleteUserById(long id) {
		User u=repo.findById(id)
		.orElseThrow(()-> new NotFoundException("user","id",id));
		repo.delete(u);
		return "Data Deleted";
	}
	
	public List<User> searchByName(String name){
		return repo.findByName(name);
	}
}
