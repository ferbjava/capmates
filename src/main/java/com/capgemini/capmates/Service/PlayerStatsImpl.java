package com.capgemini.capmates.Service;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capmates.DAO.GameLogDao;
import com.capgemini.capmates.Enums.PlayerRank;
import com.capgemini.capmates.Mappers.GameLogMapper;
import com.capgemini.capmates.TO.GameLogTO;
import com.capgemini.capmates.TO.RankPositionTO;

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

	public ArrayList<GameLogTO> showPlayerHistory(long playerId) {
		ArrayList<GameLogTO> playerGames = new ArrayList<GameLogTO>();
		playerGames.addAll(gameLogDao.showPlayerGames(playerId));
		return playerGames;
	}

	public ArrayList<GameLogTO> showAllGames(long playerId) {
		ArrayList<GameLogTO> allGames = new ArrayList<GameLogTO>();
		allGames.addAll(gameLogDao.showAllGames());
		return allGames;
	}

	public HashSet<Long> showActivePlayersId() {
		return gameLogDao.playersId();
	}

	public ArrayList<RankPositionTO> createRanking() {
		ArrayList<RankPositionTO> ranking = new ArrayList<RankPositionTO>();
		for (long playerId : showActivePlayersId()) {
			ArrayList<GameLogTO> playerGames = showPlayerHistory(playerId);
			Long points=showPlayerPoints(playerGames);
			ranking.add(new RankPositionTO(points, playerId));
		}
		ranking.sort(new RankPositionTO.PointsComparator());
		return ranking;
	}
	
	public int showRankingPosition(Long playerId){
		ArrayList<RankPositionTO>ranking=createRanking();
		for(int i=0;i<ranking.size();i++){
			if(ranking.get(i).getPlayerId()==playerId){
				return ++i;
			}
		}
		return -1;
	}
	
	public PlayerRank showPlayerRank(long playerId){
		ArrayList<GameLogTO> playerGames=showPlayerHistory(playerId);
		Long playerPoints=showPlayerPoints(playerGames);
		return PlayerRank.getRankByValue(playerPoints);
	}

	//private methods
	private Long showPlayerPoints(ArrayList<GameLogTO> playerGames) {
		Long points = 0L;
		for (GameLogTO game : playerGames) {
			points += game.getResult().getScores();
		}
		return points;
	}

}
