package br.com.influencers.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.influencers.ws.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{

}
