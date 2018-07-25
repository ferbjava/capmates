package com.capgemini.capmates.Service;

import java.util.Collection;

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
		this.playerDao=playerDao;
		this.gamesDao=gamesDao;
		this.gamesMapper=gamesMapper;
	}
	
	public Collection<Game> showPlayerGames(Integer id){
		Player playerEntity=playerDao.getPlayerById(id);
		return gamesMapper.showUserGames(playerEntity);
	}
	
	public void addGameToCollection(Integer id, GameTO newGame){
		if(!gamesDao.contain(gamesMapper.getGame(newGame))){
			gamesDao.addGameToCollection(gamesMapper.getGame(newGame));
		}
		playerDao.addPlayerGame(id, gamesMapper.getGame(newGame));	
	}
	
}
