package com.capgemini.capmates.Mappers;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.capgemini.capmates.Entities.Game;
import com.capgemini.capmates.Entities.Player;

@Component
public class GamesMapper {

	public ArrayList<Game> showUserGames(Player playerEntity) {
		ArrayList<Game> userGames = new ArrayList<>();
		userGames.addAll(playerEntity.getPlayerGames());
		return userGames;
	}
}