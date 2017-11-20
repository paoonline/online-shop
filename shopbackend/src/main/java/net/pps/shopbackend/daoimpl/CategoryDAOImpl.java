package net.pps.shopbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.pps.shopbackend.dao.CategoryDAO;
import net.pps.shopbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>();
	
	
	static {
		Category cateogry = new  Category();
		
		//adding first category
		cateogry.setId(1);
		cateogry.setName("IPCamera");
		cateogry.setDescription("This is some description for IP Camera!");
		cateogry.setImageURL("CAT_1.png");
			
		categories.add(cateogry);
		
		//second category
		cateogry = new  Category();
		cateogry.setId(2);
		cateogry.setName("CameraCar");
		cateogry.setDescription("This is some description for Camera car!");
		cateogry.setImageURL("CAT_2.png");
		
		categories.add(cateogry);
		
		//second category
		cateogry = new Category();
		cateogry.setId(3);
		cateogry.setName("Accessories");
		cateogry.setDescription("This is some description for Accessories!");
		cateogry.setImageURL("CAT_3.png");
				
		categories.add(cateogry);
		
		
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
	
		//enchanced for loop
		for(Category category : categories) {
			if(category.getId() == id) return category;
				
		}
		return null;
	}

	@Override
	public boolean add(Category category) {
		
		try {
			//add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	
	}

}
