package com.capgemini.capmates.Entities;

public class Game {

	private String gameName;
	private int minPlayers;
	private int maxPlayers;
	
	public Game(String gameName, int minPlayers, int maxPlayers) {
		setGameName(gameName);
		setMinPlayers(minPlayers);
		setMaxPlayers(maxPlayers);
	}

	public String getGameName() {
		return gameName;
	}

	private void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

	private void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameName == null) ? 0 : gameName.hashCode());
		result = prime * result + maxPlayers;
		result = prime * result + minPlayers;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (gameName == null) {
			if (other.gameName != null)
				return false;
		} else if (!gameName.equals(other.gameName))
			return false;
		if (maxPlayers != other.maxPlayers)
			return false;
		if (minPlayers != other.minPlayers)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Game [gameName=" + gameName + ", minPlayers=" + minPlayers + ", maxPlayers=" + maxPlayers + "]";
	}

}
