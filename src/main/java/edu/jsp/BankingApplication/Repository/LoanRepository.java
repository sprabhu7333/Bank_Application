package edu.jsp.BankingApplication.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp.BankingApplication.Entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

	@Query("select l from Loan l where l.user.uid = ?1")
	public List<Loan> getLoanByUserId(long userId);
	
	public Optional<Loan> findByUserUidAndId(long userId,long loanId);
	
}
