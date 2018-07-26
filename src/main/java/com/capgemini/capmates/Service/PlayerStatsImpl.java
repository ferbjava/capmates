package com.capgemini.capmates.Service;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capmates.DAO.GameLogDao;
import com.capgemini.capmates.Mappers.GameLogMapper;
import com.capgemini.capmates.TO.GameLogTO;

@Service
public class PlayerStatsImpl {

	private GameLogDao gameLogDao;
	private GameLogMapper gameLogMapper;
	
	@Autowired
	public PlayerStatsImpl(GameLogDao gameLogDao, GameLogMapper gameLogMapper) {
		this.gameLogDao = gameLogDao;
		this.gameLogMapper = gameLogMapper;
	}
	
	public void init(){
		gameLogDao.init();
	}
	
	public ArrayList<GameLogTO> showPlayerHistory (long playerId){
		ArrayList<GameLogTO>playerGames=new ArrayList<GameLogTO>();
		for(GameLogTO gameTO:gameLogDao.showPlayerGames(playerId)){
			playerGames.add(gameTO);
		}
		return playerGames;
	}
	
	public ArrayList<GameLogTO> showAllGames (long playerId){
		ArrayList<GameLogTO>playerGames=new ArrayList<GameLogTO>();
		for(GameLogTO game:gameLogDao.showAllGames()){
			playerGames.add(game);
		}
		return playerGames;
	}
	
	public HashSet<Long> showPlayersId(){
		return gameLogDao.playersId();
	}
	
}
