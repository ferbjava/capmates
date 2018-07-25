package com.capgemini.capmates.DAO;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import com.capgemini.capmates.Entities.Game;

@Repository
public class GamesDao {
//	private static Set<Game> availableGames;
	private Set<Game> availableGames;
	
	public GamesDao(){
		availableGames=new HashSet<Game>();
	}

//	static {
//		availableGames = new HashSet<Game>() {
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = -3419453957260971906L;
//
//			{
//				availableGames.add(new Game("Monopoly", 2, 6));
//				availableGames.add(new Game("Rummikub", 2, 4));
//				availableGames.add(new Game("Sabotazysta", 3, 10));
//				availableGames.add(new Game("Pandemia", 2, 4));
//				availableGames.add(new Game("Carcassone", 2, 6));
//			}
//		};
//	}
	@PostConstruct
	public void init(){
		availableGames.clear();
		availableGames.add(new Game("Monopoly", 2, 6));
		availableGames.add(new Game("Rummikub", 2, 4));
		availableGames.add(new Game("Sabotazysta", 3, 10));
		availableGames.add(new Game("Pandemia", 2, 4));
		availableGames.add(new Game("Carcassone", 2, 6));
	}
	
	public boolean contain(Game gameName){
		return this.availableGames.contains(gameName);
	}
	
	public void addGameToCollection(Game gameName){
		this.availableGames.add(gameName);
	}
	
	
}
