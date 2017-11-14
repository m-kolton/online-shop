package pl.kolton.shopbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.kolton.shopbackend.dao.ProductDAO;
import pl.kolton.shopbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("pl.kolton.shopbackend");
		context.refresh();

		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	/*@Test
	public void testProductCRUD() {
		
		//Add operation
		product = new Product();
		
		product.setName("Samsung Galaxy A3");
		product.setBrand("Samsung");
		product.setDescription("To jest opis dla Samsunga Galaxy A3");
		product.setUnitPrice(700);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Coś poszło nie tak podczas dodawania produktu!", true, productDAO.add(product));
		
		// Update operation
		product = productDAO.get(4);
		product.setName("MacBook Pro 2017");
		assertEquals("Coś poszło nie tak podczas aktualizowania produktu!", true, productDAO.update(product));

		// Delete product
		assertEquals("Coś poszło nie tak podczas usuwania produktu!", true, productDAO.delete(product));

		// List of products
		assertEquals("Coś poszło nie tak podczas pobierania listy produktów!", 10, productDAO.list().size());
	}*/
	
	/*@Test
	public void testListActiveProducts() {
		assertEquals("Coś poszło nie tak podczas pobierania listy aktywnych produktów!", 9, productDAO.listActiveProducts().size());
	}*/
	
	/*@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Coś poszło nie tak podczas pobierania listy aktywnych produktów w tej kategorii!", 1, productDAO.listActiveProductsByCategory(1).size());
		assertEquals("Coś poszło nie tak podczas pobierania listy aktywnych produktów w tej kategorii!", 8, productDAO.listActiveProductsByCategory(3).size());
	}*/
	
	@Test
	public void testGetLatestActiveProducts() {
		assertEquals("Coś poszło nie tak podczas pobierania listy aktywnych produktów w tej kategorii!", 3, productDAO.getLatestActiveProducts(3).size());
	}
}
