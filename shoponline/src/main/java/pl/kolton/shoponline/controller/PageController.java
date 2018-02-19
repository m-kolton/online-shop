package pl.kolton.shoponline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.kolton.shopbackend.dao.CategoryDAO;
import pl.kolton.shopbackend.dao.ProductDAO;
import pl.kolton.shopbackend.dto.Category;
import pl.kolton.shopbackend.dto.Product;
import pl.kolton.shoponline.exception.ProductNotFoundException;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	// Strona g³ówna
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Strona g³ówna");
		
		logger.info("Inside PageController /index - INFO");
		logger.debug("Inside PageController /index - DEBUG");
		
		// Passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickHome", true);
		return mv;
	}

	// O nas
	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "O nas");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	// Kontakt
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Kontakt");
		mv.addObject("userClickContact", true);
		return mv;
	}

	// Loading all products
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Produkty");

		// Passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	// Loading products by category
	// Loading all products
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");

		// Fetching a single category
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());

		// Passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		// Passing the single category
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	//Single product page
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		//View counter update
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
		
	}
	
	//Login
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name = "error", required = false) String error,
							  @RequestParam(name = "logout", required = false) String logout) {
		
		ModelAndView mv = new ModelAndView("login");
			
		if(error != null) {
			mv.addObject("message", "B³êdna nazwa u¿ytkowanika i has³o!");
		}
		
		if(logout != null) {
			mv.addObject("logout", "Zosta³eœ poprawnie wylogowany!");
		}
		
		mv.addObject("title", "Zaloguj siê");
			
		return mv;
	}
		
	//Access denied
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "Aha! Mamy ciê!");
		mv.addObject("errorDescription", "Nie posiadasz uprawnieñ dostêpu do tej strony");
		return mv;
	}
	
	//Logout
	@RequestMapping(value = "/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		//Fetch authentication
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}
	
}
