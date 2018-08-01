package com.capgemini.capmates.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capmates.DAO.PlayerDao;
import com.capgemini.capmates.Entities.Player;
import com.capgemini.capmates.Mappers.PlayerProfileMapper;
import com.capgemini.capmates.TO.PlayerProfileTO;

@Service
public class PlayerProfileServiceImpl {

	private PlayerProfileMapper playerMapper;
	private PlayerDao playersDao;

	@Autowired
	public PlayerProfileServiceImpl(PlayerProfileMapper playerMapper, PlayerDao playersDao) {
		this.playerMapper = playerMapper;
		this.playersDao = playersDao;
	}

	@PostConstruct
	public void initDao() {
		playersDao.init();
	}

	public ArrayList<PlayerProfileTO> showAllPlayersProfiles() {
		return playersDao.getAllPlayersProfiles();
	}

	public int showPlayersNumber() {
		return showAllPlayersProfiles().size();
	}

	public PlayerProfileTO showPlayerProfile(Integer id) {
		Player playerEntity = playersDao.getPlayerById(id);
		return playerMapper.entityToTO(playerEntity);
	}

	public void editPlayerProfile(PlayerProfileTO playerTO) {
		playersDao.editPlayerProfile(playerTO);
	}

	public List<PlayerProfileTO> showFilteredProfiles(PlayerProfileTO filter) {
		List<PlayerProfileTO> filteredProfiles = new ArrayList<PlayerProfileTO>();
		filteredProfiles = playersDao.getAllPlayersProfiles();
		if (filter.getFirstName() != null) {
			filteredProfiles = filteredProfiles.stream().filter(p -> p.getFirstName().equals(filter.getFirstName()))
					.collect(Collectors.toList());
		}
		if (filter.getLastName() != null) {
			filteredProfiles = filteredProfiles.stream().filter(p -> p.getLastName().equals(filter.getLastName()))
					.collect(Collectors.toList());
		}
		if (filter.getEmail() != null) {
			filteredProfiles = filteredProfiles.stream().filter(p -> p.getEmail().equals(filter.getEmail()))
					.collect(Collectors.toList());
		}
		if (filter.getPassword() != null) {
			filteredProfiles = filteredProfiles.stream().filter(p -> p.getPassword().equals(filter.getPassword()))
					.collect(Collectors.toList());
		}
		if (filter.getLifeMotto() != null) {
			filteredProfiles = filteredProfiles.stream().filter(p -> p.getLifeMotto().equals(filter.getLifeMotto()))
					.collect(Collectors.toList());
		}
		return filteredProfiles;
	}

	
	public String getPlayerFirstName(Integer id) {
		PlayerProfileTO playerTO = playersDao.getPlayerToById(id);
		return playerTO.getFirstName();
	}

	public String getPlayerLastName(Integer id) {
		PlayerProfileTO playerTO = playersDao.getPlayerToById(id);
		return playerTO.getLastName();
	}

	public String getPlayerEmail(Integer id) {
		PlayerProfileTO playerTO = playersDao.getPlayerToById(id);
		return playerTO.getEmail();
	}

	public String getPlayerPassword(Integer id) {
		PlayerProfileTO playerTO = playersDao.getPlayerToById(id);
		return playerTO.getPassword();
	}

	public String getPlayerLifeMotto(Integer id) {
		PlayerProfileTO playerTO = playersDao.getPlayerToById(id);
		return playerTO.getLifeMotto();
	}

	public void setPlayerFirstName(Integer id, String firstName) {
		playersDao.setPlayerFirstName(id, firstName);
	}

	public void setPlayerLastName(Integer id, String lastName) {
		playersDao.setPlayerLastName(id, lastName);
	}

	public void setPlayerEmail(Integer id, String email) {
		playersDao.setPlayerEmail(id, email);
	}

	public void setPlayerPassword(Integer id, String password) {
		playersDao.setPlayerPassword(id, password);
	}

	public void setPlayerLifeMotto(Integer id, String lifeMotto) {
		playersDao.setPlayerLifeMotto(id, lifeMotto);
	}

}
