package pl.kolton.shopbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.kolton.shopbackend.dao.CartLineDAO;
import pl.kolton.shopbackend.dao.ProductDAO;
import pl.kolton.shopbackend.dao.UserDAO;
import pl.kolton.shopbackend.dto.Cart;
import pl.kolton.shopbackend.dto.CartLine;
import pl.kolton.shopbackend.dto.Product;
import pl.kolton.shopbackend.dto.User;

public class CartLineTestCase {
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("pl.kolton.shopbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO"); 
	}
	
	@Test
	public void testAddNewCartLine() {
		//Get user
		user = userDAO.getByEmail("rn@gmail.com");
		//Fetch cart
		cart = user.getCart();
		//Get product
		product = productDAO.get(1);
		//Create new cartline
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		
		assertEquals("Błąd dodawania do koszyka", true, cartLineDAO.add(cartLine));
		
		//Update cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertEquals("Błąd aktualizacji koszyka", true, cartLineDAO.updateCart(cart));
	}
	
}
