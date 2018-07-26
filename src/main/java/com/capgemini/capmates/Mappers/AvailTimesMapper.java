package com.capgemini.capmates.Mappers;


import java.time.LocalTime;

import org.springframework.stereotype.Component;
import com.capgemini.capmates.Entities.AvailTime;
import com.capgemini.capmates.TO.AvailTimeTO;

@Component
public class AvailTimesMapper {
	
	public AvailTime mapFieldsToNewAvailTime(long availTimeId, int playerId, LocalTime start, LocalTime stop){
		AvailTime newAvailTime= new AvailTime(availTimeId, playerId, start, stop, "Active", "");
		return newAvailTime;
	}

	public AvailTime tOmappedToAvailTime(long id, AvailTimeTO availTimeTO) {
		Integer playerId=availTimeTO.getPlayerId();
		LocalTime start=availTimeTO.getStart();
		LocalTime stop=availTimeTO.getStop();
		String status=availTimeTO.getStatus();
		String comment=availTimeTO.getComment();
		AvailTime newAvailTime=new AvailTime(id, playerId, start, stop, status, comment);
		return newAvailTime;
	}

	public AvailTimeTO availTimeMappedToTO(AvailTime time) {
		int playerId=time.getPlayerId();
		LocalTime start=time.getStart();
		LocalTime stop=time.getStop();
		String status=time.getStatus();
		String comment=time.getComment();
		AvailTimeTO timeTO=new AvailTimeTO(playerId, start, stop, status, comment);
		return timeTO;
	}
}
