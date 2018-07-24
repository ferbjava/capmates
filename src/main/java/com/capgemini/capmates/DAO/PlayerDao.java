package com.capgemini.capmates.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.capgemini.capmates.Entities.Game;
import com.capgemini.capmates.Entities.Player;

@Repository
public class PlayerDao {
	private static Map <Integer, Player> players;
	
	static {
		players= new HashMap<Integer, Player>(){
			{
				put(1, new Player(1,"Jan", "Kowalski", "jan.kowalski@gmail.com","admin1234", "amdg", new ArrayList<Game>() ));
				put(2, new Player(2, "Andrzej", "Nowak", "andrzej.nowak@gmail.com","andrzejKing", "Pantha rei", new ArrayList<Game>() ));
				put(3, new Player(3, "Anna", "Wisniewska", "anna.wisniewska@gmail.com","Qwerty", "yolo", new ArrayList<Game>() ));
			}
		};
	}
	
	public Collection<Player> getAllPlayers(){
		return this.players.values();
	}
	
	public Player getPlayerById(Integer id){
		return this.players.get(id);
	}
}
