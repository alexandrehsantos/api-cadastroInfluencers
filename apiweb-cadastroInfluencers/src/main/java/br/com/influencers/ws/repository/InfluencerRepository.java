package br.com.influencers.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.influencers.ws.model.Influencer;

public interface InfluencerRepository extends JpaRepository<Influencer, Long>{

}
