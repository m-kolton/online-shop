package pl.kolton.shopbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.kolton.shopbackend.dao.CategoryDAO;
import pl.kolton.shopbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// first category
		category.setId(1);
		category.setName("Telefony komórkowe");
		category.setDescription("W tej kategorii znajdziesz telefony komórkowe");
		category.setImageURL("CAT_1");

		categories.add(category);

		category = new Category();

		// second category
		category.setId(2);
		category.setName("Laptopy");
		category.setDescription("W tej kategorii znajdziesz laptopy");
		category.setImageURL("CAT_2");

		categories.add(category);

		category = new Category();

		// third category
		category.setId(3);
		category.setName("Telewizory");
		category.setDescription("W tej kategorii znajdziesz telewizory");
		category.setImageURL("CAT_3");

		categories.add(category);
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		for (Category category : categories) {
			if (category.getId() == id)
				return category;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			//Add category to database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
