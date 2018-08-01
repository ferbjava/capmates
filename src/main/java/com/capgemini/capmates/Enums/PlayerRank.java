package com.capgemini.capmates.Enums;


public enum PlayerRank {
	NEWBIE(0L),
	NORMAL(5L),
	ADVANCED(20L),
	MASTER(100L),
	IMPOSSIBLE(500L);
	
	private final Long value;

	PlayerRank(Long value){
		this.value=value;
	}
	
	public Long getValue() {
		return value;
	}
	
	public static PlayerRank getRankByValue(Long value){
		for(PlayerRank rank: PlayerRank.values()){
			if(value<=rank.getValue()){
				return rank;
			}
		}
		return null;
	}
	
}
