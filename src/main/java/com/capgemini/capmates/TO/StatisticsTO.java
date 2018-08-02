package com.capgemini.capmates.TO;

import com.capgemini.capmates.Enums.Level;

public class StatisticsTO {

	private long playerId;
	private long winGames;
	private long lostGames;
	private long drawGames;
	private long placeRanking;
	private Level playerLevel;

	public StatisticsTO() {
	}

	public StatisticsTO(long playerId, long winGames, long lostGames, long drawGames, long placeRanking,
			Level playerLevel) {
		setPlayerId(playerId);
		setWinGames(winGames);
		setLostGames(lostGames);
		setDrawGames(drawGames);
		setPlaceRanking(placeRanking);
		setPlayerLevel(playerLevel);
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

	public Level getPlayerLevel() {
		return playerLevel;
	}

	public void setPlayerLevel(Level playerLevel) {
		this.playerLevel = playerLevel;
	}
}
