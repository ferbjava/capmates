package com.capgemini.capmates.Mappers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.capgemini.capmates.Entities.Game;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.TO.GameTO;

@Component
public class GamesMapper {

	public Collection<Game> showUserGames(Player playerEntity) {
		Collection<Game> userGames = new ArrayList<>();
		userGames.addAll(playerEntity.getPlayerGames());
		return userGames;
	}

	public Game getGame(GameTO newGame) {
		String gameName = newGame.getGameName();
		int minPlayers = newGame.getMinPlayers();
		int maxPlayers = newGame.getMaxPlayers();
		Game game = new Game(gameName, minPlayers, maxPlayers);
		return game;
	}
}
