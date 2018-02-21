package br.com.influencers.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.influencers.filters.InfluencerFilter;
import br.com.influencers.ws.model.Influencer;
import br.com.influencers.ws.service.InfluencerService;

@RestController
public class InfluencerController {

	@Autowired
	private InfluencerService influencerService;

	@RequestMapping(method = RequestMethod.POST, value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Influencer> registerInfluencer(@RequestBody InfluencerFilter filter) {

		return new ResponseEntity<>(influencerService.save(filter), HttpStatus.OK);
	}

}
