package guru.springframework;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeServiceImpl;

public class RecipeServiceImplTest {
	RecipeServiceImpl recipeServiceImpl;
	@Mock
	RecipeRepository recipeRepository;
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		recipeServiceImpl=new RecipeServiceImpl(recipeRepository);
		
	}
	@Test
	public void getRecipeByIdTest() throws Exception{
		Recipe recipe=new Recipe();
		recipe.setId(13L);
		Optional<Recipe> recipeOptional = Optional.of(recipe);
		Mockito.when(recipeRepository.findById(Mockito.anyLong())).thenReturn(recipeOptional);
		Recipe recipeFounded = recipeServiceImpl.findById(13L);
		assertNotNull("Null recipe returned",recipeFounded);
		verify(recipeRepository,times(1)).findById(Mockito.anyLong());
		verify(recipeRepository,never()).findAll();
	}
	
	
	@Test
	public void getRecipes() throws Exception{
		Recipe recipe=new Recipe();
		List<Recipe> recipeList=new ArrayList<>();
		recipeList.add(recipe);
		Mockito.when(recipeServiceImpl.getRecipeesList()).thenReturn(recipeList);
		Assert.assertEquals(recipeServiceImpl.getRecipeesList().size(),1);
		Mockito.verify(recipeRepository,times(1)).findAll();
	}

}
