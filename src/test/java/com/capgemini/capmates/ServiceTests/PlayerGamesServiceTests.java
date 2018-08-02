package com.capgemini.capmates.ServiceTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.capmates.Service.PlayerGamesServiceImpl;
import com.capgemini.capmates.Service.PlayerProfileServiceImpl;
import com.capgemini.capmates.TO.GameTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerGamesServiceTests {

	@Autowired
	private PlayerProfileServiceImpl playerService;

	@Autowired
	private PlayerGamesServiceImpl gamesService;

	@Test
	public void shouldReturnNullPlayerGames() {
		// given
		playerService.initDao();
		gamesService.initDao();

		Integer playerId = 1;
		final int EXPECTED_PLAYER_GAMES = 0;

		// when
		ArrayList<GameTO> playerGames = new ArrayList<>();
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
		final int EXPECTED_PLAYER_GAMES = 1;
		final int EXPECTED_GAMES_IN_REPOSITORY = 5;
		GameTO newGame = new GameTO(0, "Monopoly", 2, 6);

		// when
		gamesService.addGameToUserCollection(playerId, newGame);

		ArrayList<GameTO> playerGames = gamesService.showPlayerGames(playerId);

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
		final int EXPECTED_PLAYER_GAMES = 1;
		final int EXPECTED_GAMES_IN_REPOSITORY = 6;
		GameTO newGame = new GameTO(0, "Fasolki", 2, 6);
		gamesService.addGameToUserCollection(playerId, newGame);

		// when
		ArrayList<GameTO> playerGames = new ArrayList<>();
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
		final int EXPECTED_PLAYER_GAMES = 2;
		final int EXPECTED_GAMES_IN_REPOSITORY = 6;
		GameTO newGame1 = new GameTO(0, "Monopoly", 2, 6);
		GameTO newGame2 = new GameTO(0, "Fasolki", 2, 6);
		GameTO newGame3 = new GameTO(0, "Fasolki", 2, 6);
		gamesService.addGameToUserCollection(playerId, newGame1);
		gamesService.addGameToUserCollection(playerId, newGame2);
		gamesService.addGameToUserCollection(playerId, newGame3);

		// when
		ArrayList<GameTO> playerGames = new ArrayList<>();
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
		final int EXPECTED_PLAYER_GAMES = 1;
		final int EXPECTED_GAMES_IN_REPOSITORY = 6;
		GameTO newGame1 = new GameTO(0, "Monopoly", 2, 6);
		GameTO newGame2 = new GameTO(0, "Fasolki", 2, 6);
		gamesService.addGameToUserCollection(playerId, newGame1);
		gamesService.addGameToUserCollection(playerId, newGame2);
		GameTO gameToRemove = new GameTO(5, "Fasolki", 2, 6);

		// when
		gamesService.removePlayerGame(playerId, gameToRemove);

		// then
		assertEquals(EXPECTED_PLAYER_GAMES, gamesService.showPlayerGames(playerId).size());
		assertEquals(EXPECTED_GAMES_IN_REPOSITORY, gamesService.showGamesInRepo().size());

	}
}
