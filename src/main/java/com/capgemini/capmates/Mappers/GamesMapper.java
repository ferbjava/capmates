package com.capgemini.capmates.Mappers;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.capgemini.capmates.Entities.Game;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.TO.GameTO;

@Component
public class GamesMapper {

	public GameTO entityToTO(Game game) {
		return new GameTO(game.getId(), game.getGameName(), game.getMinPlayers(), game.getMaxPlayers());
	}

	public Game toToEntity(GameTO gameTO) {
		return new Game(gameTO.getGameId(), gameTO.getGameName(), gameTO.getMinPlayers(), gameTO.getMaxPlayers());
	}

	public ArrayList<GameTO> entityToGameTOList(Player playerEntity) {
		ArrayList<GameTO> gameTOlist = new ArrayList<GameTO>();
		for (Game game : playerEntity.getPlayerGames()) {
			gameTOlist.add(entityToTO(game));
		}
		return gameTOlist;
	}
}
