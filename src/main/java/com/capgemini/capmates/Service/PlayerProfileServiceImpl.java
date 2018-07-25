package com.capgemini.capmates.Service;

import java.util.Collection;

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

	public Collection<Player> getAllPlayers() {
		return playersDao.getAllPlayers();
	}

	public PlayerProfileTO showPlayerProfile(Integer id) {
		Player playerEntity = playersDao.getPlayerById(id);
		
//		String firstName = playerMapper.getPlayerFirstName(playerEntity);
//		String lastName = playerMapper.getPlayerLastName(playerEntity);
//		String email = playerMapper.getPlayerEmail(playerEntity);
//		String password = playerMapper.getPlayerPassword(playerEntity);
//		String motto = playerMapper.getPlayerMotto(playerEntity);
//		return new PlayerProfileTO(id, firstName, lastName, email, password, motto);
		
		return playerMapper.showPlayerProfile(playerEntity);
	}
	
	public String getPlayerFirstName(Integer id){
		Player playerEntity = playersDao.getPlayerById(id);
		return playerMapper.getPlayerFirstName(playerEntity);
	}
	
	public String getPlayerLastName(Integer id){
		Player playerEntity = playersDao.getPlayerById(id);
		return playerMapper.getPlayerLastName(playerEntity);
	}
	
	public String getPlayerEmail(Integer id){
		Player playerEntity = playersDao.getPlayerById(id);
		return playerMapper.getPlayerEmail(playerEntity);
	}
	
	public String getPlayerPassword(Integer id){
		Player playerEntity = playersDao.getPlayerById(id);
		return playerMapper.getPlayerPassword(playerEntity);
	}
	
	public String getPlayerLifeMotto(Integer id){
		Player playerEntity = playersDao.getPlayerById(id);
		return playerMapper.getPlayerMotto(playerEntity);
	}
	
	public void setPlayerFirstName(Integer id, String firstName){
		Player playerEntity = playersDao.getPlayerById(id);
		playerMapper.setPlayerFirstName(playerEntity, firstName);
	}
	
	public void setPlayerLastName(Integer id, String lastName){
		Player playerEntity = playersDao.getPlayerById(id);
		playerMapper.setPlayerLastName(playerEntity, lastName);
	}
	
	public void setPlayerEmail(Integer id, String email){
		Player playerEntity = playersDao.getPlayerById(id);
		playerMapper.setPlayerEmail(playerEntity, email);
	}
	
	public void setPlayerPassword(Integer id, String password){
		Player playerEntity = playersDao.getPlayerById(id);
		playerMapper.setPlayerPassword(playerEntity, password);
	}
	
	public void setPlayerLifeMotto(Integer id, String lifeMotto){
		Player playerEntity = playersDao.getPlayerById(id);
		playerMapper.setPlayerLifeMotto(playerEntity, lifeMotto);
	}
	
	public void initDao(){
		playersDao.init();
	}
	
}
