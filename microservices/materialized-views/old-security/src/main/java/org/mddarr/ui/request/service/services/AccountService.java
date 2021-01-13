package org.mddarr.ui.request.service.services;


import org.mddarr.ui.request.service.models.Account;

public interface AccountService {
	
	public Account loadAccount(Long accountId);
	
	public Long createAccount(Account account);	
}