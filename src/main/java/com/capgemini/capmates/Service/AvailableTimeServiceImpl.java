package com.capgemini.capmates.Service;

import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capmates.DAO.AvailTimesDao;
import com.capgemini.capmates.Mappers.AvailTimesMapper;
import com.capgemini.capmates.TO.AvailTimeTO;

@Service
public class AvailableTimeServiceImpl {
	private AvailTimesDao availTimesDao;
	private AvailTimesMapper availTimesMapper;

	@Autowired
	public AvailableTimeServiceImpl(AvailTimesDao availTimesDao, AvailTimesMapper availTimesMapper) {
		this.availTimesDao = availTimesDao;
		this.availTimesMapper = availTimesMapper;
	}
	
	public void init(){
		availTimesDao.init();
	}
	
	public void newAvailTime(AvailTimeTO availTimeTO){
		long newAvailTimeId=availTimesDao.availTimesNextId();
		availTimesDao.addNewAvailTime(availTimesMapper.tOmappedToAvailTime(newAvailTimeId, availTimeTO));
	}
	
	public ArrayList<AvailTimeTO> showPlayerTimes(Integer playerId){
		return availTimesDao.showPlayerTimes(playerId);
	}
	
	public void editAvailTime(Integer playerId, LocalTime start, LocalTime stop){
		
	}
	
}
