package pl.kolton.shoponline.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import pl.kolton.shopbackend.dao.UserDAO;
import pl.kolton.shopbackend.dto.Address;
import pl.kolton.shopbackend.dto.Cart;
import pl.kolton.shopbackend.dto.User;
import pl.kolton.shoponline.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init() {
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address address) {
		registerModel.setBilling(address);
	}
	
	public String validateUser(User user, MessageContext error) {
		
		String transitionValue = "success";
		
		//Check if password match confirmPassword
		if(!(user.getPassword().equals(user.getConfirmPassword()))) {
			
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Wpisz i powtórz poprawnie has³o!")
					.build()
					);
			transitionValue = "failure";
		}
		
		if(userDAO.getByEmail(user.getEmail()) != null) {
			
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Podany email jest ju¿ zajêty!")
					.build()
					);
			
			transitionValue = "failure";
		}
		
		return transitionValue;
	}
	
	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		
		//Fetch user
		User user = model.getUser();
		
		if(user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//Encode password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		//Save user
		userDAO.addUser(user);
		
		//Get address
		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		
		userDAO.addAddress(billing);
		return transitionValue;
	}
}
