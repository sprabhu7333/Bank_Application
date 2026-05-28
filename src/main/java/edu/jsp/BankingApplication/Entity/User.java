package edu.jsp.BankingApplication.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "name cannot be blank")
	@Size(min = 6,max = 20,message = "name should be within the length")
	private String name;
	
	@Email(message = "Enter proper email")
	private String email;
	
	@Size(min = 6,message = "Minimum password length should be 6")
	private String password;
}
