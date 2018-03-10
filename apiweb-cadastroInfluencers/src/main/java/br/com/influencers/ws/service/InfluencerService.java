package br.com.influencers.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.influencers.ws.converters.BankAccountConverter;
import br.com.influencers.ws.converters.InfluencerConverter;
import br.com.influencers.ws.converters.SocialMediaConverter;
import br.com.influencers.ws.model.BankAccount;
import br.com.influencers.ws.model.Influencer;
import br.com.influencers.ws.model.SocialMedia;
import br.com.influencers.ws.repository.InfluencerRepository;
import br.com.influencers.ws.repository.SocialMediaRepository;
import br.com.influencers.ws.vo.BankAccountVO;
import br.com.influencers.ws.vo.InfluencerVO;
import br.com.influencers.ws.vo.SocialMediaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class InfluencerService.
 */
@Service
public class InfluencerService {

	/** The influencer repository. */
	@Autowired
	private InfluencerRepository influencerRepository;

	/** The social media repository. */
	@Autowired
	private SocialMediaRepository socialMediaRepository;

	/** The influencer converter. */
	@Autowired
	private InfluencerConverter influencerConverter;

	/** The bank account service. */
	@Autowired
	private BankAccountService bankAccountService;

	/** The social media converter. */
	@Autowired
	private SocialMediaConverter socialMediaConverter;

	/** The bank account converter. */
	@Autowired
	private BankAccountConverter bankAccountConverter;

	/**
	 * Save.
	 *
	 * @param influencerFilter
	 *            the influencer filter
	 * @return the influencer
	 */
	public Influencer save(InfluencerVO influencerFilter) {

		Influencer influencerEntity = influencerConverter.voToEntity(influencerFilter);

		List<SocialMedia> socialMediaEntityList = new ArrayList<>();

		for (SocialMediaVO socialMediaVO : influencerFilter.getSocialMediaList()) {
			socialMediaEntityList.add(socialMediaRepository.findOne(socialMediaVO.getId()));
		}

		List<BankAccount> bankAccountEntityList = bankAccountConverter.voToEntity(influencerFilter.getBankAccounts());

		influencerEntity.setBankAccounts(bankAccountEntityList);

		influencerEntity.setSocialMediaList(socialMediaEntityList);

		return influencerRepository.save(influencerEntity);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<InfluencerVO> findAll() {
		List<Influencer> influencerList = influencerRepository.findAll();
		return influencerConverter.entityToVO(influencerList);
	}

	/**
	 * Find influencer byid.
	 *
	 * @param id
	 *            the id
	 * @return the influencer VO
	 */
	public InfluencerVO findInfluencerByid(Long id) {

		return influencerConverter.entityToVO(influencerRepository.findOne(id));
	}

	/**
	 * Delete influencer.
	 *
	 * @param id
	 *            the id
	 */
	public void deleteInfluencer(Long id) {
		influencerRepository.delete(id);
	}
}
