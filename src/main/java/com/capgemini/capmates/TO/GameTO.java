package com.capgemini.capmates.TO;

public class GameTO {
	private long gameId;
	private String gameName;
	private int minPlayers;
	private int maxPlayers;

	public GameTO(long gameId, String gameName, int minPlayers, int maxPlayers) {
		setGameId(gameId);
		setGameName(gameName);
		setMinPlayers(minPlayers);
		setMaxPlayers(maxPlayers);
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

}
