package com.capgemini.capmates.TO;

import java.time.LocalTime;

public class ChallengeTO {
	private int firstPlayerId;
	private int secondPlayerId;
	private LocalTime startChallenge;
	private LocalTime stopChallenge;

	public ChallengeTO(int firstPlayerId, int secondPlayerId, LocalTime startChallenge, LocalTime stopChallenge) {
		setFirstPlayerId(firstPlayerId);
		setSecondPlayerId(secondPlayerId);
		setStartChallenge(startChallenge);
		setStopChallenge(stopChallenge);
	}

	public int getFirstPlayerId() {
		return firstPlayerId;
	}

	public void setFirstPlayerId(int firstPlayerId) {
		this.firstPlayerId = firstPlayerId;
	}

	public int getSecondPlayerId() {
		return secondPlayerId;
	}

	public void setSecondPlayerId(int secondPlayerId) {
		this.secondPlayerId = secondPlayerId;
	}

	public LocalTime getStartChallenge() {
		return startChallenge;
	}

	public void setStartChallenge(LocalTime startChallenge) {
		this.startChallenge = startChallenge;
	}

	public LocalTime getStopChallenge() {
		return stopChallenge;
	}

	public void setStopChallenge(LocalTime stopChallenge) {
		this.stopChallenge = stopChallenge;
	}

}
