package com.capgemini.capmates.ServiceTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.capmates.Enums.PlayerRank;
import com.capgemini.capmates.Service.PlayerStatsImpl;
import com.capgemini.capmates.TO.RankPositionTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerStatsServiceTests {

	@Autowired
	private PlayerStatsImpl playerStats;

	@Test
	public void shouldReturnNumberOfPlayers() {
		// given
		playerStats.init();

		int EXPECTED_PLAYER_NUMBER = 3;

		// when
		int playersNumber = playerStats.showActivePlayersId().size();

		// then
		assertEquals(EXPECTED_PLAYER_NUMBER, playersNumber);
	}


	@Test
	public void shouldReturnNumberOfGamePlayes() {
		// given
		playerStats.init();

		int EXPECTED_PLAYER_GAMEPLAYS = 5;
		long playerId = 1;

		// when
		int playerGameplays = playerStats.showPlayerHistory(playerId).size();

		// then
		assertEquals(EXPECTED_PLAYER_GAMEPLAYS, playerGameplays);
	}

	 @Test
	 public void shouldReturnRanking() {
	 // given
	 playerStats.init();
	
	 int EXPECTED_PLAYER_GAMEPLAYS = 5;
	 Long playerId=3L;
	
	 // when
	 ArrayList<RankPositionTO>ranking=new ArrayList<RankPositionTO>();
	 ranking=playerStats.createRanking();
	 
	 int position=playerStats.showRankingPosition(playerId);
	 PlayerRank rank=playerStats.showPlayerRank(playerId);
	
	 System.out.println(position+"  "+rank.toString());
	 // then
	 assertEquals(EXPECTED_PLAYER_GAMEPLAYS, 5);
	 }

}
