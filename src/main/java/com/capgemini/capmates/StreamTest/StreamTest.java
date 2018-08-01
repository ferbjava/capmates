package com.capgemini.capmates.StreamTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.capmates.TO.PlayerProfileTO;

public class StreamTest {

	public static void main(String[] args) {
		ArrayList<PlayerProfileTO>profiles=new ArrayList<PlayerProfileTO>();
		profiles.add(new PlayerProfileTO(0, "Jan", "Kowalski", "jan.kowalski@gmail.com", "admin1234", "kmwtw"));
		profiles.add(new PlayerProfileTO(1, "Andrzej", "Nowak", "andrzej.nowak@gmail.com", "andrzejKing", "Pantha rei"));
		profiles.add(new PlayerProfileTO(2, "Anna", "Wisniewska", "anna.wisniewska@gmail.com", "Qwerty", "yolo"));
		profiles.add(new PlayerProfileTO(3, "Jan", "Duda", "jan.duda@gmail.com", "kochamMame", "NSNP"));
		profiles.add(new PlayerProfileTO(4, "Jan", "Psikuta", "jan.psikuta@gmail.com", "admin1234", "ktz"));
		
		System.out.println("Lista poczatkowa:");
		profiles.stream().forEach(profile->System.out.println(profile.toString()));
		System.out.println();
	
		PlayerProfileTO filter=new PlayerProfileTO(null, "Jan", null, null, "admin1234", null);

		System.out.println("Obiekt filtrujacy:");
		System.out.println(filter.toString());
		System.out.println();

		String filterFirstName=filter.getFirstName();
		String filterLastName=filter.getLastName();
		String filterEmail=filter.getEmail();
		String filterPassword=filter.getPassword();
		String filterLifeMotto=filter.getLifeMotto();
		

		List<PlayerProfileTO> filteredProfiles=new ArrayList<PlayerProfileTO>();
		filteredProfiles.addAll(profiles);
		
		if(filterFirstName!=null){
			filteredProfiles=filteredProfiles.stream().filter(profile->profile.getFirstName().equals(filterFirstName)).collect(Collectors.toList());
		}
		if(filterLastName!=null){
			filteredProfiles=filteredProfiles.stream().filter(profile->profile.getLastName().equals(filterLastName)).collect(Collectors.toList());
		}
		if(filterEmail!=null){
			filteredProfiles=filteredProfiles.stream().filter(profile->profile.getEmail().equals(filterEmail)).collect(Collectors.toList());
		}
		if(filterPassword!=null){
			filteredProfiles=filteredProfiles.stream().filter(profile->profile.getPassword().equals(filterPassword)).collect(Collectors.toList());
		}
		if(filterLifeMotto!=null){
			filteredProfiles=filteredProfiles.stream().filter(profile->profile.getLifeMotto().equals(filterLifeMotto)).collect(Collectors.toList());
		}
		
		System.out.println("Lista po filtracji:");
		filteredProfiles.stream().forEach(profile->System.out.println(profile.toString()));
		System.out.println();
	}

}
