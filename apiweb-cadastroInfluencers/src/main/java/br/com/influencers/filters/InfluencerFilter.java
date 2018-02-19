package br.com.influencers.filters;

import java.util.List;

public class InfluencerFilter {

	private String name;
	private String phone;
	private String email;
	private String instagram;
	private List<SocialMediaFilter> socialMedia;
	
	
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
	public List<SocialMediaFilter> getSocialMedia() {
		return socialMedia;
	}
	public void setSocialMedia(List<SocialMediaFilter> socialMedia) {
		this.socialMedia = socialMedia;
	}
	
	
	
	
}
