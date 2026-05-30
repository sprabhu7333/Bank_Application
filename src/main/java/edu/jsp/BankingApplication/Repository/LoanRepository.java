package edu.jsp.BankingApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp.BankingApplication.Entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

	@Query("select l form Loan l where l.user.uid = ?1")
	public List<Loan> getLoanByUserId(long userId);
	
}
