package com.luigi.cocktails.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luigi.cocktails.app.model.CocktailMatchModel;
import com.luigi.cocktails.app.model.IngredientsFormModel;
import com.luigi.cocktails.app.model.TCocktail;
import com.luigi.cocktails.app.model.TCocktailXIngredient;
import com.luigi.cocktails.app.repository.ICocktailRepository;
import com.luigi.cocktails.app.repository.ICocktailXIngredientRepository;
import com.luigi.cocktails.app.repository.IIngredientRepository;
import com.luigi.cocktails.app.service.ICocktailXIngredientService;

@Controller
public class IngredientController {

	@Autowired
	private IIngredientRepository ingredientRepository;
	
	@Autowired
	private ICocktailXIngredientService cocktailXIngredientService;
	
	@Autowired
	private ICocktailXIngredientRepository cocktailXIngredientRepository;
	
	@Autowired
	private ICocktailRepository cocktailRepository;
	
	private static final double MIN_PERCENTAGE_MATCH = 0.5;
	
	@GetMapping("/ingredients") // local url: http://localhost:8080/LuigiCocktails/ingredients
	public String getIngredients(Model model) {

		model.addAttribute("ingredients", ingredientRepository.findAll());
		model.addAttribute("ingredientsFormModel", new IngredientsFormModel());
		
		return "ingredients";  // return ingredients.html from /templates
	}
	
	@PostMapping("/result")
	public String result(@ModelAttribute IngredientsFormModel formModel, Model model) {
		Long[] ingredientIds = formModel.getIngredientIds();
		
		// cocktail id, percentage match
		Map<Long, Integer> percentageMatch = new HashMap<>();
		
		List<TCocktailXIngredient> cocktailIngredientList = 
				cocktailXIngredientService.findAllCocktailsByIngredientIds(new ArrayList<>(Arrays.asList(formModel.getIngredientIds())));
		
		for (Iterator<TCocktailXIngredient> iterator = cocktailIngredientList.iterator(); iterator.hasNext();) {
			TCocktailXIngredient cocktailXIngredient = iterator.next();
			
			List<TCocktailXIngredient> cocktailIngredientList2 = 
					cocktailXIngredientRepository.findIngredientsByCocktailId(cocktailXIngredient.getCocktail().getCocktailId());
			
			int listSize = cocktailIngredientList2.size();
			
			int matchCount = 0;
			
			for (Iterator<TCocktailXIngredient> iterator2 = cocktailIngredientList2.iterator(); iterator2.hasNext();) {
				TCocktailXIngredient cocktailXIngredient2 = (TCocktailXIngredient) iterator2.next();
				
				for (int i = 0; i < ingredientIds.length; i++) {
					if (ingredientIds[i].equals(cocktailXIngredient2.getIngredient().getIngredientId())) {
						matchCount++;
					}
				}
			}
			
			// if percentage match is higher as 50 percent
			if ((((double) matchCount) / ((double) listSize)) > MIN_PERCENTAGE_MATCH) {
				percentageMatch.put(cocktailXIngredient.getCocktail().getCocktailId(), 
						Integer.valueOf((int) ((((double) matchCount) / ((double) listSize)) * 100)));
			}
		}
		
		Object[] percentageMatchArr = percentageMatch.entrySet().toArray();
		
		// sort by percentage
		Arrays.sort(percentageMatchArr, (Object o1, Object o2) -> ((Map.Entry<String, Integer>) o2).getValue()
				.compareTo(((Map.Entry<String, Integer>) o1).getValue()));
		
		List<CocktailMatchModel> matches = new LinkedList<>();
		
		for (int i = 0; i < percentageMatchArr.length; i++) {

			// entry key = id, entry value = percentage match
			Map.Entry<Long, Integer> entry = (Map.Entry<Long, Integer>) percentageMatchArr[i];
			
			TCocktail cocktail = this.cocktailRepository.getOne(entry.getKey());
			
			matches.add(new CocktailMatchModel(cocktail.getName(), (entry.getValue() + " %"), cocktail.getUrl()));
			
		}
		
		model.addAttribute("matches", matches);
		
		return "result"; // return result.html from /templates
	}
}
