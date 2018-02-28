package br.com.influencers.ws.vo;

import java.util.List;

import br.com.influencers.ws.model.BankAccount;

public class InfluencerVO {

	private String name;
	private String phone;
	private String email;
	private String instagram;
	private List<SocialMediaVO> socialMedia;
	private List<BankAccount> bankAccounts;

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

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public InfluencerVO setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
		return this;
	}

}
