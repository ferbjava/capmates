package com.capgemini.capmates.Entities;

public class Statistics {

	private long playerId;
	private long winGames;
	private long lostGames;
	private long drawGames;
	private long placeRanking;

	public Statistics(long playerId, long winGames, long lostGames, long drawGames, long placeRanking) {
		super();
		this.playerId = playerId;
		this.winGames = winGames;
		this.lostGames = lostGames;
		this.drawGames = drawGames;
		this.placeRanking = placeRanking;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public long getWinGames() {
		return winGames;
	}

	public void setWinGames(long winGames) {
		this.winGames = winGames;
	}

	public long getLostGames() {
		return lostGames;
	}

	public void setLostGames(long lostGames) {
		this.lostGames = lostGames;
	}

	public long getDrawGames() {
		return drawGames;
	}

	public void setDrawGames(long drawGames) {
		this.drawGames = drawGames;
	}

	public long getPlaceRanking() {
		return placeRanking;
	}

	public void setPlaceRanking(long placeRanking) {
		this.placeRanking = placeRanking;
	}
}
