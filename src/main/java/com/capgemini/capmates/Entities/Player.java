package com.capgemini.capmates.Entities;

import java.util.ArrayList;

public class Player {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String lifeMotto;
	private ArrayList<Game> playerGames;

	public Player(Integer id, String firstName, String lastName, String email, String password, String lifeMotto,
			ArrayList<Game> playerGames) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setLifeMotto(lifeMotto);
		setPlayerGames(playerGames);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLifeMotto() {
		return lifeMotto;
	}

	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}

	public ArrayList<Game> getPlayerGames() {
		return playerGames;
	}

	public void setPlayerGames(ArrayList<Game> playerGames) {
		this.playerGames = playerGames;
	}

	public void addGame(Game newGame) {
		this.playerGames.add(newGame);
	}

}
