package com.capgemini.capmates;

import java.util.ArrayList;
import java.util.List;
import com.capgemini.capmates.Entities.Game;

public class ConsoleTests {

	public static void main(String[] args) {
		List<Game>games=new ArrayList<Game>();
		games.add(new Game(1, "pierwsza", 2,4));
		games.add(new Game(2, "druga", 2,4));
		games.add(new Game(3, "trzecia", 2,4));
		games.add(new Game(4, "czwarta", 2,4));
		
		List<Game>gamesCopy=games;
		
		System.out.println("Elementy pierwszej listy");
		for(Game game:games){
			System.out.println(game.toString());
		}
		System.out.println();
		
		System.out.println("Elementy drugiej listy");
		for(Game game:gamesCopy){
			System.out.println(game.toString());
		}
		System.out.println();
		
		games.remove(0);

		System.out.println("Usunieto pierwszy element y pierwszej listy");
		System.out.println("Elementy pierwszej listy");
		for(Game game:games){
			System.out.println(game.toString());
		}
		System.out.println();
		
		System.out.println("Elementy drugiej listy");
		for(Game game:gamesCopy){
			System.out.println(game.toString());
		}
		System.out.println();
		
	}
}
