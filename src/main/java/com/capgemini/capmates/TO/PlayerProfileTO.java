package com.capgemini.capmates.TO;

public class PlayerProfileTO {
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String lifeMotto;

	public PlayerProfileTO() {

	}

	public PlayerProfileTO(Integer id, String firstName, String lastName, String email, String password,
			String lifeMotto) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setLifeMotto(lifeMotto);
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

	public String getLifeMotto() {
		return lifeMotto;
	}

	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PlayerProfileTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", lifeMotto=" + lifeMotto + "]";
	}
	
}
