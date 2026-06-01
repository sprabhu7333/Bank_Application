package edu.jsp.BankingApplication.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.BankingApplication.Entity.Loan;
import edu.jsp.BankingApplication.Service.LoanService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoanController {

	private LoanService loanService;
	
	@PostMapping("users/{userId}/loans")
	public Loan applyLoan(@PathVariable Long userId ,@RequestBody Loan loan) {
		return loanService.applyLoan(userId, loan);
	}
	
	@GetMapping("users/{userId}/loans/{loanId}")
	public Loan getLoanById(@PathVariable long userId,@PathVariable long loanId) {
		return loanService.getLoanById(userId, loanId);
	}
	
	@DeleteMapping("users/{userId}/loans/{loanId}")
	public String deleteLoan(@PathVariable long userId,@PathVariable Long loanId) {
		return loanService.deleteLoan(userId, loanId);
	}
	
	@GetMapping("users/{userId}/loans")
	public List<Loan> getLoanByUserId(@PathVariable long userId){
		return loanService.getLoanByUserId(userId);
	}
	
	@PostMapping("users/{userId}/loans/{loanId}/repay/{amount}")
	public String repayLoan(@PathVariable long userId,@PathVariable long loanId,@PathVariable double amount) {
		return loanService.repayLoan(userId, loanId, amount);
	}
	
	@GetMapping("users/{userId}/loans/{loanId}/status")
	public String getLoanStatus(@PathVariable long userId,@PathVariable long loanId) {
		return loanService.getLoanStatus(userId, loanId);
	}
}
