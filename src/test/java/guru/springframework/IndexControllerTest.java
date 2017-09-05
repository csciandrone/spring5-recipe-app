package guru.springframework;

import static org.mockito.Mockito.times;

import java.util.Collection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import guru.springframework.controllers.IndexController;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeService;
import guru.springframework.services.RecipeServiceImpl;

public class IndexControllerTest {
	
	@Mock
    RecipeService recipeService;

    @Mock
    Model model;
    
    IndexController indexController;

	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		indexController=new IndexController(recipeService);
		
	}
	@Test
	public void testIndexPage(){
		
		
		Assert.assertEquals("index",indexController.getIndexPage(model));
		Mockito.verify(recipeService,times(1)).getRecipeesList();
		Mockito.verify(model,times(1)).addAttribute(Mockito.eq("recipesList"),Mockito.anyList());
	}


}
