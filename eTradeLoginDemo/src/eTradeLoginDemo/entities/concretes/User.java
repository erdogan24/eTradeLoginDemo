package eTradeLoginDemo.entities.concretes;

import eTradeLoginDemo.entities.abstracts.Entity;

public class User implements Entity {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public User() {

	}

	public User(int id, String firstName, String lastName, String gmail, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = gmail;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getGmail() {
		return email;
	}

	public void setGmail(String gmail) {
		this.email = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
