package edu.jsp.BankingApplication.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.jsp.BankingApplication.Entity.Account;
import edu.jsp.BankingApplication.Entity.User;
import edu.jsp.BankingApplication.Repository.AccountRepository;
import edu.jsp.BankingApplication.Repository.UserRepository;
import edu.jsp.BankingApplication.exception.NotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService {

	private AccountRepository accountRepository;
	private UserRepository userRepository;

	public Account getAccountById(long userId, long accountId) {
		return accountRepository.findByIdAndUserUid(accountId, userId)
				.orElseThrow(() -> new NotFoundException("User", "userId", userId));
	}
	
	public Account createAccount(long userId, Account account) {
		User u= userRepository.findById(userId).orElseThrow(()->new NotFoundException("user", "userId", userId));
		u.addAccount(account);
		return accountRepository.save(account);
	}
	
	public String deleteAccount(long userId, long accountId) {
		User u=userRepository.findById(userId).orElseThrow(()->new NotFoundException("user", "userId", userId));
		Account a=accountRepository.findById(accountId).orElseThrow(()->new NotFoundException("account", "accountId", accountId));
		u.removeAccount(a);
		accountRepository.delete(a);
		return  "Account deleted";
	}
	
	public List<Account>getAllAccountByUserId(long userId){
		return accountRepository.findByUserUid(userId);
	}
}
