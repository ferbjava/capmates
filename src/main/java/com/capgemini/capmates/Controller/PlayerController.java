package com.capgemini.capmates.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.Service.PlayerProfileServiceImpl;
import com.capgemini.capmates.TO.PlayerProfileTO;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerProfileServiceImpl playerService;
	
	public Collection<Player> getAllPlayers(){
		return playerService.getAllPlayers();
	}
	
	public PlayerProfileTO showPlayerProfile(Integer id){
		return this.playerService.showPlayerProfile(id);
	}
	
}
