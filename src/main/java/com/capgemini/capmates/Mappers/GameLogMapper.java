package com.capgemini.capmates.Mappers;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.capgemini.capmates.Entities.GameLog;
import com.capgemini.capmates.Enums.Result;
import com.capgemini.capmates.TO.GameLogTO;

@Component
public class GameLogMapper {

	public GameLogTO entityToTO(GameLog gameLog) {
		long playerId=gameLog.getUserId();
		long gameId=gameLog.getGameId();
		Result result=gameLog.getResult();
		GameLogTO gameLogTo=new GameLogTO(playerId, gameId, result);
		return gameLogTo;
	}

	public GameLog toToEntity(GameLogTO gameLogTo) {

		return new GameLog(gameLogTo.getUserId(), gameLogTo.getGameId(), gameLogTo.getResult());
	}

	public ArrayList<GameLogTO> entityListToToList(ArrayList<GameLog> gameLogList) {
		ArrayList<GameLogTO> gameLogToList = new ArrayList<GameLogTO>();
		for (GameLog gameLog : gameLogList) {
			gameLogToList.add(entityToTO(gameLog));
		}
		return gameLogToList;
	}

}
