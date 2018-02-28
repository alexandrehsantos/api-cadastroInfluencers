package br.com.influencers.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.influencers.ws.controllers.InfluencerController;
import br.com.influencers.ws.converters.InfluencerConverter;
import br.com.influencers.ws.model.Influencer;
import br.com.influencers.ws.model.SocialMedia;
import br.com.influencers.ws.repository.InfluencerRepository;
import br.com.influencers.ws.repository.SocialMediaRepository;
import br.com.influencers.ws.vo.InfluencerVO;
import br.com.influencers.ws.vo.SocialMediaVO;

@Service
public class InfluencerService {

	@Autowired
	private InfluencerRepository influencerRepository;

	@Autowired
	private SocialMediaRepository socialMediaRepository;

	@Autowired
	private InfluencerConverter influencerConverter;

	public Influencer save(InfluencerVO influencerFilter) {

		Influencer influencer = new Influencer();
		List<SocialMedia> socialNetworksEntityList = new ArrayList<>();

		influencer.setEmail(influencerFilter.getEmail());
		influencer.setInstagram(influencerFilter.getInstagram());
		influencer.setName(influencerFilter.getName());
		influencer.setPhone(influencerFilter.getPhone());

		List<SocialMediaVO> socialMediaFilter = influencerFilter.getSocialMedia();
		for (SocialMediaVO socialMedia : socialMediaFilter) {
			socialNetworksEntityList.add(socialMediaRepository.findOne(socialMedia.getId()));
		}

		influencer.setSocialNetworks(socialNetworksEntityList);

		return influencerRepository.save(influencer);

	}

	public List<InfluencerVO> findAll() {

		return influencerConverter.entityParaVO(influencerRepository.findAll());
	}

}
