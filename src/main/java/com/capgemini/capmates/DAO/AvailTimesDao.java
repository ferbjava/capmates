package com.capgemini.capmates.DAO;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.capgemini.capmates.Entities.AvailTime;
import com.capgemini.capmates.Mappers.AvailTimesMapper;
import com.capgemini.capmates.TO.AvailTimeTO;

@Repository
public class AvailTimesDao {
	private ArrayList<AvailTime> availTimes;
	private AtomicLong availTimeId;
	private AvailTimesMapper timesMapper;

	public AvailTimesDao() {
		availTimes = new ArrayList<AvailTime>();
		availTimeId = new AtomicLong();
		timesMapper = new AvailTimesMapper();
	}

	public void init() {
		availTimes.clear();
		availTimeId.set(0);
		availTimes.add(new AvailTime(availTimeId.getAndIncrement(), 1, LocalTime.of(10, 30), LocalTime.of(12, 30),
				"Active", null));
		availTimes.add(new AvailTime(availTimeId.getAndIncrement(), 1, LocalTime.of(16, 00), LocalTime.of(18, 00),
				"Active", null));
		availTimes.add(new AvailTime(availTimeId.getAndIncrement(), 2, LocalTime.of(11, 00), LocalTime.of(13, 00),
				"Active", null));
		availTimes.add(new AvailTime(availTimeId.getAndIncrement(), 2, LocalTime.of(17, 30), LocalTime.of(19, 30),
				"Active", null));
		availTimes.add(new AvailTime(availTimeId.getAndIncrement(), 3, LocalTime.of(10, 00), LocalTime.of(12, 00),
				"Active", null));
		availTimes.add(new AvailTime(availTimeId.getAndIncrement(), 3, LocalTime.of(18, 30), LocalTime.of(21, 00),
				"Active", null));
	}

	public void addNewAvailTime(AvailTime availTime) {
		availTimes.add(availTime);
	}

	public long availTimesNextId() {
		return availTimeId.getAndIncrement();
	}

	public ArrayList<AvailTimeTO> showPlayerTimes(int playerId) {
		ArrayList<AvailTimeTO> playerTimes = new ArrayList<AvailTimeTO>();
		for (AvailTime time : availTimes) {
			if (time.getPlayerId() == playerId) {
				AvailTimeTO timeTO = timesMapper.entityToTO(time);
				playerTimes.add(timeTO);
			}
		}
		return playerTimes;
	}

	public boolean editAvailTime(AvailTimeTO oldTime, AvailTimeTO updatedTime) {
		LocalTime updatedStart = updatedTime.getStart();
		LocalTime updatedStop = updatedTime.getStop();
		for (AvailTime timeEntity : availTimes) {
			if (entityEqualTO(timeEntity, oldTime)) {
				timeEntity.setStart(updatedStart);
				timeEntity.setStop(updatedStop);
				return true;
			}
		}
		return false;
	}

	public boolean removeAvailTime(Integer playerId, AvailTimeTO timeToRemove) {
		for (AvailTime timeEntity : availTimes) {
			if (entityEqualTO(timeEntity, timeToRemove)) {
				timeEntity.setStatus("Inactive");
				timeEntity.setComment(timeToRemove.getComment());
				return true;
			}
		}
		return false;
	}

	private boolean entityEqualTO(AvailTime timeEntity, AvailTimeTO timeTO) {
		boolean playerOK = timeEntity.getPlayerId() == timeTO.getPlayerId();
		boolean startOK = timeEntity.getStart().equals(timeTO.getStart());
		boolean stopOK = timeEntity.getStop().equals(timeTO.getStop());
		boolean statusOK = timeEntity.getStatus().equals("Active");
		return playerOK && startOK && stopOK && statusOK;
	}

	public ArrayList<AvailTimeTO> showAllTimes() {
		ArrayList<AvailTimeTO> timeListTO = new ArrayList<AvailTimeTO>();
		for (AvailTime tempTime : availTimes) {
			timeListTO.add(timesMapper.entityToTO(tempTime));
		}
		return timeListTO;
	}

}
