package com.capgemini.capmates.ServiceTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.capmates.Service.AvailableTimeServiceImpl;
import com.capgemini.capmates.TO.AvailTimeTO;
import com.capgemini.capmates.TO.ChallengeTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AvailTimesServiceTests {

	@Autowired
	private AvailableTimeServiceImpl availTimesService;

	@Test
	public void shouldReturnNumberOfTimes() {
		// given
		availTimesService.init();

		Integer playerId = 1;
		final int EXPECTED_PLAYER_TIMES = 2;

		// when
		ArrayList<AvailTimeTO> playerTime = availTimesService.showPlayerTimes(playerId);

		// then
		assertEquals(EXPECTED_PLAYER_TIMES, playerTime.size());

	}

	@Test
	public void shouldAddNewAvailableTime() {
		// given
		availTimesService.init();

		Integer playerId = 3;
		final int EXPECTED_OLD_PLAYER_TIMES = 2;
		final int EXPECTED_NEW_PLAYER_TIMES = 3;
		AvailTimeTO newTime = new AvailTimeTO(playerId, LocalTime.of(14, 00), LocalTime.of(16, 00), "Active", "");

		// when
		ArrayList<AvailTimeTO> playerTime = availTimesService.showPlayerTimes(playerId);
		int oldPlayerTimes = playerTime.size();

		availTimesService.newAvailTime(newTime);
		playerTime = availTimesService.showPlayerTimes(playerId);
		int newPlayerTimes = playerTime.size();

		// then
		assertEquals(EXPECTED_OLD_PLAYER_TIMES, oldPlayerTimes);
		assertEquals(EXPECTED_NEW_PLAYER_TIMES, newPlayerTimes);
	}

	@Test
	public void shouldEditAvailableTime() {
		// given
		availTimesService.init();

		Integer playerId = 1;
		final int EXPECTED_OLD_PLAYER_TIMES = 2;
		final int EXPECTED_NEW_PLAYER_TIMES = 2;
		final LocalTime NEW_START = LocalTime.of(9, 00);
		final LocalTime NEW_STOP = LocalTime.of(11, 00);
		final int UPDATED_TIME_ID = 1;

		// when
		AvailTimeTO updatedTime = new AvailTimeTO(playerId, NEW_START, NEW_STOP, "Active", "");
		ArrayList<AvailTimeTO> playerTime = availTimesService.showPlayerTimes(playerId);
		int oldPlayerTimes = playerTime.size();
		AvailTimeTO oldTime = playerTime.get(UPDATED_TIME_ID);

		availTimesService.editAvailTime(oldTime, updatedTime);
		;
		playerTime = availTimesService.showPlayerTimes(playerId);
		int newPlayerTimes = playerTime.size();

		// then
		assertEquals(EXPECTED_OLD_PLAYER_TIMES, oldPlayerTimes);
		assertEquals(EXPECTED_NEW_PLAYER_TIMES, newPlayerTimes);
		assertEquals(NEW_START, playerTime.get(UPDATED_TIME_ID).getStart());
		assertEquals(NEW_STOP, playerTime.get(UPDATED_TIME_ID).getStop());
	}

	@Test
	public void shouldRemoveExistingTime() {
		// given
		availTimesService.init();

		Integer playerId = 1;
		final int EXPECTED_OLD_PLAYER_TIMES = 2;
		final int EXPECTED_NEW_PLAYER_TIMES = 2;
		final String EXPECTED_STATUS = "I have to be in work";
		LocalTime startToRemove = LocalTime.of(16, 00);
		LocalTime stopToRemove = LocalTime.of(18, 00);

		// when
		AvailTimeTO timeToRemove = new AvailTimeTO(playerId, startToRemove, stopToRemove, "Inactive", EXPECTED_STATUS);
		ArrayList<AvailTimeTO> playerTime = availTimesService.showPlayerTimes(playerId);

		int oldPlayerTimes = playerTime.size();

		boolean isRemoved = false;
		isRemoved = availTimesService.removeAvailTime(playerId, timeToRemove);
		playerTime = availTimesService.showPlayerTimes(playerId);

		int newPlayerTimes = playerTime.size();

		// then
		assertEquals(EXPECTED_OLD_PLAYER_TIMES, oldPlayerTimes);
		assertEquals(EXPECTED_NEW_PLAYER_TIMES, newPlayerTimes);
		assertTrue(isRemoved);
		assertTrue(playerTime.contains(timeToRemove));
	}

	@Test
	public void shouldCreate3Challenges() {
		// given
		availTimesService.init();

		Integer PLAYER_ID = 2;
		final int MINIMUM_PERIOD = 60;
		final int EXPECTED_CHALLENGES = 3;

		// when
		ArrayList<ChallengeTO> createdChallenges = new ArrayList<ChallengeTO>();
		createdChallenges.addAll(availTimesService.createChallenges(PLAYER_ID, MINIMUM_PERIOD));

		// then
		assertEquals(EXPECTED_CHALLENGES, createdChallenges.size());
	}

	@Test
	public void shouldCreate4Challenges() {
		// given
		availTimesService.init();

		Integer PLAYER_ID = 2;
		final int MINIMUM_PERIOD = 30;
		final int EXPECTED_CHALLENGES = 4;

		// when
		ArrayList<ChallengeTO> createdChallenges = new ArrayList<ChallengeTO>();
		createdChallenges.addAll(availTimesService.createChallenges(PLAYER_ID, MINIMUM_PERIOD));

		// then
		assertEquals(EXPECTED_CHALLENGES, createdChallenges.size());
	}
}
