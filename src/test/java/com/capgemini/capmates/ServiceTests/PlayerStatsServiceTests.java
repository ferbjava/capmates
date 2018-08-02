package com.capgemini.capmates.ServiceTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.capmates.Enums.Level;
import com.capgemini.capmates.Service.PlayerStatsImpl;
import com.capgemini.capmates.TO.StatisticsTO;

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
		 Long player1=1L;
		 Long player2=2L;
		 Long player3=3L;
		 
		 int EXPECTED_POSITION_PLAYER_1=3;
		 int EXPECTED_POSITION_PLAYER_2=2;
		 int EXPECTED_POSITION_PLAYER_3=1;
	
		 // when
	 
		 int positionPlayer1=playerStats.showRankingPosition(player1);
		 int positionPlayer2=playerStats.showRankingPosition(player2);
		 int positionPlayer3=playerStats.showRankingPosition(player3);
	
		 // then
		 assertEquals(EXPECTED_POSITION_PLAYER_1, positionPlayer1);
		 assertEquals(EXPECTED_POSITION_PLAYER_2, positionPlayer2);
		 assertEquals(EXPECTED_POSITION_PLAYER_3, positionPlayer3);
	 }

	 @Test
	 public void shouldReturnPlayerStatistics() {
		 // given
		 playerStats.init();
		 Long playerId=1L;
		 
		 Long EXPECTED_PLAYER_WINS=1L;
		 Long EXPECTED_PLAYER_DRAWS=0L;
		 Long EXPECTED_PLAYER_LOSTS=4L;
		 Long EXPECTED_PLAYER_RANKING_POS=3L;
		 Level EXPECTED_PLAYER_LEVEL=Level.NEWBIE;
	
		 // when
		 StatisticsTO firstPlayerStats=playerStats.showPlayerStats(playerId);
		 Long playerWins=firstPlayerStats.getWinGames();
		 Long playerDraws=firstPlayerStats.getDrawGames();
		 Long playerLosts=firstPlayerStats.getLostGames();
		 Long playerRankPos=firstPlayerStats.getPlaceRanking();
		 Level playerLevel=firstPlayerStats.getPlayerLevel();
	
		 // then
		 assertEquals(EXPECTED_PLAYER_WINS, playerWins);
		 assertEquals(EXPECTED_PLAYER_DRAWS, playerDraws);
		 assertEquals(EXPECTED_PLAYER_LOSTS, playerLosts);
		 assertEquals(EXPECTED_PLAYER_RANKING_POS, playerRankPos);
		 assertEquals(EXPECTED_PLAYER_LEVEL, playerLevel);
	 }

}
