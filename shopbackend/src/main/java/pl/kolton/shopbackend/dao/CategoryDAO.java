package pl.kolton.shopbackend.dao;

import java.util.List;

import pl.kolton.shopbackend.dto.Category;

public interface CategoryDAO {
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
}
