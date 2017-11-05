package pl.kolton.shopbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.kolton.shopbackend.dao.CategoryDAO;
import pl.kolton.shopbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category1 = new Category();

		// first category
		category1.setId(1);
		category1.setName("Telefony komórkowe");
		category1.setDescription("W tej kategorii znajdziesz telefony komórkowe");
		category1.setImageURL("CAT_1");

		categories.add(category1);

		Category category2 = new Category();
		
		// second category
		category2.setId(2);
		category2.setName("Laptopy");
		category2.setDescription("W tej kategorii znajdziesz laptopy");
		category2.setImageURL("CAT_2");

		categories.add(category2);

		Category category3 = new Category();
		
		// third category
		category3.setId(3);
		category3.setName("Telewizory");
		category3.setDescription("W tej kategorii znajdziesz telewizory");
		category3.setImageURL("CAT_3");

		categories.add(category3);
	}

	@Override
	public List<Category> list() {
		return categories;
	}
}
