package com.capgemini.capmates.TO;

public class GameTO {
	private String gameName;
	private int minPlayers;
	private int maxPlayers;
	
	
	
	public GameTO(String gameName, int minPlayers, int maxPlayers) {
		setGameName(gameName);
		setMinPlayers(minPlayers);
		setMaxPlayers(maxPlayers);
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
