package guru.springframework.bootstrap;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.IngredientRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
@Component
public class DevBotStrap implements ApplicationListener<ContextRefreshedEvent>  {
	private RecipeRepository recipeRepository;
	
    private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMemoryRepository;

	
	public DevBotStrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository,
			UnitOfMeasureRepository unitOfMemoryRepository) {
		super();
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
		this.unitOfMemoryRepository = unitOfMemoryRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}
	
	private void initData(){
		addGuacamole();
		addSpicyGrilledChicken();
	
	}

	private void addSpicyGrilledChicken() {
		Recipe spicyGrilledChicken=new Recipe();
		Optional<Category> categoria = categoryRepository.findByDescription("Mexican");
		Set<Category> categorie=new HashSet<>();
		categorie.add(categoria.get());
		spicyGrilledChicken.setCategories(categorie);
		spicyGrilledChicken.setCookTime(10);
		spicyGrilledChicken.setDescription("Spicy Grilled Chicken");
		spicyGrilledChicken.setDifficulty(Difficulty.HARD);
		spicyGrilledChicken.setDirections("lkhjlkjlkjlkjlk");
		//guacamole.setImage(image);
		//guacamole.setIngredients(ingredients);
		spicyGrilledChicken.setPrepTime(12);
		spicyGrilledChicken.setServings(2332);
		spicyGrilledChicken.setUrl("http://www.simplyrecipes.com/recipes/donna_arcama/");
		
		Notes noteSpicyChicken=new Notes();
		noteSpicyChicken.setRecipe(spicyGrilledChicken);
		noteSpicyChicken.setRecipeNotes("Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack! First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings. Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!");
	    spicyGrilledChicken.setNotes(noteSpicyChicken);
	    /**
1 teaspoon dried oregano
1 teaspoon dried cumin
1 teaspoon sugar
1/2 teaspoon salt
1 clove garlic, finely chopped
1 tablespoon finely grated orange zest
3 tablespoons fresh-squeezed orange juice
2 tablespoons olive oil
4 to 6 skinless, boneless chicken thighs (1 1/4 pounds)
To serve:
8 small corn tortillas
3 cups packed baby arugula (3 ounces)
2 medium ripe avocados, sliced
4 radishes, thinly sliced
1/2 pint cherry tomatoes, halved
1/4 red onion, thinly sliced
Roughly chopped cilantro
1/2 cup sour cream thinned with 1/4 cup milk
1 lime, cut into wedges


Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4rX5yD0UA
	     */
	    Set<Ingredient> spicyGrilledChickenIngredients=new HashSet<>();
	    UnitOfMeasure measure=unitOfMemoryRepository.findByDescription("Avocado").get();
	    
	    UnitOfMeasure teaSpoon=unitOfMemoryRepository.findByDescription("Teaspoon").get();
	    UnitOfMeasure tableSpoon=unitOfMemoryRepository.findByDescription("Tablespoon").get();
	    UnitOfMeasure serranoChiles=unitOfMemoryRepository.findByDescription("SerranoChiles").get();
	    UnitOfMeasure dash=unitOfMemoryRepository.findByDescription("Dash").get();
	    UnitOfMeasure tomato=unitOfMemoryRepository.findByDescription("Tomato").get();
	    Ingredient ing1 = addIngredient(spicyGrilledChicken,new BigDecimal("2"),"ancho chili powder",tableSpoon);
	    Ingredient ing2 = addIngredient(spicyGrilledChicken,new BigDecimal(1),"dried oregano",teaSpoon);
	    Ingredient ing3 = addIngredient(spicyGrilledChicken,new BigDecimal(1),"sugar",teaSpoon);
	    Ingredient ing4 = addIngredient(spicyGrilledChicken,new BigDecimal(1),"dried cumin",tableSpoon);
	    Ingredient ing5= addIngredient(spicyGrilledChicken, new BigDecimal(0.5), "salt", tableSpoon);
	    spicyGrilledChickenIngredients.add(ing1);
	    spicyGrilledChickenIngredients.add(ing2);
	    spicyGrilledChickenIngredients.add(ing3);
	    spicyGrilledChickenIngredients.add(ing4);
	    spicyGrilledChickenIngredients.add(ing5);
	    spicyGrilledChicken.setIngredients(spicyGrilledChickenIngredients);
		this.recipeRepository.save(spicyGrilledChicken);
		
	}

	private void addGuacamole() {
		Recipe guacamole=new Recipe();
		Optional<Category> categoria = categoryRepository.findByDescription("Mexican");
		Set<Category> categorie=new HashSet<>();
		categorie.add(categoria.get());
		guacamole.setCategories(categorie);
		guacamole.setCookTime(10);
		guacamole.setDescription("Perfect Guacamole");
		guacamole.setDifficulty(Difficulty.MODERATE);
		guacamole.setDirections("dfsddsf");
		//guacamole.setImage(image);
		//guacamole.setIngredients(ingredients);
		guacamole.setPrepTime(10);
		guacamole.setServings(12312);
		guacamole.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
		
		Notes noteGuacamole=new Notes();
		noteGuacamole.setRecipe(guacamole);
		noteGuacamole.setRecipeNotes("Guacamole, a dip made from avocados, is originally from Mexico. "
				+ "The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce)."
				+ "All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity to balance the richness of the avocado. Then comes chopped cilantro, chiles, onion, and tomato, if you want."
				+"The trick to making perfect guacamole is using good, ripe avocados. Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.");
	    guacamole.setNotes(noteGuacamole);
	    
	    /**
	     * 2 ripe avocados
1/2 teaspoon Kosher salt
1 Tbsp of fresh lime juice or lemon juice
2 Tbsp to 1/4 cup of minced red onion or thinly sliced green onion
1-2 serrano chiles, stems and seeds removed, minced
2 tablespoons cilantro (leaves and tender stems), finely chopped
A dash of freshly grated black pepper
1/2 ripe tomato, seeds and pulp removed, chopped


Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4rVyEoMte
	     */
	    Set<Ingredient> guacamoleIngredients=new HashSet<>();
	    UnitOfMeasure measure=unitOfMemoryRepository.findByDescription("Avocado").get();
	    
	    UnitOfMeasure teaSpoon=unitOfMemoryRepository.findByDescription("Teaspoon").get();
	    UnitOfMeasure tableSpoon=unitOfMemoryRepository.findByDescription("Tablespoon").get();
	    UnitOfMeasure serranoChiles=unitOfMemoryRepository.findByDescription("SerranoChiles").get();
	    UnitOfMeasure dash=unitOfMemoryRepository.findByDescription("Dash").get();
	    UnitOfMeasure tomato=unitOfMemoryRepository.findByDescription("Tomato").get();
	    Ingredient ing1 = addIngredient(guacamole,new BigDecimal("2"),"ripe avocado",measure);
	    Ingredient ing2 = addIngredient(guacamole,new BigDecimal(0.5),"kosher salt",teaSpoon);
	    Ingredient ing3 = addIngredient(guacamole,new BigDecimal(1),"fresh lime juice or lemon juice",tableSpoon);
	    Ingredient ing4 = addIngredient(guacamole,new BigDecimal(0.25),"minced red onion or thinly sliced green onion",tableSpoon);
	    Ingredient ing5= addIngredient(guacamole, new BigDecimal(1), "serrano chiles, stems and seeds removed, minced", serranoChiles);
	    Ingredient ing6=addIngredient(guacamole, new BigDecimal(2), "cilantro (leaves and tender stems), finely chopped", tableSpoon);
	    Ingredient ing7=addIngredient(guacamole, new BigDecimal(1), "freshly grated black pepper", dash);
	    Ingredient ing8=addIngredient(guacamole, new BigDecimal(0.5), "ripe tomato, seeds and pulp removed, chopped", tomato);
	    guacamoleIngredients.add(ing1);
	    guacamoleIngredients.add(ing2);
	    guacamoleIngredients.add(ing3);
	    guacamoleIngredients.add(ing4);
	    guacamoleIngredients.add(ing5);
	    guacamoleIngredients.add(ing6);
	    guacamoleIngredients.add(ing7);
	    guacamoleIngredients.add(ing8);
	    guacamole.setIngredients(guacamoleIngredients);
		this.recipeRepository.save(guacamole);
	}

	private Ingredient addIngredient(Recipe guacamole,BigDecimal amount,String description,UnitOfMeasure unitOfMeasure) {
		Ingredient ing1=new Ingredient();
	    ing1.setAmount(amount);
	    ing1.setDescription(description);
	    ing1.setRecipe(guacamole);
	    
	    ing1.setUnitOfMeasure(unitOfMeasure);
		return ing1;
	}
	
}
