package com.capgemini.capmates.TO;

import java.util.Comparator;

public class RankPositionTO{// implements Comparable<RankPositionTO> {
	private Long points;
	private long playerId;

	public RankPositionTO(long points, long playerId) {
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
	
	public static class PointsComparator implements Comparator<RankPositionTO>{
		@Override
		public int compare(RankPositionTO r1, RankPositionTO r2) {
			Long r1Points=-r1.getPoints();
			return r1Points.compareTo(-r2.getPoints());
		}
	}

//	@Override
//	public int compareTo(RankPositionTO o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
