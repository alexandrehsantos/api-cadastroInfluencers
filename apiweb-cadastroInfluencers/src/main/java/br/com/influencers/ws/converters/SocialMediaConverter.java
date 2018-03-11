package br.com.influencers.ws.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.influencers.ws.model.SocialMedia;
import br.com.influencers.ws.vo.SocialMediaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SocialMediaConverter.
 */

@Service
public class SocialMediaConverter {

	/**
	 * Entity to VO.
	 *
	 * @param entity
	 *            the entity
	 * @return the social media VO
	 */
	public SocialMediaVO entityToVO(SocialMedia entity) {

		SocialMediaVO vo = null;

		if (entity != null) {

			vo = new SocialMediaVO();

			BeanUtils.copyProperties(entity, vo);

		}

		return vo;

	}

	/**
	 * Entity to VO.
	 *
	 * @param entityList
	 *            the entity list
	 * @return the list
	 */
	public List<SocialMediaVO> entityToVO(List<SocialMedia> entityList) {
		List<SocialMediaVO> voList = new ArrayList<>();

		if (entityList != null) {

			for (SocialMedia entity : entityList) {
				voList.add(entityToVO(entity));
			}

		}

		return voList;

	}

	/**
	 * Entity to VO.
	 *
	 * @param vo
	 *            the vo
	 * @return the social media
	 */
	public SocialMedia voToEntity(SocialMediaVO vo) {

		SocialMedia entity = null;

		if (vo != null) {

			entity = new SocialMedia();

			BeanUtils.copyProperties(entity, vo);

		}

		return entity;

	}

	/**
	 * Vo to entity.
	 *
	 * @param voList
	 *            the vo list
	 * @return the list
	 */
	public List<SocialMedia> voToEntity(List<SocialMediaVO> voList) {
		List<SocialMedia> entityList = new ArrayList<>();

		if (voList != null) {

			for (SocialMediaVO vo : voList) {
				entityList.add(voToEntity(vo));
			}

		}

		return entityList;

	}

}
