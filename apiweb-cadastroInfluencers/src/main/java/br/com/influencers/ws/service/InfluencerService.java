package br.com.influencers.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.influencers.filters.InfluencerFilter;
import br.com.influencers.filters.SocialMediaFilter;
import br.com.influencers.ws.model.Influencer;
import br.com.influencers.ws.model.SocialMedia;
import br.com.influencers.ws.repository.InfluencerRepository;
import br.com.influencers.ws.repository.SocialMediaRepository;

@Service
public class InfluencerService {

	@Autowired
	private InfluencerRepository influencerRepository;

	@Autowired
	private SocialMediaRepository socialMediaRepository;

	public Influencer save(InfluencerFilter influencerFilter) {

		Influencer influencer = new Influencer();
		List<SocialMedia> socialNetworksEntityList = new ArrayList<>();

		influencer.setEmail(influencerFilter.getEmail());
		influencer.setInstagram(influencerFilter.getInstagram());
		influencer.setName(influencerFilter.getName());
		influencer.setPhone(influencerFilter.getPhone());

		List<SocialMediaFilter> socialMediaFilter = influencerFilter.getSocialMedia();
		for (SocialMediaFilter socialMedia : socialMediaFilter) {
			socialNetworksEntityList.add(socialMediaRepository.findOne(socialMedia.getId()));
		}

		influencer.setSocialNetworks(socialNetworksEntityList);

		return influencerRepository.save(influencer);

	}

}
