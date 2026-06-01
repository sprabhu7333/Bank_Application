package edu.jsp.BankingApplication.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.BankingApplication.Entity.Account;
import edu.jsp.BankingApplication.Service.AccountService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AccountController {

	private AccountService accountService;
	
	@GetMapping("/user/{userId}/accounts/{accountId}")
	public Account getAccountById(@PathVariable long userId,@PathVariable long accountId) {
		return accountService.getAccountById(userId, accountId);
	}
	
	@PostMapping("/user/{userId}/accounts")
	public Account createAccount(@PathVariable long userId,@RequestBody Account account) {
		return accountService.createAccount(userId, account);
	}
	
	@DeleteMapping("/user/{userId}/accounts/{accountId}")
	public String deleteAccount(@PathVariable long userId,@PathVariable long accountId) {
		return accountService.deleteAccount(userId, accountId);
	}
	
	@GetMapping("/user/{userId}/accounts")
	public List<Account>getAllAccountByUserId(@PathVariable long userId){
		return accountService.getAllAccountByUserId(userId);
	}
}
