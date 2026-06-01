package edu.jsp.BankingApplication.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;
	
	@NotBlank(message = "name cannot be blank")
	@Size(min = 6,max = 20,message = "name should be within the length")
	private String name;
	
	@Email(message = "Enter proper email")
	private String email;
	
	@Size(min = 6,message = "Minimum password length should be 6")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private Set<Loan> loans;
	
	//adding loan inside user
	public void addLoan(Loan l) {
		loans.add(l);
		l.setUser(this);
	}
	
	//removing loan inside user
	public void removeLoan(Loan l) {
		loans.remove(l);
		l.setUser(null);
	}
}
