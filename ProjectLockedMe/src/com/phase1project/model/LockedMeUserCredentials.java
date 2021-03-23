package com.phase1project.model;

public class LockedMeUserCredentials {

	private String siteName;
	private String  signedInUser;
	private String username;
	private String password;
	
	public LockedMeUserCredentials(String siteName, String signedInUser, String username, String password) {
		
		this.siteName = siteName;
		this.signedInUser = signedInUser;
		this.username = username;
		this.password = password;
	}

	public LockedMeUserCredentials() {
		
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSignedInUser() {
		return signedInUser;
	}

	public void setSignedInUser(String signedInUser) {
		this.signedInUser = signedInUser;
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
	
	
	@Override
	public String toString() {
		return "UserCredentials [siteName=" + siteName + 
				", loggedInUser=" + signedInUser + 
				", username=" + username
				+ ", password=" + password + "]";
	}
	
	
}