package guru.springframework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import guru.springframework.domain.Category;

public class CategoryTest {
	
	
	Category category;
	@Before
	public void setUp(){
		category=new Category();
	}
	@Test
	public void testId(){
		Long idValue=8l;
		category.setId(idValue);
		Assert.assertEquals(idValue, category.getId());
	}

}
