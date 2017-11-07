package pl.kolton.shopbackend.dao;

import java.util.List;
import pl.kolton.shopbackend.dto.Category;

public interface CategoryDAO {
	
	boolean add(Category category);
	
	List<Category> list();
	Category get(int id);
}
