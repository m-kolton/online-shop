package pl.kolton.shopbackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="user_detail")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/* 
	 * Private fields for user
	 * */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	@NotBlank(message="Proszę podać imię")
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank(message="Proszę podać nazwisko")
	private String lastName;
	
	@NotBlank(message="Proszę podać adres email")
	private String email;
	
	@NotBlank(message="Proszę podać numer telefonu")
	@Column(name="contact_number")
	private String contactNumber;
	
	private String role;
	
	@NotBlank(message="Proszę podać hasło")
	private String password;
	
	@Transient
	@NotBlank(message="Proszę powtórzyć hasło")
	private String confirmPassword;

	private boolean enabled = true;
	
	//Each user has cart
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	/*
	 * Setters and getters
	 * */
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	/*
	 * toString() overridden method
	 * */
	
	@Override
	public String toString() {
		return "User [id=" + id + ", " + (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (contactNumber != null ? "contactNumber=" + contactNumber + ", " : "")
				+ (role != null ? "role=" + role + ", " : "") + (password != null ? "password=" + password + ", " : "")
				+ "enabled=" + enabled + "]";
	}	
}
