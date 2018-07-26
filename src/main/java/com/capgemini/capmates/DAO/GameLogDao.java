package com.capgemini.capmates.DAO;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.stereotype.Repository;

import com.capgemini.capmates.Entities.GameLog;
import com.capgemini.capmates.Enums.Result;
import com.capgemini.capmates.Mappers.GameLogMapper;
import com.capgemini.capmates.TO.GameLogTO;

@Repository
public class GameLogDao {

	private ArrayList<GameLog> gameLogList;
	private GameLogMapper gameLogMapper;

	public GameLogDao() {
		gameLogList = new ArrayList<GameLog>();
	}

	public void init() {
		gameLogList.clear();
		gameLogList.add(new GameLog(1, 0, Result.WIN));
		gameLogList.add(new GameLog(2, 0, Result.LOSS));

		gameLogList.add(new GameLog(1, 2, Result.LOSS));
		gameLogList.add(new GameLog(2, 2, Result.LOSS));
		gameLogList.add(new GameLog(3, 2, Result.WIN));

		gameLogList.add(new GameLog(2, 4, Result.WIN));
		gameLogList.add(new GameLog(3, 4, Result.LOSS));

		gameLogList.add(new GameLog(1, 0, Result.LOSS));
		gameLogList.add(new GameLog(2, 0, Result.LOSS));
		gameLogList.add(new GameLog(3, 0, Result.WIN));

		gameLogList.add(new GameLog(1, 1, Result.LOSS));
		gameLogList.add(new GameLog(2, 1, Result.LOSS));
		gameLogList.add(new GameLog(3, 1, Result.WIN));

		gameLogList.add(new GameLog(1, 4, Result.LOSS));
		gameLogList.add(new GameLog(2, 4, Result.WIN));
		
		gameLogList.add(new GameLog(2, 4, Result.DRAW));
		gameLogList.add(new GameLog(3, 4, Result.DRAW));
	}

	public ArrayList<GameLogTO> showPlayerGames(long playerId) {
		ArrayList<GameLogTO> playerGames = new ArrayList<>();
		for (GameLog gameLog : gameLogList) {
			if (playerId == gameLog.getUserId()) {
				playerGames.add(gameLogMapper.entityToTO(gameLog));
			}
		}
		return playerGames;
	}

	public ArrayList<GameLogTO> showAllGames() {
		ArrayList<GameLogTO> allGames = new ArrayList<>();
		for(GameLog game:gameLogList){
			allGames.add(gameLogMapper.entityToTO(game));
		}
		return allGames;
	}
	
	public HashSet<Long> playersId(){
		HashSet<Long> players=new HashSet<Long>();
		for(GameLog gameLog:gameLogList){
			players.add(gameLog.getUserId());
		}
		return players;
	}

}
