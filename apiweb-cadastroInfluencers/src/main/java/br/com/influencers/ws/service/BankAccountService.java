package br.com.influencers.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.influencers.ws.model.BankAccount;
import br.com.influencers.ws.repository.BankAccountRepository;

@Service
public class BankAccountService {
	@Autowired
	private BankAccountRepository bankAccountRepository;

	
	
	public BankAccount findById(Long id) {
		return bankAccountRepository.findOne(id);
	}
	
}


