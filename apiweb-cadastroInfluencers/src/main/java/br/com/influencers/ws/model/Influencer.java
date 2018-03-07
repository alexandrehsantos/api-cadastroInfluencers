package br.com.influencers.ws.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Influencer implements Serializable {

	private static final long serialVersionUID = -845996373137414005L;

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String phone;
	private String email;
	private String instagram;
	@ManyToMany 
	private List<SocialMedia> socialNetworks;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<BankAccount> bankAccounts;
	

	public Long getId() {
		return id;
	}

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

	public List<SocialMedia> getSocilNetworks() {
		return socialNetworks;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public void setSocialNetworks(List<SocialMedia> socilNetworks) {
		this.socialNetworks = socilNetworks;
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
		if (!(obj instanceof Influencer))
			return false;
		Influencer other = (Influencer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

}
