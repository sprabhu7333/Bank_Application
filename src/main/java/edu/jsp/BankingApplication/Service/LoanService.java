package edu.jsp.BankingApplication.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.jsp.BankingApplication.Entity.Loan;
import edu.jsp.BankingApplication.Entity.User;
import edu.jsp.BankingApplication.Repository.LoanRepository;
import edu.jsp.BankingApplication.Repository.UserRepository;
import edu.jsp.BankingApplication.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanService {

	private LoanRepository loanRepository;
	
	private UserRepository userRepository;
	
	@Transactional
	public Loan applyLoan(Long userId ,Loan loan) {
		User u= userRepository.findById(userId)
				.orElseThrow(()-> new NotFoundException("User","Id",userId));
		u.addLoan(loan);
		return loanRepository.save(loan);
	}
	
	public Loan getLoanById(long loanId) {
		return loanRepository.findById(loanId)
				.orElseThrow(()->new NotFoundException("Loan", "Id", loanId));
	}
	
	@Transactional
	public String deleteLoan(long userId,Long loanId) {
		User u= userRepository.findById(userId)
				.orElseThrow(()-> new NotFoundException("User","Id",userId));
		
		Loan l=loanRepository.findById(loanId)
				.orElseThrow(()->new NotFoundException("Loan", "Id", loanId));
		
		u.removeLoan(l);
		
		loanRepository.delete(l);
		
		return "Data Deleted";
		
	}
	
	public List<Loan> getLoanByUserId(long userId){
		
		return loanRepository.getLoanByUserId(userId);
	}
}
