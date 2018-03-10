package br.com.influencers.ws.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.influencers.ws.model.BankAccount;
import br.com.influencers.ws.model.Influencer;
import br.com.influencers.ws.model.SocialMedia;
import br.com.influencers.ws.repository.SocialMediaRepository;
import br.com.influencers.ws.vo.BankAccountVO;
import br.com.influencers.ws.vo.InfluencerVO;
import br.com.influencers.ws.vo.SocialMediaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class InfluencerConverter.
 */
@Service
public class InfluencerConverter {

	/** The social media repository. */
	@Autowired
	private SocialMediaRepository socialMediaRepository;

	/** The social media converter. */
	@Autowired
	private SocialMediaConverter socialMediaConverter;

	/** The bank account converter. */
	@Autowired
	private BankAccountConverter bankAccountConverter;

	/**
	 * Vo to entity.
	 *
	 * @param vo
	 *            the vo
	 * @return the list
	 */
	public List<Influencer> voToEntity(List<InfluencerVO> vo) {
		List<Influencer> entityList = new ArrayList<>();
		if (vo != null) {
			for (InfluencerVO influencer : vo) {
				entityList.add(voToEntity(influencer));
			}
		}

		return entityList;
	}

	/**
	 * Vo to entity.
	 *
	 * @param vo
	 *            the vo
	 * @return the influencer
	 */
	public Influencer voToEntity(InfluencerVO vo) {
		Influencer entity = null;

		if (vo != null) {

			entity = new Influencer();

			BeanUtils.copyProperties(vo, entity);

		}

		return entity;
	}

	/**
	 * Entity to VO.
	 *
	 * @param influencerEntityList
	 *            the influencer entity list
	 * @return the list
	 */
	public List<InfluencerVO> entityToVO(List<Influencer> influencerEntityList) {
		List<InfluencerVO> influencerVOList = new ArrayList<>();

		for (Influencer influencer : influencerEntityList) {
			InfluencerVO vo = entityToVO(influencer);
			vo.setBankAccounts(this.bankAccountConverter.entityToVO(influencer.getBankAccounts()));
			vo.setSocialMediaList(this.socialMediaConverter.entityToVO(influencer.getSocialMediaList()));

			influencerVOList.add(vo);
		}

		return influencerVOList;
	}

	/**
	 * Entity to VO.
	 *
	 * @param influencer
	 *            the influencer
	 * @return the influencer VO
	 */
	public InfluencerVO entityToVO(Influencer influencer) {

		InfluencerVO influencerVO = null;

		if (influencer != null) {

			influencerVO = new InfluencerVO();

			BeanUtils.copyProperties(influencer, influencerVO);

		}

		return influencerVO;

	}

}
