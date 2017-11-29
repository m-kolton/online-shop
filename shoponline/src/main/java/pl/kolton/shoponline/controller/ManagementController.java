package pl.kolton.shoponline.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pl.kolton.shopbackend.dao.CategoryDAO;
import pl.kolton.shopbackend.dao.ProductDAO;
import pl.kolton.shopbackend.dto.Category;
import pl.kolton.shopbackend.dto.Product;
import pl.kolton.shoponline.util.FileUploadUtility;
import pl.kolton.shoponline.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Zarz¹dzaj");

		Product nProduct = new Product();
		// Set fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);
		
		if(operation!=null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Produkt zosta³ dodany prawid³owo!  ");
			} else if(operation.equals("category")) {
				mv.addObject("message", "Kategoria zosta³a dodana prawid³owo!  ");
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Zarz¹dzaj");

		
		Product nProduct = productDAO.get(id);

		mv.addObject("product", nProduct);
				
		return mv;
	}
	
	//Handling product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, HttpServletRequest request) {
		
		if(mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		} else {
			if(!mProduct.getFile().getOriginalFilename().equals(""))
				new ProductValidator().validate(mProduct, results);
		}
		
		//Check for errors
		if(results.hasErrors()) {
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Zarz¹dzaj");
			model.addAttribute("message", "Uzupe³nij poprawnie wszystkie pola i spróbuj ponownie");
			
			return "page";
		}
		
		logger.info(mProduct.toString());
		
		
		
		//Create a new product if ID = 0
		if(mProduct.getId() == 0) {
			productDAO.add(mProduct);
		}
		//Update product if ID != 0
		else {
			productDAO.update(mProduct);
		}
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return"redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		//fetting product from database
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		//activating/deactivating product
		product.setActive(!product.isActive());
		
		productDAO.update(product);
		
		return (isActive)? "Deaktywowa³eœ produkt o ID: " + product.getId() :
			               "Aktywowa³eœ produkt o ID: " + product.getId();
	}
	
	//Handle category submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		
		categoryDAO.add(category);
		return "redirect:/manage/products/?operation=category";
	}
	
	
	
	//Return list of categories
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
}
