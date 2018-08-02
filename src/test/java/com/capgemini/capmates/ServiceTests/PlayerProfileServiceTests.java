package com.capgemini.capmates.ServiceTests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.capmates.DAO.PlayerDao;
import com.capgemini.capmates.Service.PlayerProfileServiceImpl;
import com.capgemini.capmates.TO.PlayerProfileTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerProfileServiceTests {

	@Autowired
	private PlayerDao players;

	@Autowired
	private PlayerProfileServiceImpl playerService;

	@Test
	public void shouldReturnNumberOfPlayer() {
		// given
		Integer EXPECTED_COLLECTION_SIZE = 4;

		// when
		Collection<PlayerProfileTO> actualPlayers = players.getAllPlayersProfiles();
		Integer recentSize = actualPlayers.size();

		// then
		assertEquals(EXPECTED_COLLECTION_SIZE, recentSize);
	}

	@Test
	public void shouldShowNumberOfPlayer() {
		// given
		playerService.initDao();
		final Integer EXPECTED_PLAYERS = 4;

		// when
		Integer playersNo = playerService.showPlayersNumber();

		// then
		assertEquals(EXPECTED_PLAYERS, playersNo);
	}

	@Test
	public void shouldShowAllPlayersProfiles() {
		// given
		playerService.initDao();
		final int EXPECTED_PLAYERS_NUMBER = 4;

		// when
		Collection<PlayerProfileTO> playersProfiles = playerService.showAllPlayersProfiles();

		// then
		assertEquals(EXPECTED_PLAYERS_NUMBER, playersProfiles.size());
	}

	@Test
	public void shouldShowPlayerProfile() {
		// given
		playerService.initDao();
		Integer playerId = 2;
		final String EXPECTED_FIRST_NAME = "Andrzej";
		final String EXPECTED_LAST_NAME = "Nowak";
		final String EXPECTED_MAIL = "andrzej.nowak@gmail.com";
		final String EXPECTED_PASSWORD = "andrzejKing";
		final String EXPECTED_LIFE_MOTTO = "Pantha rei";

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
		final String EXPECTED_FIRST_NAME = "Jan";
		final String EXPECTED_LAST_NAME = "Kowalski";
		final String EXPECTED_MAIL = "jan.kowalski@gmail.com";
		final String EXPECTED_PASSWORD = "admin1234";
		final String EXPECTED_LIFE_MOTTO = "amdg";

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
		final String EXPECTED_FIRST_NAME = "Bozydar";
		final String EXPECTED_LAST_NAME = "Brzeczeszczykiewicz";
		final String EXPECTED_EMAIL = "bozo.wpozo@wp.pl";
		final String EXPECTED_PASSWORD = "imieUkochanej";
		final String EXPECTED_LIFE_MOTTO = "ACAB";

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
	public void shouldUpdatePlayerProfile() {
		// given
		playerService.initDao();
		Integer playerProfileId = 1;
		final String EXPECTED_PLAYER_FIRST_NAME = "Bozydar";
		final String EXPECTED_PLAYER_LAST_NAME = "Wporzo";
		PlayerProfileTO updatedProfile = new PlayerProfileTO(playerProfileId, EXPECTED_PLAYER_FIRST_NAME,
				EXPECTED_PLAYER_LAST_NAME, "jan.kowalski@gmail.com", "admin1234", "amdg");

		// when
		playerService.editPlayerProfile(updatedProfile);

		// then
		assertEquals(EXPECTED_PLAYER_FIRST_NAME, playerService.getPlayerFirstName(playerProfileId));
	}

	@Test
	public void shouldReturn2FilteredProfiles() {
		// given
		playerService.initDao();
		final int EXPECTED_FILTERED_PROFILES = 2;
		final String EXPECTED_PLAYER_FIRST_NAME = "Jan";
		PlayerProfileTO filter = new PlayerProfileTO(null, EXPECTED_PLAYER_FIRST_NAME, "", null, null, null);

		// when
		List<PlayerProfileTO> filteredProfiles = playerService.showFilteredProfiles(filter);

		// then
		assertEquals(EXPECTED_PLAYER_FIRST_NAME, filteredProfiles.get(0).getFirstName());
		assertEquals(EXPECTED_FILTERED_PROFILES, filteredProfiles.size());
	}

}
