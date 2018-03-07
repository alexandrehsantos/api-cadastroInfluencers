package br.com.influencers.ws.vo;

public class BankAccountVO {
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((agencyNumber == null) ? 0 : agencyNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idBank == null) ? 0 : idBank.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BankAccountVO))
			return false;
		BankAccountVO other = (BankAccountVO) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (agencyNumber == null) {
			if (other.agencyNumber != null)
				return false;
		} else if (!agencyNumber.equals(other.agencyNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idBank == null) {
			if (other.idBank != null)
				return false;
		} else if (!idBank.equals(other.idBank))
			return false;
		return true;
	}
}
