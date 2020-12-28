/**
 * 
 */
package com.app.sellerconsumer.DTO;

/**
 * @author ashwini.eksambekar
 *
 */
public class UserDTO {

	private String username;
	private int userID;
	private String role;// profile selected seller or consumer
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
