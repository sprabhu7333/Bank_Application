package edu.jsp.BankingApplication.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amount;
	private LocalDateTime applyDate;
	private LocalDateTime approvalDate;
	private LocalDateTime disbursementDate;
	private double balance;
	private String status;
	
	@ManyToOne
	@JoinColumn
	private User user;
}
