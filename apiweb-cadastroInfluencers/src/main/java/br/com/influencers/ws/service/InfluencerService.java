package br.com.influencers.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.influencers.ws.repository.InfluencerRepository;

@Service
public class InfluencerService {

	@Autowired
	private InfluencerRepository influencerRepository;

}
