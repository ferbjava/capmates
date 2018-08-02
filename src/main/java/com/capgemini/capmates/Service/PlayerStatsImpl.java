package com.capgemini.capmates.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capmates.DAO.GameLogDao;
import com.capgemini.capmates.Enums.Level;
import com.capgemini.capmates.Enums.Result;
import com.capgemini.capmates.Mappers.GameLogMapper;
import com.capgemini.capmates.TO.GameLogTO;
import com.capgemini.capmates.TO.RankingTO;
import com.capgemini.capmates.TO.StatisticsTO;

@Service
public class PlayerStatsImpl {

	private GameLogDao gameLogDao;

	@Autowired
	public PlayerStatsImpl(GameLogDao gameLogDao, GameLogMapper gameLogMapper) {
		this.gameLogDao = gameLogDao;
	}

	public void init() {
		gameLogDao.init();
	}

	public ArrayList<GameLogTO> showAllGames(long playerId) {
		ArrayList<GameLogTO> allGames = new ArrayList<GameLogTO>();
		allGames.addAll(gameLogDao.showAllGames());
		return allGames;
	}

	public ArrayList<GameLogTO> showPlayerHistory(long playerId) {
		ArrayList<GameLogTO> playerGames = new ArrayList<GameLogTO>();
		playerGames.addAll(gameLogDao.showPlayerGames(playerId));
		return playerGames;
	}

	public HashSet<Long> showActivePlayersId() {
		return gameLogDao.playersId();
	}

	public ArrayList<RankingTO> createRanking() {
		ArrayList<RankingTO> ranking = new ArrayList<RankingTO>();
		for (long playerId : showActivePlayersId()) {
			ArrayList<GameLogTO> playerGames = showPlayerHistory(playerId);
			Long points=showPlayerPoints(playerGames);
			ranking.add(new RankingTO(points, playerId));
		}
		ranking.sort(new RankingTO.PointsComparator());
		return ranking;
	}
	
	public int showRankingPosition(Long playerId){
		ArrayList<RankingTO>ranking=createRanking();
		for(int i=0;i<ranking.size();i++){
			if(ranking.get(i).getPlayerId()==playerId){
				return ++i;
			}
		}
		return -1;
	}
	
	public Level showPlayerLevel(long playerId){
		ArrayList<GameLogTO> playerGames=showPlayerHistory(playerId);
		Long playerPoints=showPlayerPoints(playerGames);
		return Level.getLevelByValue(playerPoints);
	}
	
	public StatisticsTO showPlayerStats(long playerId){
		StatisticsTO playerStats=new StatisticsTO();
		ArrayList<GameLogTO>playerGames=showPlayerHistory(playerId);
		long playerWins=showWins(playerGames);
		long playerDraws=showDraws(playerGames);
		long playerLosts=showLost(playerGames);
		long playerRanking=showRankingPosition(playerId);
		Level playerLevel=showPlayerLevel(playerId);
		playerStats.setPlayerId(playerId);
		playerStats.setWinGames(playerWins);
		playerStats.setDrawGames(playerDraws);
		playerStats.setLostGames(playerLosts);
		playerStats.setPlaceRanking(playerRanking);
		playerStats.setPlayerLevel(playerLevel);		
		return playerStats;
	}

	//private methods
	private Long showPlayerPoints(ArrayList<GameLogTO> playerGames) {
		Long points = 0L;
		for (GameLogTO game : playerGames) {
			points += game.getResult().getScores();
		}
		return points;
	}

	private long showWins(ArrayList<GameLogTO> games) {
		return games.stream().filter(g->g.getResult().equals(Result.WIN)).collect(Collectors.toList()).size();
	}

	private long showDraws(ArrayList<GameLogTO> games) {
		return games.stream().filter(g->g.getResult().equals(Result.DRAW)).collect(Collectors.toList()).size();
	}

	private long showLost(ArrayList<GameLogTO> games) {
		return games.stream().filter(g->g.getResult().equals(Result.LOSS)).collect(Collectors.toList()).size();
	}

}
