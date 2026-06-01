package edu.jsp.BankingApplication.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.BankingApplication.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	
	Optional<Account> findByIdAndUserUid(long accountId,long userId);
	
	List<Account>findByUserUid(long userId);
}
