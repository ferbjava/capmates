package com.capgemini.capmates.Service;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capmates.DAO.AvailTimesDao;
import com.capgemini.capmates.Entities.Challenge;
import com.capgemini.capmates.Mappers.AvailTimesMapper;
import com.capgemini.capmates.TO.AvailTimeTO;

@Service
public class AvailableTimeServiceImpl {
	private AvailTimesDao availTimesDao;
	private AvailTimesMapper availTimesMapper;

	@Autowired
	public AvailableTimeServiceImpl(AvailTimesDao availTimesDao, AvailTimesMapper availTimesMapper) {
		this.availTimesDao = availTimesDao;
		this.availTimesMapper = availTimesMapper;
	}

	public void init() {
		availTimesDao.init();
	}

	public void newAvailTime(AvailTimeTO availTimeTO) {
		long newAvailTimeId = availTimesDao.availTimesNextId();
		availTimesDao.addNewAvailTime(availTimesMapper.tOmappedToEntity(newAvailTimeId, availTimeTO));
	}

	public ArrayList<AvailTimeTO> showPlayerTimes(Integer playerId) {
		return availTimesDao.showPlayerTimes(playerId);
	}

	public void editAvailTime(AvailTimeTO oldTime, AvailTimeTO updatedTime) {
		availTimesDao.editAvailTime(oldTime, updatedTime);
	}

	public boolean removeAvailTime(Integer playerId, AvailTimeTO timeToRemove) {
		return availTimesDao.removeAvailTime(playerId, timeToRemove);
	}

	public ArrayList<Challenge> createChallenges(int playerId, long minPeriod) {

		ArrayList<Challenge> challengeList = new ArrayList<Challenge>();
		ArrayList<AvailTimeTO> timeList = new ArrayList<AvailTimeTO>();
		timeList.addAll(availTimesDao.showAllTimes());

		for (AvailTimeTO tempTime : timeList) {
			if (tempTime.getPlayerId() == playerId) {
				challengeList.addAll(createChallengesForSelectedTime(tempTime, timeList, minPeriod));
			}
		}
		return challengeList;
	}

	private ArrayList<Challenge> createChallengesForSelectedTime(AvailTimeTO playerTime,
			ArrayList<AvailTimeTO> allTimes, long minPeriod) {

		ArrayList<Challenge> challengeList = new ArrayList<Challenge>();
		int playerId = playerTime.getPlayerId();

		for (AvailTimeTO tempTime : allTimes) {
			int enemyId = tempTime.getPlayerId();
			if (!(playerId == enemyId)) {
				ArrayList<LocalTime> commonPeriod = createCommonPeriod(playerTime, tempTime, minPeriod);
				if (commonPeriod.size() != 0) {
					challengeList.add(new Challenge(playerId, enemyId, commonPeriod.get(0), commonPeriod.get(1)));
				}
			}
		}
		return challengeList;
	}

	private ArrayList<LocalTime> createCommonPeriod(AvailTimeTO playerTime, AvailTimeTO tempTime, long minPeriod) {

		ArrayList<LocalTime> commonPeriod = new ArrayList<>();
		LocalTime commonStart;
		LocalTime commonStop;

		if (playerTime.getStart().isAfter(tempTime.getStart())) {
			commonStart = playerTime.getStart();
		} else {
			commonStart = tempTime.getStart();
		}

		if (playerTime.getStop().isAfter(tempTime.getStop())) {
			commonStop = tempTime.getStop();
		} else {
			commonStop = playerTime.getStop();
		}

		long thisPeriod = ChronoUnit.MINUTES.between(commonStart, commonStop);
		if (commonStop.isAfter(commonStart) && thisPeriod >= minPeriod) {
			commonPeriod.add(commonStart);
			commonPeriod.add(commonStop);
		}

		return commonPeriod;
	}

}
