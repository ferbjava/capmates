package com.capgemini.capmates.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.capmates.Exceptions.ProfileExceptions;
import com.capgemini.capmates.Service.PlayerProfileServiceImpl;
import com.capgemini.capmates.TO.PlayerProfileTO;

@Controller
@ResponseBody
public class PlayerController {

	@Autowired
	private PlayerProfileServiceImpl playerProfileService;

	@RequestMapping(value = "/profile/all", method = RequestMethod.GET)
	public ArrayList<PlayerProfileTO> showAllPlayersProfiles() {
		return playerProfileService.showAllPlayersProfiles();
	}

	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public PlayerProfileTO showPlayerProfile(@PathVariable("id") int id) {
		if(id>=0&&id<=playerProfileService.showPlayersNumber()){
			return playerProfileService.showPlayerProfile(id);
		}else{
			throw new ProfileExceptions("Moj komunikat"+id);
//			throw new IllegalArgumentException("Your profile id: "+id);
		}
//		return playerProfileService.showPlayerProfile(id);
	}

	@RequestMapping(value = "profile/edit", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void editPlayerProfile(@RequestBody PlayerProfileTO udpatedProfile) {
		playerProfileService.editPlayerProfile(udpatedProfile);
	}
	
	@RequestMapping(value = "profile/filter", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<PlayerProfileTO> filterPlayersProfiles(@RequestBody PlayerProfileTO filter) {
		List<PlayerProfileTO> filteredProfiles = new ArrayList<PlayerProfileTO>();
		filteredProfiles = playerProfileService.showFilteredProfiles(filter);
		return filteredProfiles;
	}

}
