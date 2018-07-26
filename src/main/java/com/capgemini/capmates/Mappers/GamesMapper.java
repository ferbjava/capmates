package com.capgemini.capmates.Mappers;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.capgemini.capmates.Entities.Game;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.TO.GameTO;

@Component
public class GamesMapper {

	public ArrayList<Game> showUserGames(Player playerEntity) {
		ArrayList<Game> userGames = new ArrayList<>();
		userGames.addAll(playerEntity.getPlayerGames());
		return userGames;
	}

	public GameTO entityToTO(Game game) {
		return new GameTO(game.getGameName(), game.getMinPlayers(), game.getMaxPlayers());
	}

	public ArrayList<GameTO> entityToGameTOList(Player playerEntity) {
		ArrayList<GameTO> gameTOlist = new ArrayList<GameTO>();
		for (Game game : playerEntity.getPlayerGames()) {
			gameTOlist.add(entityToTO(game));
		}
		return gameTOlist;
	}
}
