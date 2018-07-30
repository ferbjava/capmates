package com.capgemini.capmates.Entities;

public class RankPosition {
	private long points;
	private long playerId;

	public RankPosition(long points, long playerId) {
		setPoints(points);
		setPlayerId(playerId);
	}

	public long getPoints() {
		return points;
	}

	public void setPoints(long points) {
		this.points = points;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

}
