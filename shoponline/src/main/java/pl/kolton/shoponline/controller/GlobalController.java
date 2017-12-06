package pl.kolton.shoponline.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.kolton.shopbackend.dao.UserDAO;
import pl.kolton.shopbackend.dto.User;
import pl.kolton.shoponline.model.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if(session.getAttribute("userModel")==null) {
			//Add user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userDAO.getByEmail(authentication.getName());
			
			if(user!=null) {
				//Create new user model
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				
				if(userModel.getRole().equals("USER")) {
					
					//Set cart only if user is client
					userModel.setCart(user.getCart());
				}
				
				//Set userModel in session
				session.setAttribute("userModel", userModel);
			}
			
		}
		return (UserModel) session.getAttribute("userModel");
	}
}
