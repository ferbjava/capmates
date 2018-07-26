package com.capgemini.capmates.TO;

import java.time.LocalTime;

public class AvailTimeTO {
	private int playerId;
	private LocalTime start;
	private LocalTime stop;
	private String status;
	private String comment;
	
	public AvailTimeTO(int playerId, LocalTime start, LocalTime stop, String status, String comment){
		setPlayerId(playerId);
		setStart(start);
		setStop(stop);
		setStatus(status);
		setComment(comment);
}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public LocalTime getStart() {
		return start;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getStop() {
		return stop;
	}

	public void setStop(LocalTime stop) {
		this.stop = stop;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}