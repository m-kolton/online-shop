package pl.kolton.shoponline.service;

import java.util.List; 

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kolton.shopbackend.dao.CartLineDAO;
import pl.kolton.shopbackend.dao.ProductDAO;
import pl.kolton.shopbackend.dto.Cart;
import pl.kolton.shopbackend.dto.CartLine;
import pl.kolton.shopbackend.dto.Product;
import pl.kolton.shoponline.model.UserModel;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;
	
	private Cart getCart() {
		
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	public List<CartLine> getCartLines() {
		Cart cart = this.getCart();
		return cartLineDAO.list(cart.getId());
	}

	public String updateCartLine(int cartLineId, int count) {
		
		//Fetch cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		}else {
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			
			if(product.getQuantity() <= count) {
				count = product.getQuantity();
			}	
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice()*count);
			cartLineDAO.update(cartLine);
				
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			
			return "result=updated";
		}
	}

	public String deleteCartLine(int cartLineId) {
		
		//Fetch cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		if(cartLine == null) {
			return "result=error";
		}else {
			//Update cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);
			
			//Remove cart line 
			cartLineDAO.delete(cartLine);
			
			return "result=deleted";
		}
	}

	public String addCartLine(int productId) {
		String response = null;
		
		Cart cart = this.getCart();
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		if(cartLine == null) {
			//Add new cart line
			cartLine = new CartLine();
			//Fetch product
			Product product = productDAO.get(productId);
			//Set fields
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			
			cartLineDAO.add(cartLine);
			
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			response = "result=added";
		}
		
		return response;
	}
}
