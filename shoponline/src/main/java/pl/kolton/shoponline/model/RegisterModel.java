package pl.kolton.shoponline.model;

import java.io.Serializable;

import pl.kolton.shopbackend.dto.Address;
import pl.kolton.shopbackend.dto.User;

public class RegisterModel implements Serializable {


	private static final long serialVersionUID = 1L;

	/*
	 * Private fields
	 * */
	private User user;
	private Address billing;
	
	/*
	 * Setters and getters
	 * */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}
}
