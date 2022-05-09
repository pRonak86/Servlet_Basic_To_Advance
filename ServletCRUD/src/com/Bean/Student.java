package com.Bean;

public class Student {
	
	private  int id;
	private String name;
	private int contact;
	private String email;
	private String city;
	//now we create getter or setter method of all variable 
	//Setter method --> what data from front end -- > value set --> inside your variable directly
	//getter -.. whatever value set  by setter method will be fetch by getter method 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
