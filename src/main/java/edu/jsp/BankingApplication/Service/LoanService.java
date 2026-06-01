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
	
	public Loan getLoanById(long userId, long loanId) {
		
		return loanRepository.findByUserUidAndId(userId,loanId)
				.orElseThrow(()->new NotFoundException("Loan", "Id", loanId));
	}
	
	@Transactional
	public String deleteLoan(long userId,Long loanId) {
		Loan l=loanRepository.findByUserUidAndId(userId,loanId)
				.orElseThrow(()->new NotFoundException("Loan", "Id", loanId));
		
		loanRepository.delete(l);
		
		return "Data Deleted";
		
	}
	
	public List<Loan> getLoanByUserId(long userId){
		
		return loanRepository.getLoanByUserId(userId);
	}
	
	//repay loan and updating inside the dataBase
	public String repayLoan(long userId, long loanId,double amount) {
		Loan l= loanRepository.findByUserUidAndId(userId,loanId)
				.orElseThrow(()-> new NotFoundException("Loan", "id", loanId));
		l.setBalance(l.getBalance()-amount);
		
		if(l.getBalance()<=0) {
			l.setStatus("repaid");
		}
		loanRepository.save(l);
		return "Loan amount paid";
	}
	
	//getting loan status
	public String getLoanStatus(long userId,long loanId) {
		Loan l= loanRepository.findByUserUidAndId(userId,loanId)
				.orElseThrow(()-> new NotFoundException("Loan", "id", loanId));
		return l.getStatus();
	}
}
