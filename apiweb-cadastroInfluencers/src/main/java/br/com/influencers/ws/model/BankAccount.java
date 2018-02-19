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
	private Long idBank;
	private Long agencyNumber;
	private Long accountNumber;
	
	public Long getId() {
		return id;
	}
	public Long getIdBank() {
		return idBank;
	}
	public Long getAgencyNumber() {
		return agencyNumber;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setIdBank(Long idBank) {
		this.idBank = idBank;
	}
	public void setAgencyNumber(Long agencyNumber) {
		this.agencyNumber = agencyNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BankAccount))
			return false;
		BankAccount other = (BankAccount) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
