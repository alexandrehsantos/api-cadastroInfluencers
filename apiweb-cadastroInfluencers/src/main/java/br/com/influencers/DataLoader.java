package br.com.influencers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.influencers.ws.model.SocialMedia;
import br.com.influencers.ws.repository.SocialMediaRepository;

@Component
public class DataLoader implements ApplicationRunner {

	private SocialMediaRepository socialMediaRepository;

	@Autowired
	public DataLoader(SocialMediaRepository socialMediaRepository) {
		this.socialMediaRepository = socialMediaRepository;

	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {

		SocialMedia socialMedia = null;

		List<SocialMedia> socialMediaToInsert = new ArrayList<>();

		List<String> socialMediaNames = new ArrayList<>();
		socialMediaNames.add("Facebook");
		socialMediaNames.add("Twiter");
		socialMediaNames.add("LinkedIn");
		socialMediaNames.add("Instagram");
		socialMediaNames.add("YouTube");

		
		List<String> findSocialMediaByName = socialMediaRepository.findSocialMediaByName(socialMediaNames);

		if (findSocialMediaByName != null) {
			for (String name : socialMediaNames) {
				if (!findSocialMediaByName.contains(name)) {
					socialMedia = new SocialMedia();
					socialMedia.setName(name);
					socialMediaToInsert.add(socialMedia);
				}
			}
		}

		if (socialMediaToInsert != null && !socialMediaToInsert.isEmpty()) {
			socialMediaRepository.save(socialMediaToInsert);
		}

	}

}
