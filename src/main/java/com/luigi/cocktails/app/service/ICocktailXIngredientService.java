package com.luigi.cocktails.app.service;

import java.util.List;

import com.luigi.cocktails.app.model.TCocktailXIngredient;

public interface ICocktailXIngredientService {

	public List<TCocktailXIngredient> findAllCocktailsByIngredientIds(List<Long> ingredientIds);

}