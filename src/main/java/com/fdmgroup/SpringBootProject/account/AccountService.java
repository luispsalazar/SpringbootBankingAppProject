package com.fdmgroup.SpringBootProject.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountService {

	private AccountRepository accountRepo;
	private final RestTemplate restTemplate;

	public List<Account> getAccounts() {
		return accountRepo.findAll();
	}

	@Autowired
	public AccountService(AccountRepository accountRepo, RestTemplate restTemplate) {
		super();
		this.accountRepo = accountRepo;
		this.restTemplate = restTemplate;
	}
}