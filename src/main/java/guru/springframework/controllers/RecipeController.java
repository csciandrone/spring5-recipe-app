package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.services.RecipeService;

@Controller
public class RecipeController {
	
	private RecipeService recipeService;
	
	
	
	public RecipeController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}



	@RequestMapping("/recipe/show/{id}")
	public String getRecipeById(@PathVariable String id,Model model){
		model.addAttribute("recipe",this.recipeService.findById(new Long(id)));
		return "recipe/show";
	}

}
