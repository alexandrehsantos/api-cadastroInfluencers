package br.com.influencers.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.influencers.filters.InfluencerFilter;
import br.com.influencers.filters.SocialMediaFilter;
import br.com.influencers.ws.model.SocialMedia;
import br.com.influencers.ws.service.InfluencerService;
import br.com.influencers.ws.service.SocialMediaService;

@RestController
public class InfluencerController {

	@Autowired
	private InfluencerService influencerService;

	@Autowired
	private SocialMediaService socialMediaService;

	@RequestMapping(method = RequestMethod.POST, value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InfluencerFilter> registerInfluencer(@RequestBody InfluencerFilter filter) {

		if (filter != null) {
			for (SocialMediaFilter socialMedia : filter.getSocialMedia()) {
			}

		}
		return null;
	}

}
