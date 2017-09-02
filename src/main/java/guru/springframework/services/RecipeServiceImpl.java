package guru.springframework.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
@Service
public class RecipeServiceImpl implements RecipeService {
	
	private RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}
	
	
	/* (non-Javadoc)
	 * @see guru.springframework.services.RecipeServiceInterface#getRecipeesList()
	 */
	@Override
	public List<Recipe> getRecipeesList(){
		List<Recipe> retList=new ArrayList<>();
		Iterable<Recipe> findAll = recipeRepository.findAll();
		Iterator<Recipe> iterator = findAll.iterator();
		while(iterator.hasNext()){
			retList.add(iterator.next());
		}
		return retList;
	}

}
