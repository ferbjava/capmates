package com.capgemini.capmates.DAO;

import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.capgemini.capmates.Entities.AvailTime;

@Repository
public class AvailTimesDao {
	private ArrayList<AvailTime> availableTimes;
	
	public AvailTimesDao() {
		availableTimes=new ArrayList<AvailTime>();
	}
	
	public void init(){
		availableTimes.clear();
		availableTimes.add(new AvailTime(1, LocalTime.of(10, 30), LocalTime.of(12, 30), "Active", null));
		availableTimes.add(new AvailTime(1, LocalTime.of(16, 00), LocalTime.of(18, 00), "Active", null));
		availableTimes.add(new AvailTime(2, LocalTime.of(11, 00), LocalTime.of(13, 00), "Active", null));
		availableTimes.add(new AvailTime(2, LocalTime.of(17, 30), LocalTime.of(19, 30), "Active", null));
		availableTimes.add(new AvailTime(3, LocalTime.of(10, 00), LocalTime.of(12, 00), "Active", null));
		availableTimes.add(new AvailTime(3, LocalTime.of(18, 30), LocalTime.of(21, 00), "Active", null));
	}
}
