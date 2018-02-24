package br.com.influencers.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.influencers.ws.model.SocialMedia;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {
	@Query("select sm.name as sm_name from SocialMedia sm where sm.name in (?1)")
	public List<String> findSocialMediaByName(List<String> name);
}
