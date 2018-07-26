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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (availTimeId ^ (availTimeId >>> 32));
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + playerId;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((stop == null) ? 0 : stop.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvailTime other = (AvailTime) obj;
		if (availTimeId != other.availTimeId)
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (playerId != other.playerId)
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (stop == null) {
			if (other.stop != null)
				return false;
		} else if (!stop.equals(other.stop))
			return false;
		return true;
	}
	
}
