package net.pps.shopbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.pps.shopbackend.dao.CategoryDAO;
import net.pps.shopbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.pps.shopbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("CategoryDAO");
	}
	
	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("IPCamera");
		category.setDescription("This is some description for IP Camera!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
	}
}
