package br.com.influencers.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.influencers.ws.model.Influencer;
import br.com.influencers.ws.service.InfluencerService;
import br.com.influencers.ws.vo.InfluencerVO;

@RestController
@RequestMapping(value = "/influencer")
public class InfluencerController {

	@Autowired
	private InfluencerService influencerService;

	@PostMapping
	public ResponseEntity<Influencer> registerInfluencer(@RequestBody InfluencerVO filter) {
		return new ResponseEntity<>(influencerService.save(filter), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<InfluencerVO>> getInfluencerBySocialMedia() {
		System.out.println(new InfluencerVO());
		return new ResponseEntity<>(influencerService.findAll(), HttpStatus.OK);

	}

}
