package com.capgemini.capmates.Service;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capmates.DAO.GamesDao;
import com.capgemini.capmates.DAO.PlayerDao;
import com.capgemini.capmates.Entities.Game;
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

	public ArrayList<Game> showPlayerGames(Integer playerId) {
		Player playerEntity = playerDao.getPlayerById(playerId);
		return gamesMapper.showUserGames(playerEntity);
	}

	public void addGameToUserCollection(Integer playerId, GameTO newGame) {
		String gameName = newGame.getGameName();
		int minPlayers = newGame.getMinPlayers();
		int maxPlayers = newGame.getMaxPlayers();
		Game recentGame = gamesDao.getOrAddGame(gameName, minPlayers, maxPlayers);
		playerDao.addPlayerGame(playerId, recentGame);
	}

	public HashSet<Game> showGamesInRepo() {
		HashSet<Game> gamesInRepo = new HashSet<>();
		gamesInRepo.addAll(gamesDao.showGamesInRepo());
		return gamesInRepo;
	}

	public void removePlayerGame(Integer playerId, Game gameToRemove) {
		Player playerEntity = playerDao.getPlayerById(playerId);
		ArrayList<Game> userGames = gamesMapper.showUserGames(playerEntity);
		for (Game testGame : userGames) {
			if (gameToRemove.equals(testGame)) {
				playerDao.removePlayerGame(playerId, gameToRemove);
			}
		}
	}

}
