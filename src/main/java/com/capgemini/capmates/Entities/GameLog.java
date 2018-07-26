package com.capgemini.capmates.Entities;

import com.capgemini.capmates.Enums.Result;

public class GameLog {
	private long userId;
	private long gameId;
	private Result result;

	public GameLog(long userId, long gameId, Result result) {
		setGameId(gameId);
		setUserId(userId);
		setResult(result);
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
