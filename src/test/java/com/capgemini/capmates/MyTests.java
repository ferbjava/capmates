package com.capgemini.capmates;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.capmates.DAO.PlayerDao;
import com.capgemini.capmates.Entities.Challenge;
import com.capgemini.capmates.Entities.Game;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.Service.AvailableTimeServiceImpl;
import com.capgemini.capmates.Service.PlayerGamesServiceImpl;
import com.capgemini.capmates.Service.PlayerProfileServiceImpl;
import com.capgemini.capmates.Service.PlayerStatsImpl;
import com.capgemini.capmates.TO.AvailTimeTO;
import com.capgemini.capmates.TO.GameTO;
import com.capgemini.capmates.TO.PlayerProfileTO;

@RunWith(SpringRunner.class)
@SpringBootTest // (classes = CapmatesApplication.class)
public class MyTests {

	@Autowired
	private PlayerDao players;

	@Autowired
	private PlayerProfileServiceImpl playerService;

	@Autowired
	private PlayerGamesServiceImpl gamesService;

	@Autowired
	private AvailableTimeServiceImpl availTimesService;

	@Autowired
	private PlayerStatsImpl playerStats;

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldReturnNumberOfPlayer() {
		// given
		Integer EXPECTED_COLLECTION_SIZE = 3;
		Collection<Player> actualPlayers = players.getAllPlayers();

		// when
		Integer recentSize = actualPlayers.size();

		// then
		assertEquals(EXPECTED_COLLECTION_SIZE, recentSize);
	}

	@Test
	public void shouldShowPlayerProfile() {
		// given
		playerService.initDao();
		Integer playerId = 2;
		String EXPECTED_FIRST_NAME = "Andrzej";
		String EXPECTED_LAST_NAME = "Nowak";
		String EXPECTED_MAIL = "andrzej.nowak@gmail.com";
		String EXPECTED_PASSWORD = "andrzejKing";
		String EXPECTED_LIFE_MOTTO = "Pantha rei";

		// when
		PlayerProfileTO playerProfile = playerService.showPlayerProfile(playerId);

		// then
		assertEquals(EXPECTED_FIRST_NAME, playerProfile.getFirstName());
		assertEquals(EXPECTED_LAST_NAME, playerProfile.getLastName());
		assertEquals(EXPECTED_MAIL, playerProfile.getEmail());
		assertEquals(EXPECTED_PASSWORD, playerProfile.getPassword());
		assertEquals(EXPECTED_LIFE_MOTTO, playerProfile.getLifeMotto());
	}

	@Test
	public void shouldShowPlayerProfileElements() {
		// given
		playerService.initDao();
		int playerId = 1;
		String EXPECTED_FIRST_NAME = "Jan";
		String EXPECTED_LAST_NAME = "Kowalski";
		String EXPECTED_MAIL = "jan.kowalski@gmail.com";
		String EXPECTED_PASSWORD = "admin1234";
		String EXPECTED_LIFE_MOTTO = "amdg";

		// when

		// then
		assertEquals(EXPECTED_FIRST_NAME, playerService.getPlayerFirstName(playerId));
		assertEquals(EXPECTED_LAST_NAME, playerService.getPlayerLastName(playerId));
		assertEquals(EXPECTED_MAIL, playerService.getPlayerEmail(playerId));
		assertEquals(EXPECTED_PASSWORD, playerService.getPlayerPassword(playerId));
		assertEquals(EXPECTED_LIFE_MOTTO, playerService.getPlayerLifeMotto(playerId));
	}

	@Test
	public void shouldSetPlayerProfileElements() {
		// given
		playerService.initDao();
		String EXPECTED_FIRST_NAME = "Bozydar";
		String EXPECTED_LAST_NAME = "Brzeczeszczykiewicz";
		String EXPECTED_EMAIL = "bozo.wpozo@wp.pl";
		String EXPECTED_PASSWORD = "imieUkochanej";
		String EXPECTED_LIFE_MOTTO = "ACAB";

		Integer playerId = 1;
		String newFirstName = "Bozydar";
		String newLastName = "Brzeczeszczykiewicz";
		String newEmail = "bozo.wpozo@wp.pl";
		String newPassword = "imieUkochanej";
		String newLifeMotto = "ACAB";

		// when
		playerService.setPlayerFirstName(playerId, newFirstName);
		playerService.setPlayerLastName(playerId, newLastName);
		playerService.setPlayerEmail(playerId, newEmail);
		playerService.setPlayerPassword(playerId, newPassword);
		playerService.setPlayerLifeMotto(playerId, newLifeMotto);

		// then
		assertEquals(EXPECTED_FIRST_NAME, playerService.getPlayerFirstName(playerId));
		assertEquals(EXPECTED_LAST_NAME, playerService.getPlayerLastName(playerId));
		assertEquals(EXPECTED_EMAIL, playerService.getPlayerEmail(playerId));
		assertEquals(EXPECTED_PASSWORD, playerService.getPlayerPassword(playerId));
		assertEquals(EXPECTED_LIFE_MOTTO, playerService.getPlayerLifeMotto(playerId));
	}

	@Test
	public void shouldReturnNullPlayerGames() {
		// given
		playerService.initDao();
		gamesService.initDao();

		Integer playerId = 1;
		int EXPECTED_PLAYER_GAMES = 0;

		// when
		ArrayList<Game> playerGames = new ArrayList<>();
		playerGames.addAll(gamesService.showPlayerGames(playerId));

		// then
		assertEquals(EXPECTED_PLAYER_GAMES, playerGames.size());

	}

	@Test
	public void shouldAddNewGameToPlayerCollection() {
		// given
		playerService.initDao();
		gamesService.initDao();

		Integer playerId = 1;
		int EXPECTED_PLAYER_GAMES = 1;
		int EXPECTED_GAMES_IN_REPOSITORY = 5;
		GameTO newGame = new GameTO("Monopoly", 2, 6);
		gamesService.addGameToUserCollection(playerId, newGame);

		// when
		ArrayList<Game> playerGames = new ArrayList<Game>();
		playerGames.addAll(gamesService.showPlayerGames(playerId));

		// then
		assertEquals(EXPECTED_PLAYER_GAMES, playerGames.size());
		assertEquals(EXPECTED_GAMES_IN_REPOSITORY, gamesService.showGamesInRepo().size());

	}

	@Test
	public void shouldAddNewGameToGlobalCollection() {
		// given
		playerService.initDao();
		gamesService.initDao();

		Integer playerId = 1;
		int EXPECTED_PLAYER_GAMES = 1;
		int EXPECTED_GAMES_IN_REPOSITORY = 6;
		GameTO newGame = new GameTO("Fasolki", 2, 6);
		gamesService.addGameToUserCollection(playerId, newGame);

		// when
		ArrayList<Game> playerGames = new ArrayList<>();
		playerGames.addAll(gamesService.showPlayerGames(playerId));

		// then
		assertEquals(EXPECTED_PLAYER_GAMES, playerGames.size());
		assertEquals(EXPECTED_GAMES_IN_REPOSITORY, gamesService.showGamesInRepo().size());

	}

	@Test
	public void shouldAddOnlyOnceTheSameGame() {
		// given
		playerService.initDao();
		gamesService.initDao();

		Integer playerId = 1;
		int EXPECTED_PLAYER_GAMES = 2;
		int EXPECTED_GAMES_IN_REPOSITORY = 6;
		GameTO newGame1 = new GameTO("Monopoly", 2, 6);
		GameTO newGame2 = new GameTO("Fasolki", 2, 6);
		GameTO newGame3 = new GameTO("Fasolki", 2, 6);
		gamesService.addGameToUserCollection(playerId, newGame1);
		gamesService.addGameToUserCollection(playerId, newGame2);
		gamesService.addGameToUserCollection(playerId, newGame3);

		// when
		ArrayList<Game> playerGames = new ArrayList<>();
		playerGames.addAll(gamesService.showPlayerGames(playerId));

		// then
		assertEquals(EXPECTED_PLAYER_GAMES, playerGames.size());
		assertEquals(EXPECTED_GAMES_IN_REPOSITORY, gamesService.showGamesInRepo().size());

	}

	@Test
	public void shouldRemovePlayerGame() {
		// given
		playerService.initDao();
		gamesService.initDao();

		Integer playerId = 1;
		int EXPECTED_PLAYER_GAMES = 1;
		int EXPECTED_GAMES_IN_REPOSITORY = 6;
		GameTO newGame1 = new GameTO("Monopoly", 2, 6);
		GameTO newGame2 = new GameTO("Fasolki", 2, 6);
		gamesService.addGameToUserCollection(playerId, newGame1);
		gamesService.addGameToUserCollection(playerId, newGame2);
		Game gameToRemove = new Game(5, "Fasolki", 2, 6);

		// when
		gamesService.removePlayerGame(playerId, gameToRemove);

		// then
		assertEquals(EXPECTED_PLAYER_GAMES, gamesService.showPlayerGames(playerId).size());
		assertEquals(EXPECTED_GAMES_IN_REPOSITORY, gamesService.showGamesInRepo().size());

	}

	@Test
	public void shouldReturnNumberOfTimes() {
		// given
		availTimesService.init();

		Integer playerId = 1;
		int EXPECTED_PLAYER_TIMES = 2;

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
		int EXPECTED_OLD_PLAYER_TIMES = 2;
		int EXPECTED_NEW_PLAYER_TIMES = 3;
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
		int EXPECTED_OLD_PLAYER_TIMES = 2;
		int EXPECTED_NEW_PLAYER_TIMES = 2;
		LocalTime NEW_START = LocalTime.of(9, 00);
		LocalTime NEW_STOP = LocalTime.of(11, 00);
		int UPDATED_TIME_ID = 1;

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
		int EXPECTED_OLD_PLAYER_TIMES = 2;
		int EXPECTED_NEW_PLAYER_TIMES = 2;
		String EXPECTED_STATUS = "I have to be in work";
		LocalTime startToRemove = LocalTime.of(16, 00);
		LocalTime stopToRemove = LocalTime.of(18, 00);

		// when
		AvailTimeTO timeToRemove = new AvailTimeTO(playerId, startToRemove, stopToRemove, "Inactive", EXPECTED_STATUS);
		ArrayList<AvailTimeTO> playerTime = availTimesService.showPlayerTimes(playerId);

		int oldPlayerTimes = playerTime.size();

		boolean isRemoved = false;
		isRemoved = availTimesService.removeAvailTime(playerId, timeToRemove);
		;
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
		int MINIMUM_PERIOD = 60;
		int EXPECTED_CHALLENGES = 3;

		// when
		ArrayList<Challenge> createdChallenges = new ArrayList<Challenge>();
		createdChallenges.addAll(availTimesService.createChallenges(PLAYER_ID, MINIMUM_PERIOD));

		// then
		assertEquals(EXPECTED_CHALLENGES, createdChallenges.size());
	}

	@Test
	public void shouldCreate4Challenges() {
		// given
		availTimesService.init();

		Integer PLAYER_ID = 2;
		int MINIMUM_PERIOD = 30;
		int EXPECTED_CHALLENGES = 4;

		// when
		ArrayList<Challenge> createdChallenges = new ArrayList<Challenge>();
		createdChallenges.addAll(availTimesService.createChallenges(PLAYER_ID, MINIMUM_PERIOD));

		// then
		assertEquals(EXPECTED_CHALLENGES, createdChallenges.size());
	}

	@Test
	public void shouldReturnNumberOfPlayers() {
		// given
		playerStats.init();

		int EXPECTED_PLAYER_NUMBER = 3;

		// when
		int playersNumber = playerStats.showPlayersId().size();

		// then
		assertEquals(EXPECTED_PLAYER_NUMBER, playersNumber);
	}

	@Test
	public void shouldReturnNumberOfGamePlayes() {
		// given
		playerStats.init();

		int EXPECTED_PLAYER_GAMEPLAYS = 5;
		long playerId=1;

		// when
		int playerGameplays=playerStats.showPlayerHistory(playerId).size();
//		int playerGameplays=playerStats.showAllGames(playerId).size();

		// then
		assertEquals(EXPECTED_PLAYER_GAMEPLAYS, playerGameplays);
	}

}
