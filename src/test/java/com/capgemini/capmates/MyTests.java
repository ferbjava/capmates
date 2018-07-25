package com.capgemini.capmates;


import java.util.Collection;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.capmates.DAO.PlayerDao;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.Service.PlayerProfileServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTests {

	@Autowired
	private PlayerDao players;
	
	@Autowired
	private PlayerProfileServiceImpl playerService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void shouldReturnNumberOfPlayer(){
		//given
		Integer EXPECTED_COLLECTION_SIZE=3;
		Collection<Player> actualPlayers= players.getAllPlayers();
		
		//when
		Integer recentSize=actualPlayers.size();
		
		//then
		assertEquals(EXPECTED_COLLECTION_SIZE,recentSize);
	}
	
	@Test
	public void shouldShowPlayerProfileElements(){
		//given
		playerService.initDao();
		String EXPECTED_FIRST_NAME = "Jan";
		String EXPECTED_LAST_NAME = "Kowalski";
		String EXPECTED_MAIL = "jan.kowalski@gmail.com";
		String EXPECTED_PASSWORD = "admin1234";
		String EXPECTED_LIFE_MOTTO = "amdg";
		
		//when
		
		//then
		assertEquals(EXPECTED_FIRST_NAME,playerService.getPlayerFirstName(1));
		assertEquals(EXPECTED_LAST_NAME,playerService.getPlayerLastName(1));
		assertEquals(EXPECTED_MAIL,playerService.getPlayerEmail(1));
		assertEquals(EXPECTED_PASSWORD,playerService.getPlayerPassword(1));
		assertEquals(EXPECTED_LIFE_MOTTO,playerService.getPlayerLifeMotto(1));
	}
	
	@Test
	public void shouldSetPlayerProfileElements(){
		//given
		String EXPECTED_FIRST_NAME = "Bozydar";
		String EXPECTED_LAST_NAME = "Brzeczeszczykiewicz";
		
		Integer playerId=1;
		String newFirstName="Bozydar";
		String newLastName="Brzeczeszczykiewicz";
		
		//when
		playerService.setPlayerFirstName(playerId, newFirstName);
		playerService.setPlayerLastName(playerId, newLastName);
		
		//then
		assertEquals(EXPECTED_FIRST_NAME,playerService.getPlayerFirstName(playerId));
		assertEquals(EXPECTED_LAST_NAME,playerService.getPlayerLastName(playerId));
	}
	
}
