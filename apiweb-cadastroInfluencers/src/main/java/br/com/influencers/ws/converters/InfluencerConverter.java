package br.com.influencers.ws.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.influencers.ws.model.Influencer;
import br.com.influencers.ws.model.SocialMedia;
import br.com.influencers.ws.vo.InfluencerVO;
import br.com.influencers.ws.vo.SocialMediaVO;

@Service
public class InfluencerConverter {

	public List<InfluencerVO> entityParaVO(List<Influencer> influencerList) {
		List<InfluencerVO> influencerVoList = null;

		if (influencerList != null) {
			influencerVoList = new ArrayList<>();

			for (Influencer influencer : influencerList) {
				influencerVoList.add(entityParaVO(influencer));

			}

		}
		return influencerVoList;
	}

	public InfluencerVO entityParaVO(Influencer influencer) {

		InfluencerVO influencerVO = null;
		SocialMediaVO socialMediaVO = null;
		List<SocialMediaVO> socialMediaVOList = new ArrayList<>();

		if (influencer != null) {

			influencerVO = new InfluencerVO();

			
			List<SocialMedia> socilNetworks = influencer.getSocilNetworks();
			
			for (SocialMedia socialMediaEntity : socilNetworks) {
				socialMediaVO = new SocialMediaVO();
				BeanUtils.copyProperties(socialMediaEntity, socialMediaVO);
				socialMediaVOList.add(socialMediaVO);
			}

			
			influencerVO.setEmail(influencer.getEmail())
						.setName(influencer.getName())
						.setInstagram(influencer.getInstagram())
						.setPhone(influencer.getPhone())
						.setBankAccounts(influencer.getBankAccounts())
						.setSocialMedia(socialMediaVOList);	

		}

		return influencerVO;

	}

}
