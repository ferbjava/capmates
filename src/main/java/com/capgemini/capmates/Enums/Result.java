package com.capgemini.capmates.Enums;

public enum Result {
	WIN(5),
	DRAW(1),
	LOSS(0);
	
	private final int scores;
	
	Result(int scores){
		this.scores=scores;
	}

	public int getScores() {
		return scores;
	}
}
