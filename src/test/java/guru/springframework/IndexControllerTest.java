package guru.springframework;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import guru.springframework.controllers.IndexController;
import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;


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
	public  void testMockMvc() throws Exception{
		MockMvc mockMvc=MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}
	
	
	@Test
	public void testIndexPage(){
		List<Recipe> myList=new ArrayList<>();
		myList.add(new Recipe());
		myList.add(new Recipe());
		Mockito.when(recipeService.getRecipeesList()).thenReturn(myList);
		ArgumentCaptor<List<Recipe>> argumentCaptor=ArgumentCaptor.forClass(List.class);
		Assert.assertEquals("index",indexController.getIndexPage(model));
		Mockito.verify(recipeService,times(1)).getRecipeesList();
		Mockito.verify(model,times(1)).addAttribute(Mockito.eq("recipesList"),argumentCaptor.capture());
		List<Recipe> value = argumentCaptor.getValue();
		Assert.assertEquals(2, value.size());
	}


}
