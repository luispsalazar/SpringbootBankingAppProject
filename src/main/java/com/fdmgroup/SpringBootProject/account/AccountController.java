package com.fdmgroup.SpringBootProject.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

	AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@GetMapping
	public ResponseEntity<List<Account>> getAccounts() {
		List<Account> accounts = accountService.getAccounts();
		return ResponseEntity.ok(accounts);
	}
}