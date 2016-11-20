package models;

import enumerations.UserType;

public class User {
	
	private int id;
	private String name;
	private String username;
	private String password;
	private UserType userType;
	private String address;
	private String email;
	private String mobilePhone;
	private String homePhone;

	public User(int id, String name, String username, String password, UserType userType, String address, String email, String mobilePhone, String homePhone) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.address = address;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.homePhone = homePhone;
	}


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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	
}
