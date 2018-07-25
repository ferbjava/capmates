package com.capgemini.capmates.Mappers;

import org.springframework.stereotype.Component;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.TO.PlayerProfileTO;

@Component
public class PlayerProfileMapper {

	public PlayerProfileTO showPlayerProfile(Player playerEntity) {
		int id = playerEntity.getId();
		String firstName = playerEntity.getFirstName();
		String lastName = playerEntity.getLastName();
		String email = playerEntity.getEmail();
		String password = playerEntity.getPassword();
		String motto = playerEntity.getLifeMotto();
		return new PlayerProfileTO(id, firstName, lastName, email, password, motto);
	}

	public String getPlayerFirstName(Player playerEntity) {
		return playerEntity.getFirstName();
	}

	public String getPlayerLastName(Player playerEntity) {
		return playerEntity.getLastName();
	}

	public String getPlayerEmail(Player playerEntity) {
		return playerEntity.getEmail();
	}

	public String getPlayerPassword(Player playerEntity) {
		return playerEntity.getPassword();
	}

	public String getPlayerMotto(Player playerEntity) {
		return playerEntity.getLifeMotto();
	}

	public void setPlayerFirstName(Player playerEntity, String firstName) {
		playerEntity.setFirstName(firstName);
	}

	public void setPlayerLastName(Player playerEntity, String lastName) {
		playerEntity.setLastName(lastName);
	}

	public void setPlayerEmail(Player playerEntity, String email) {
		playerEntity.setEmail(email);
	}

	public void setPlayerPassword(Player playerEntity, String password) {
		playerEntity.setPassword(password);
	}

	public void setPlayerLifeMotto(Player playerEntity, String lifeMotto) {
		playerEntity.setLifeMotto(lifeMotto);
	}

}
