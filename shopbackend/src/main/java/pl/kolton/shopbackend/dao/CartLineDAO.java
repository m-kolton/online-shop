package pl.kolton.shopbackend.dao;

import java.util.List;

import pl.kolton.shopbackend.dto.Cart;
import pl.kolton.shopbackend.dto.CartLine;

public interface CartLineDAO {
	
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	//Business methods	
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId); 
	
	// Method for updating to cart
	boolean updateCart(Cart cart);
}
