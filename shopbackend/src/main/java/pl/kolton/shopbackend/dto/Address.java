package pl.kolton.shopbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	/*
	 * Private fields
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Many adresses may belong to one user
	@ManyToOne
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "address_line_one")
	private String addressLineOne;
	@Column(name = "address_line_two")
	private String addressLineTwo;
	private String city;
	private String state;
	private String country;
	@Column(name = "postal_code")
	private String postalCode;
	private boolean billing;
	private boolean shipping;

	/*
	 * Setters and getters
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	/*
	 * toString() method
	 */

	@Override
	public String toString() {
		return "Address [id=" + id + ", " + (addressLineOne != null ? "addressLineOne=" + addressLineOne + ", " : "")
				+ (addressLineTwo != null ? "addressLineTwo=" + addressLineTwo + ", " : "")
				+ (city != null ? "city=" + city + ", " : "") + (state != null ? "state=" + state + ", " : "")
				+ (country != null ? "country=" + country + ", " : "")
				+ (postalCode != null ? "postalCode=" + postalCode + ", " : "") + "billing=" + billing + ", shipping="
				+ shipping + "]";
	}

}
