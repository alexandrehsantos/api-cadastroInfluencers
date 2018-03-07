package br.com.influencers.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.influencers.ws.converters.InfluencerConverter;
import br.com.influencers.ws.model.Influencer;
import br.com.influencers.ws.repository.InfluencerRepository;
import br.com.influencers.ws.repository.SocialMediaRepository;
import br.com.influencers.ws.vo.InfluencerVO;

@Service
public class InfluencerService {

	@Autowired
	private InfluencerRepository influencerRepository;

	@Autowired
	private SocialMediaRepository socialMediaRepository;

	@Autowired
	private InfluencerConverter influencerConverter;

	@Autowired
	private BankAccountService bankAccountService;

	public Influencer save(InfluencerVO influencerFilter) {
		return influencerRepository.save(influencerConverter.voToEntity(influencerFilter));

	}

	public List<InfluencerVO> findAll() {

		return influencerConverter.entityToVO(influencerRepository.findAll());
	}

}
