package net.pps.shopbackend.dao;

import java.util.List;

import net.pps.shopbackend.dto.Category;

public interface CategoryDAO {
	
	boolean add(Category category);
	List<Category> list();
	Category get(int id);
}
