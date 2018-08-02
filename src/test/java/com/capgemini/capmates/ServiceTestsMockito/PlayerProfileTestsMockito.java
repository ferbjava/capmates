package com.capgemini.capmates.ServiceTestsMockito;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.capgemini.capmates.DAO.PlayerDao;
import com.capgemini.capmates.Entities.Game;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.Mappers.PlayerProfileMapper;
import com.capgemini.capmates.Service.PlayerProfileServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerProfileTestsMockito {

	@Mock
	PlayerDao playersDaoMock;

	@Autowired
	PlayerProfileMapper profileMapper;

	@InjectMocks
	PlayerProfileServiceImpl playerService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(playerService, "playerMapper", profileMapper);
	}

	@Test
	public void shouldShowPlayerProfile() {
		// given
		final Integer PLAYER_ID = 2;
		final String EXPECTED_FIRST_NAME = "Krzysztof";
		final ArrayList<Game> playerGames = new ArrayList<>();
		final Player TEST_PROFILE = new Player(PLAYER_ID, EXPECTED_FIRST_NAME, "Jarzyna", "krol.szczenina@gmail.com",
				"mistrz", "Szef Wszystkich szefow", playerGames);

		// when
		Mockito.when(playersDaoMock.getPlayerById(Mockito.anyInt())).thenReturn(TEST_PROFILE);

		String testFirstName = playerService.showPlayerProfile(PLAYER_ID).getFirstName();

		// then
		assertEquals(EXPECTED_FIRST_NAME, testFirstName);
	}
}
