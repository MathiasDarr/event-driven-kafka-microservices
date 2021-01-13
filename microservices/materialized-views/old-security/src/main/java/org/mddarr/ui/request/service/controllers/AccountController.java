package org.mddarr.ui.request.service.controllers;


import org.mddarr.ui.request.service.exception.AccountNotFoundException;
import org.mddarr.ui.request.service.exception.InvalidAccountRequestException;
import org.mddarr.ui.request.service.models.Account;
import org.mddarr.ui.request.service.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {

	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@RequestMapping(value = { "/api/account" }, method = { RequestMethod.POST })
	public Account createAccount(@RequestBody Account account,
								 HttpServletResponse httpResponse,
								 WebRequest request) {

		Long accountId = accountService.createAccount(account);
		account.setAccountId(accountId);
		
		httpResponse.setStatus(HttpStatus.CREATED.value());
		httpResponse.setHeader("Location", String.format("%s/api/account/%s", 
										request.getContextPath(), accountId));		
		return account;
	}
	
	@RequestMapping(value = "/api/account/{accountId}", method = RequestMethod.GET)
	public Account getAccount(@PathVariable("accountId") Long accountId) {
		
		/* validate account Id parameter */
		if (accountId < 9999) {
			throw new InvalidAccountRequestException();
		}
		
		Account account = accountService.loadAccount(accountId);
		if(null==account){			
			throw new AccountNotFoundException();
		}
		
		return account;
	}
	
}