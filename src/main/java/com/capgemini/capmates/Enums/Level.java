package com.capgemini.capmates.Enums;

public enum Level {
	NEWBIE(5L),
	NORMAL(20L),
	ADVANCED(100L),
	MASTER(500L),
	IMPOSSIBLE(5000L);
	
	private final Long pointsToNextLevel;

	Level(Long pointsToNextLevel){
		this.pointsToNextLevel=pointsToNextLevel;
	}
	
	public Long getPoints() {
		return pointsToNextLevel;
	}
	
	public static Level getLevelByValue(Long points){
		for(Level level: Level.values()){
			if(points<=level.getPoints()){
				return level;
			}
		}
		return NEWBIE;
	}
	
}
