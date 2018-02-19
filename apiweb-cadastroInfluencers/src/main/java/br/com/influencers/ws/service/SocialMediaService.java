package br.com.influencers.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.influencers.ws.repository.SocialMediaRepository;

@Service
public class SocialMediaService {
	@Autowired
	private SocialMediaRepository socialMediaRepository;

	
}
