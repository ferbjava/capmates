package com.capgemini.capmates.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.capgemini.capmates.Entities.Game;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.Mappers.GamesMapper;
import com.capgemini.capmates.Mappers.PlayerProfileMapper;
import com.capgemini.capmates.TO.GameTO;
import com.capgemini.capmates.TO.PlayerProfileTO;

@Repository
public class PlayerDao {
	private Map<Integer, Player> players;
	private PlayerProfileMapper profileMapper;
	private GamesMapper gamesMapper;

	public PlayerDao() {
		players = new HashMap<Integer, Player>();
		profileMapper = new PlayerProfileMapper();
		gamesMapper = new GamesMapper();

	}

	public void init() {
		players.clear();
		players.put(1, new Player(1, "Jan", "Kowalski", "jan.kowalski@gmail.com", "admin1234", "amdg",
				new ArrayList<Game>()));
		players.put(2, new Player(2, "Andrzej", "Nowak", "andrzej.nowak@gmail.com", "andrzejKing", "Pantha rei",
				new ArrayList<Game>()));
		players.put(3, new Player(3, "Anna", "Wisniewska", "anna.wisniewska@gmail.com", "Qwerty", "yolo",
				new ArrayList<Game>()));
		players.put(4, new Player(4, "Jan", "Psikuta", "jan.psikuta@gmail.com", "admin1234", "ktz",
				new ArrayList<Game>()));
	}

	public ArrayList<PlayerProfileTO> getAllPlayersProfiles() {
		ArrayList<PlayerProfileTO> playersProfilesTO = new ArrayList<>();
		for (int i = 1; i <= players.size(); i++) {
			playersProfilesTO.add(profileMapper.entityToTO(players.get(i)));
		}
		return playersProfilesTO;
	}

	public Player getPlayerById(Integer id) {
		return this.players.get(id);
	}

	public PlayerProfileTO getPlayerToById(Integer id) {
		return profileMapper.entityToTO(this.players.get(id));
	}

	public void editPlayerProfile(PlayerProfileTO profileTO) {
		int id = profileTO.getId();
		ArrayList<Game> recentGames = players.get(id).getPlayerGames();
		Player updatedPlayer = profileMapper.toToEntity(profileTO, recentGames);
		players.put(id, updatedPlayer);
	}

	public void setPlayerFirstName(Integer id, String firstName) {
		players.get(id).setFirstName(firstName);
	}

	public void setPlayerLastName(Integer id, String lastName) {
		players.get(id).setLastName(lastName);
	}

	public void setPlayerEmail(Integer id, String email) {
		players.get(id).setEmail(email);
	}

	public void setPlayerPassword(Integer id, String password) {
		players.get(id).setPassword(password);
	}

	public void setPlayerLifeMotto(Integer id, String lifeMotto) {
		players.get(id).setLifeMotto(lifeMotto);
	}

	// methods for player games
	public void addPlayerGame(Integer id, GameTO gameTO) {
		boolean contain = false;
		for (Game testGame : this.players.get(id).getPlayerGames()) {
			if (testGame.equals(gamesMapper.toToEntity(gameTO))) {
				contain = true;
			}
		}
		if (!contain) {
			this.players.get(id).addGame(gamesMapper.toToEntity(gameTO));
		}
	}

	public void removePlayerGame(Integer playerId, GameTO gameToRemove) {
		for (Game game : players.get(playerId).getPlayerGames()) {
			if (game.equals(gamesMapper.toToEntity(gameToRemove))) {
				players.get(playerId).getPlayerGames().remove(gamesMapper.toToEntity(gameToRemove));
				return;
			}
		}
	}

}
