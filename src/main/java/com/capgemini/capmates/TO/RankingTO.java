package com.capgemini.capmates.TO;

import java.util.Comparator;

public class RankingTO{
	private Long points;
	private long playerId;

	public RankingTO(long points, long playerId) {
		setPoints(points);
		setPlayerId(playerId);
	}

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
	
	public static class PointsComparator implements Comparator<RankingTO>{
		@Override
		public int compare(RankingTO r1, RankingTO r2) {
			Long r1Points=-r1.getPoints();
			Long r2Points=-r2.getPoints();
			return r1Points.compareTo(r2Points);
		}
	}

}
