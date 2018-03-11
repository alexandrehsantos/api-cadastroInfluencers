package br.com.influencers.ws.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.influencers.ws.model.BankAccount;
import br.com.influencers.ws.vo.BankAccountVO;

// TODO: Auto-generated Javadoc
/**
 * The Class BankAccountConverter.
 */
@Service
public class BankAccountConverter {

	/**
	 * Entity to VO.
	 *
	 * @param entity
	 *            the entity
	 * @return the social media VO
	 */
	public BankAccountVO entityToVO(BankAccount entity) {

		BankAccountVO vo = null;

		if (entity != null) {

			vo = new BankAccountVO();

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
	public List<BankAccountVO> entityToVO(List<BankAccount> entityList) {
		List<BankAccountVO> voList = new ArrayList<>();

		if (entityList != null) {

			for (BankAccount entity : entityList) {
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
	public BankAccount voToEntity(BankAccountVO vo) {

		BankAccount entity = null;

		if (vo != null) {

			entity = new BankAccount();

			BeanUtils.copyProperties(vo, entity);

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
	public List<BankAccount> voToEntity(List<BankAccountVO> voList) {
		List<BankAccount> entityList = new ArrayList<>();

		if (voList != null) {

			for (BankAccountVO vo : voList) {
				entityList.add(voToEntity(vo));
			}

		}

		return entityList;

	}

}
