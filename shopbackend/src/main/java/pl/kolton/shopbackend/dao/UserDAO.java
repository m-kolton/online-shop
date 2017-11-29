package pl.kolton.shopbackend.dao;

import java.util.List;

import pl.kolton.shopbackend.dto.Address;
import pl.kolton.shopbackend.dto.Cart;
import pl.kolton.shopbackend.dto.User;

public interface UserDAO {

	// Method for adding users
	boolean addUser(User user);

	User getByEmail(String email);

	// Method for adding address
	boolean addAddress(Address address);

	/*
	 * Alternative:
	 * Address getBillingAddress(int userId);
	 * List<Address> listShippingAddresses(int userId);
	 * */
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);

	// Method for updating to cart
	boolean updateCart(Cart cart);
}
