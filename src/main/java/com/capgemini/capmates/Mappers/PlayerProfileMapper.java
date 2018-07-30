package com.capgemini.capmates.Mappers;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.capgemini.capmates.Entities.Game;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.TO.PlayerProfileTO;

@Component
public class PlayerProfileMapper {

	public PlayerProfileTO entityToTO(Player playerEntity) {
		int id = playerEntity.getId();
		String firstName = playerEntity.getFirstName();
		String lastName = playerEntity.getLastName();
		String email = playerEntity.getEmail();
		String password = playerEntity.getPassword();
		String motto = playerEntity.getLifeMotto();
		return new PlayerProfileTO(id, firstName, lastName, email, password, motto);
	}

	public Player toToEntity(PlayerProfileTO profileTO, ArrayList<Game> games) {
		int id = profileTO.getId();
		String firstName = profileTO.getFirstName();
		String lastName = profileTO.getLastName();
		String email = profileTO.getEmail();
		String password = profileTO.getPassword();
		String lifeMotto = profileTO.getLifeMotto();
		Player entity = new Player(id, firstName, lastName, email, password, lifeMotto, games);
		return entity;
	}

}
