package com.capgemini.capmates.DAO;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import com.capgemini.capmates.Entities.Game;

@Repository
public class GamesDao {
	private Set<Game> availableGames;
	private AtomicLong gameId;
	
	public GamesDao(){
		availableGames=new HashSet<Game>();
		gameId=new AtomicLong();
	}

	@PostConstruct
	public void init(){
		availableGames.clear();
		gameId.set(0);
		availableGames.add(new Game(gameId.getAndIncrement(),"Monopoly", 2, 6));
		availableGames.add(new Game(gameId.getAndIncrement(),"Rummikub", 2, 4));
		availableGames.add(new Game(gameId.getAndIncrement(),"Sabotazysta", 3, 10));
		availableGames.add(new Game(gameId.getAndIncrement(),"Pandemia", 2, 4));
		availableGames.add(new Game(gameId.getAndIncrement(),"Carcassone", 2, 6));
	}
	
	public boolean contain(Game gameName){
		
		return this.availableGames.contains(gameName);
	}
	
	public void addGameToCollection(Game gameName){
		this.availableGames.add(gameName);
	}
	
	public HashSet<Game> showGamesInRepo(){
		return (HashSet<Game>)availableGames;
	}
	
	public Game getOrAddGame(String gameName, int minPlayers, int maxPlayers){
		for(Game game:availableGames){
			if(game.getGameName().equals(gameName)&&game.getMinPlayers()==minPlayers&&game.getMaxPlayers()==maxPlayers){
				return game;
			}
		}
		Game newGame=new Game(gameId.getAndIncrement(), gameName, minPlayers, maxPlayers);
		this.availableGames.add(newGame);
		return newGame;
	}
	
}
