package br.com.influencers.ws.vo;

import java.util.List;

public class InfluencerVO {

	private Long id;
	private String name;
	private String phone;
	private String email;
	private String instagram;
	private List<SocialMediaVO> socialMedia;
	private List<BankAccountVO> bankAccounts;

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getInstagram() {
		return instagram;
	}

	public InfluencerVO setName(String name) {
		this.name = name;
		return this;
	}

	public InfluencerVO setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public InfluencerVO setEmail(String email) {
		this.email = email;
		return this;
	}

	public InfluencerVO setInstagram(String instagram) {
		this.instagram = instagram;
		return this;
	}

	public List<SocialMediaVO> getSocialMedia() {
		return socialMedia;

	}

	public InfluencerVO setSocialMedia(List<SocialMediaVO> socialMedia) {
		this.socialMedia = socialMedia;
		return this;
	}

	public List<BankAccountVO> getBankAccounts() {
		return bankAccounts;
	}

	public InfluencerVO setBankAccounts(List<BankAccountVO> bankAccounts) {
		this.bankAccounts = bankAccounts;
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof InfluencerVO))
			return false;
		InfluencerVO other = (InfluencerVO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}

}
