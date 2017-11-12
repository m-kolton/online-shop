package pl.kolton.shopbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.kolton.shopbackend.dao.CategoryDAO;
import pl.kolton.shopbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private static Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("pl.kolton.shopbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*@Test
	public void testAddCategory() {

		category = new Category();

		category.setName("Małe AGD");
		category.setDescription("W tej kategorii znajdziesz małe AGD");
		category.setImageURL("CAT_7.png");

		assertEquals("Sukces! Kategoria została prawidłowo dodana.", true, categoryDAO.add(category));
	}*/

	/*@Test
	public void testGetCategory() {

		category = categoryDAO.get(1);
		assertEquals("Sukces! Kategoria została poprawnie pobrana.", "Telefony", category.getName());
	}*/

	/*@Test
	public void testUpdateCategory() {

		category = categoryDAO.get(1);
		category.setName("Television");
		assertEquals("Sukces! Kategoria została poprawnie zaktualizowana.", true, categoryDAO.update(category));
	}*/

	/*@Test
	public void testDeleteCategory() {

		category = categoryDAO.get(5);
		assertEquals("Sukces! Kategoria została poprawnie usunięta.", true, categoryDAO.delete(category));
	}*/

	/*@Test
	public void testListCategory() {

		assertEquals("Sukces! Lista zawiera tylko aktywne kategorie.", 3, categoryDAO.list().size());
	}*/

	@Test
	public void testCategoryCRUD() {

		// Add operation
		category = new Category();

		category.setName("Laptopy");
		category.setDescription("W tej kategorii znajdziesz laptopy");
		category.setImageURL("CAT_1.png");

		assertEquals("Sukces! Kategoria została prawidłowo dodana.", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Smartfony");
		category.setDescription("W tej kategorii znajdziesz smartfony");
		category.setImageURL("CAT_2.png");

		assertEquals("Sukces! Kategoria została prawidłowo dodana.", true, categoryDAO.add(category));

		// Update operation
		category = categoryDAO.get(2);
		category.setName("Telefony komórkowe");
		assertEquals("Sukces! Kategoria została poprawnie zaktualizowana.", true, categoryDAO.update(category));

		// Delete category
		assertEquals("Sukces! Kategoria została poprawnie usunięta.", true, categoryDAO.delete(category));

		// List of categories
		assertEquals("Sukces! Lista zawiera tylko aktywne kategorie.", 1, categoryDAO.list().size());
	}
}
