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

@Service
public class InfluencerConverter {

	@Autowired
	private SocialMediaRepository socialMediaRepository;

	public List<Influencer> voToEntity(List<InfluencerVO> vo) {
		List<Influencer> entityList = new ArrayList<>();
		if (vo != null) {
			for (InfluencerVO influencer : vo) {
				entityList.add(voToEntity(influencer));
			}
		}

		return entityList;
	}

	public Influencer voToEntity(InfluencerVO vo) {
		Influencer entity = null;

		if (vo != null) {
			entity = new Influencer();

			entity.setEmail(vo.getEmail());
			entity.setInstagram(vo.getInstagram());
			entity.setName(vo.getName());
			entity.setPhone(vo.getPhone());

			entity.setBankAccounts(bankAccountVoToEntity(vo.getBankAccounts()));
			entity.setSocialNetworks(socialMediaVoToEntity(vo.getSocialMedia()));

		}

		return entity;
	}

	private List<SocialMedia> socialMediaVoToEntity(List<SocialMediaVO> voList) {
		List<SocialMedia> socialNetworksEntityList = new ArrayList<>();

		List<SocialMediaVO> socialMediaFilter = voList;
		for (SocialMediaVO socialMedia : socialMediaFilter) {
			socialNetworksEntityList.add(socialMediaRepository.findOne(socialMedia.getId()));
		}
		return socialNetworksEntityList;
	}

	private List<BankAccount> bankAccountVoToEntity(List<BankAccountVO> voList) {
		List<BankAccount> bankAccountsEntityList = new ArrayList<>();
		BankAccount bankAccount = null;
		if (voList != null) {
			List<BankAccountVO> bankAccounts = voList;
			for (BankAccountVO bankItem : bankAccounts) {
				bankAccount = new BankAccount();
				bankAccount.setAccountNumber(bankItem.getAccountNumber());
				bankAccount.setAgencyNumber(bankItem.getAgencyNumber());
				bankAccount.setIdBank(bankItem.getIdBank());
				bankAccountsEntityList.add(bankAccount);
			}
		}
		return bankAccountsEntityList;
	}

	public List<InfluencerVO> entityToVO(List<Influencer> influencerEntityList) {
		List<InfluencerVO> influencerVOList = new ArrayList<>();

		for (Influencer influencer : influencerEntityList) {
			influencerVOList.add(entityToVO(influencer));
		}

		return influencerVOList;
	}

	public InfluencerVO entityToVO(Influencer influencer) {

		InfluencerVO influencerVO = null;

		if (influencer != null) {

			influencerVO = new InfluencerVO();

			List<SocialMediaVO> socialMediaVOList = convertSocialMediaEntityToVO(influencer.getSocilNetworks());

			List<BankAccountVO> voList = convertBanckAccountEntityToVO(influencer.getBankAccounts());

			influencerVO.setEmail(influencer.getEmail()).setName(influencer.getName())
					.setInstagram(influencer.getInstagram()).setPhone(influencer.getPhone()).setBankAccounts(voList)
					.setSocialMedia(socialMediaVOList);

		}

		return influencerVO;

	}

	private List<BankAccountVO> convertBanckAccountEntityToVO(List<BankAccount> entityList) {
		BankAccountVO bankAccountVO;
		List<BankAccountVO> voList = new ArrayList<>();
		if (entityList != null) {
			for (BankAccount bankAccount : entityList) {
				bankAccountVO = new BankAccountVO();
				BeanUtils.copyProperties(bankAccount, bankAccountVO);
				voList.add(bankAccountVO);
			}
		}
		return voList;
	}

	private List<SocialMediaVO> convertSocialMediaEntityToVO(List<SocialMedia> entityList) {
		SocialMediaVO socialMediaVO;
		List<SocialMediaVO> voList = new ArrayList<>();
		if (entityList != null) {
			for (SocialMedia socialMediaEntity : entityList) {
				socialMediaVO = new SocialMediaVO();
				BeanUtils.copyProperties(socialMediaEntity, socialMediaVO);
				voList.add(socialMediaVO);
			}
		}
		return voList;
	}

}
