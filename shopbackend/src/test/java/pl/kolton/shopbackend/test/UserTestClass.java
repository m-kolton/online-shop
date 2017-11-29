package pl.kolton.shopbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.kolton.shopbackend.dao.UserDAO;
import pl.kolton.shopbackend.dto.Address;
import pl.kolton.shopbackend.dto.Cart;
import pl.kolton.shopbackend.dto.User;

public class UserTestClass {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("pl.kolton.shopbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	/*@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("Mateusz");
		user.setLastName("Kowalsi");
		user.setEmail("m.kowalski@gmail.com");
		user.setContactNumber("123456789");
		user.setRole("USER");
		user.setPassword("abcd1234");
		
		//Adding user
		assertEquals("Błąd dodawania użytkownika!", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("ul. Przykładowa 1");
		address.setAddressLineTwo("Obok Herta");
		address.setCity("Wrocław");
		address.setState("Dolnośląskie");
		address.setCountry("Polska");
		address.setPostalCode("50-231");
		address.setBilling(true);
		
		//Linking user with address
		address.setUserId(user.getId());
		
		//Adding address
		assertEquals("Błąd dodawania adresu!", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			
			//Create cart for user
			cart = new Cart();
			cart.setUser(user);
			
			//Adding cart
			assertEquals("Błąd tworzenia koszyka!", true, userDAO.addCart(cart));
			
			//Adding shipping address
			address = new Address();
			address.setAddressLineOne("ul. Przykładowa 2");
			address.setAddressLineTwo("Na przeciwko ELeclerca");
			address.setCity("Wrocław");
			address.setState("Dolnośląskie");
			address.setCountry("Polska");
			address.setPostalCode("50-231");
			//Shipping = true, billing = false
			address.setShipping(true);
			
			//Linking with user
			address.setUserId(user.getId());
			
			//Adding shipping address, same method for adding like above
			assertEquals("Błąd dodawania adresu do wysyłki!", true, userDAO.addAddress(address));
		}
		
	}*/
	
	/*@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("Mateusz");
		user.setLastName("Kowalsi");
		user.setEmail("m.kowalski@gmail.com");
		user.setContactNumber("123456789");
		user.setRole("USER");
		user.setPassword("abcd1234");
		
		
		if(user.getRole().equals("USER")) {
			
			//Create cart for user
			cart = new Cart();
			cart.setUser(user);
			
			//Attaching cart with user
			user.setCart(cart);
		
		}
		 
		//Adding user
				assertEquals("Błąd dodawania użytkownika!", true, userDAO.addUser(user));
				
		
	}*/
	
	/*//Test for updating cart
	@Test
	public void testUpdateCart() {
		//Fetching user by email
		user = userDAO.getByEmail("m.kowalski@gmail.com");
		
		//Getting cart of this user
		cart = user.getCart();
		
		cart.setGrandTotal(1111);
		cart.setCartLines(2);
		
		assertEquals("Błąd przy aktualizacji koszyka", true, userDAO.updateCart(cart));
	}*/
	
	/*@Test
	public void testAddAddress() {
		//Adding user 
		user = new User();
		user.setFirstName("Mateusz");
		user.setLastName("Kowalsi");
		user.setEmail("m.kowalski@gmail.com");
		user.setContactNumber("123456789");
		user.setRole("USER");
		user.setPassword("abcd1234");
		
		assertEquals("Błąd dodawania użytkownika!", true, userDAO.addUser(user));
		
		//Adding address for billing
		address = new Address();
		address.setAddressLineOne("ul. Przykładowa 1");
		address.setAddressLineTwo("Obok Herta");
		address.setCity("Wrocław");
		address.setState("Dolnośląskie");
		address.setCountry("Polska");
		address.setPostalCode("50-231");
		address.setBilling(true);
		
		//Setting user to address
		address.setUser(user);
		
		assertEquals("Błąd dodawania adresu rozliczeniowego!", true, userDAO.addAddress(address));
		
		//Adding address for shipping
		address = new Address();
		address.setAddressLineOne("ul. Przykładowa 1");
		address.setAddressLineTwo("Obok Herta");
		address.setCity("Wrocław");
		address.setState("Dolnośląskie");
		address.setCountry("Polska");
		address.setPostalCode("50-231");
		
		//Setting shipping address true
		address.setShipping(true);
		
		//Setting user to address
		address.setUser(user);
		
		assertEquals("Błąd dodawania adresu do wysyłki!", true, userDAO.addAddress(address));
	}*/
	
	/*@Test
	public void testAddAddress() {
		
		user = userDAO.getByEmail("m.kowalski@gmail.com");
		
		address = new Address();
		address.setAddressLineOne("ul. Przykładowa 10");
		address.setAddressLineTwo("Na przeciwno eLeclerc");
		address.setCity("Wrocław");
		address.setState("Dolnośląskie");
		address.setCountry("Polska");
		address.setPostalCode("50-231");
		
		//Setting shipping address true
		address.setShipping(true);
		
		//Setting user to address
		address.setUser(user);
		
		assertEquals("Błąd dodawania adresu użytkownika", true, userDAO.addAddress(address));
	}*/
	
	@Test
	public void testGetAddresses() {
		user = userDAO.getByEmail("m.kowalski@gmail.com");
		
		assertEquals("Błąd uzyskiwania listy adresów", 2, userDAO.listShippingAddresses(user).size());
		
		assertEquals("Błąd uzyskiwania listy adresów", "Wrocław", userDAO.getBillingAddress(user).getCity());
	}
}
