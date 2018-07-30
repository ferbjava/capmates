package com.capgemini.capmates.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.capmates.Service.PlayerProfileServiceImpl;
import com.capgemini.capmates.TO.PlayerProfileTO;

@Controller
@ResponseBody
// @RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerProfileServiceImpl playerProfileService;

	@RequestMapping(value = "/profile/all", method = RequestMethod.GET)
	public ArrayList<PlayerProfileTO> showAllPlayersProfiles() {
		return playerProfileService.showAllPlayersProfiles();
	}

	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public PlayerProfileTO showPlayerProfile(@PathVariable("id") int id) {
		playerProfileService.initDao();
		return playerProfileService.showPlayerProfile(id);
	}

	@RequestMapping(value = "profile/edit", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void editPlayerProfile(@RequestBody PlayerProfileTO udpatedProfile) {
		playerProfileService.editPlayerProfile(udpatedProfile);
	}

}
