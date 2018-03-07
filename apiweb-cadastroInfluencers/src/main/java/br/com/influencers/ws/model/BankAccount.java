package br.com.influencers.ws.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BankAccount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6763464321697378933L;
	@Id
	@GeneratedValue
	private Long id;
	private String idBank;
	private String agencyNumber;
	private String accountNumber;
	
	public Long getId() {
		return id;
	}
	public String getIdBank() {
		return idBank;
	}
	public String getAgencyNumber() {
		return agencyNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setIdBank(String idBank) {
		this.idBank = idBank;
	}
	public void setAgencyNumber(String agencyNumber) {
		this.agencyNumber = agencyNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
		
}
