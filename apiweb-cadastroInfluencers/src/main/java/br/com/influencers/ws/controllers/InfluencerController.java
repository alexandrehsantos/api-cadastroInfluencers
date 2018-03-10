package br.com.influencers.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.influencers.ws.model.Influencer;
import br.com.influencers.ws.service.InfluencerService;
import br.com.influencers.ws.vo.InfluencerVO;

// TODO: Auto-generated Javadoc
/**
 * The Class InfluencerController.
 */
@RestController
@RequestMapping(value = "/influencer")
public class InfluencerController {

	/** The influencer service. */
	@Autowired
	private InfluencerService influencerService;

	/**
	 * Register influencer.
	 *
	 * @param filter
	 *            the filter
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<Influencer> registerInfluencer(@RequestBody InfluencerVO filter) {
		return new ResponseEntity<>(influencerService.save(filter), HttpStatus.OK);
	}

	/**
	 * Gets the all influencers.
	 *
	 * @return the all influencers
	 */
	@GetMapping
	public ResponseEntity<List<InfluencerVO>> getAllInfluencers() {
		return new ResponseEntity<>(influencerService.findAll(), HttpStatus.OK);

	}

	/**
	 * Gets the influencer byid.
	 *
	 * @param id
	 *            the id
	 * @return the influencer byid
	 */
	@GetMapping("/{id}")
	public ResponseEntity<InfluencerVO> getInfluencerByid(@PathVariable String id) {
		System.out.println(new InfluencerVO());
		InfluencerVO findInfluencerByid = influencerService.findInfluencerByid(Long.valueOf(id));
		
		if(findInfluencerByid == null) {
			return new ResponseEntity<>(findInfluencerByid, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(findInfluencerByid, HttpStatus.OK);

	}

	/**
	 * Alter influecer.
	 *
	 * @param id
	 *            the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	public void alterInfluecer(@PathVariable String id) {
		influencerService.deleteInfluencer(Long.valueOf(id));
	}

}
