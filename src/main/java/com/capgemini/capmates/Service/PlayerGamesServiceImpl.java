package com.capgemini.capmates.Service;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capmates.DAO.GamesDao;
import com.capgemini.capmates.DAO.PlayerDao;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.Mappers.GamesMapper;
import com.capgemini.capmates.TO.GameTO;

@Service
public class PlayerGamesServiceImpl {
	private PlayerDao playerDao;
	private GamesDao gamesDao;
	private GamesMapper gamesMapper;

	@Autowired
	public PlayerGamesServiceImpl(PlayerDao playerDao, GamesDao gamesDao, GamesMapper gamesMapper) {
		this.playerDao = playerDao;
		this.gamesDao = gamesDao;
		this.gamesMapper = gamesMapper;
	}

	public void initDao() {
		gamesDao.init();
	}

	public ArrayList<GameTO> showPlayerGames(Integer playerId) {
		Player playerEntity = playerDao.getPlayerById(playerId);
		return gamesMapper.plEntityToGameTOList(playerEntity);
	}

	public void addGameToUserCollection(Integer playerId, GameTO newGameTO) {
		GameTO recentGame = gamesDao.getOrAddGame(newGameTO);
		playerDao.addPlayerGame(playerId, recentGame);
	}

	public HashSet<GameTO> showGamesInRepo() {
		HashSet<GameTO> gamesInRepo = new HashSet<GameTO>();
		gamesInRepo.addAll(gamesDao.showGamesInRepo());
		return gamesInRepo;
	}

	public void removePlayerGame(Integer playerId, GameTO gameToRemove) {
		playerDao.removePlayerGame(playerId, gameToRemove);
	}

}
