package com.capgemini.capmates.Service;

import java.util.ArrayList;

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

	public PlayerProfileTO showPlayerProfile(Integer id) {
		Player playerEntity = playersDao.getPlayerById(id);
		return playerMapper.entityToTO(playerEntity);
	}

	public void editPlayerProfile(PlayerProfileTO playerTO) {
		playersDao.editPlayerProfile(playerTO);
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
