package com.capgemini.capmates;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.capmates.DAO.PlayerDao;
import com.capgemini.capmates.Entities.Game;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.Service.AvailableTimeServiceImpl;
import com.capgemini.capmates.Service.PlayerGamesServiceImpl;
import com.capgemini.capmates.Service.PlayerProfileServiceImpl;
import com.capgemini.capmates.TO.AvailTimeTO;
import com.capgemini.capmates.TO.GameTO;
import com.capgemini.capmates.TO.PlayerProfileTO;

@RunWith(SpringRunner.class)
@SpringBootTest//(classes = CapmatesApplication.class)
public class MyTests {

	@Autowired
	private PlayerDao players;

	@Autowired
	private PlayerProfileServiceImpl playerService;

	@Autowired
	private PlayerGamesServiceImpl gamesService;
	
	@Autowired
	private AvailableTimeServiceImpl availTimesService;

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
		Integer playerId=2;
		String EXPECTED_FIRST_NAME = "Andrzej";
		String EXPECTED_LAST_NAME = "Nowak";
		String EXPECTED_MAIL = "andrzej.nowak@gmail.com";
		String EXPECTED_PASSWORD = "andrzejKing";
		String EXPECTED_LIFE_MOTTO = "Pantha rei";

		// when
		PlayerProfileTO playerProfile=playerService.showPlayerProfile(playerId);

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
		int playerId=1;
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
	public void shouldReturnNumberOfPlayerTimes() {
		// given
		availTimesService.init();

		Integer playerId = 1;
		int EXPECTED_PLAYER_TIMES =2;

		// when
		ArrayList<AvailTimeTO>playerTime= availTimesService.showPlayerTimes(playerId);

		// then
		assertEquals(EXPECTED_PLAYER_TIMES, playerTime.size());

	}

}
