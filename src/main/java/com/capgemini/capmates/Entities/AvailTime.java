package com.capgemini.capmates.Entities;

import java.time.LocalTime;

public class AvailTime {
	private long availTimeId;
	private int playerId;
	private LocalTime start;
	private LocalTime stop;
	private String status;
	private String comment;

	public AvailTime(long id, Integer playerId, LocalTime start, LocalTime stop, String status, String comment) {
		setAvailTimeId(id);
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

	public long getAvailTimeId() {
		return availTimeId;
	}

	public void setAvailTimeId(long availTimeId) {
		this.availTimeId = availTimeId;
	}

}
