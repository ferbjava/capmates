package com.capgemini.capmates.Mappers;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.capgemini.capmates.Entities.GameLog;
import com.capgemini.capmates.TO.GameLogTO;

@Component
public class GameLogMapper {

	public GameLogTO entityToTO(GameLog gameLog) {
		return new GameLogTO(gameLog.getUserId(), gameLog.getGameId(), gameLog.getResult());
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
