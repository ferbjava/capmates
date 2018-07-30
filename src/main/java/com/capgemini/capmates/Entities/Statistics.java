package com.capgemini.capmates.Entities;

import com.capgemini.capmates.Enums.PlayerRank;

public class Statistics {

	private long playerId;
	private long winGames;
	private long lostGames;
	private long drawGames;
	private long placeRanking;
	private PlayerRank playerRank;

	public Statistics(long playerId, long winGames, long lostGames, long drawGames, long placeRanking,
			PlayerRank playerRank) {
		setPlayerId(playerId);
		setWinGames(winGames);
		setLostGames(lostGames);
		setDrawGames(drawGames);
		setPlaceRanking(placeRanking);
		setPlayerRank(playerRank);
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

	public PlayerRank getPlayerRank() {
		return playerRank;
	}

	public void setPlayerRank(PlayerRank playerRank) {
		this.playerRank = playerRank;
	}
}
