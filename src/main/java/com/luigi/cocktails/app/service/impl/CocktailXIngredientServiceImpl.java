package com.luigi.cocktails.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luigi.cocktails.app.model.TCocktailXIngredient;
import com.luigi.cocktails.app.repository.ICocktailXIngredientRepository;
import com.luigi.cocktails.app.service.ICocktailXIngredientService;

@Service
public class CocktailXIngredientServiceImpl implements ICocktailXIngredientService {

	@Autowired
	ICocktailXIngredientRepository cocktailXIngredientRepository;
	
	@Override
	public List<TCocktailXIngredient> findAllCocktailsByIngredientIds(List<Long> ingredientIds) {

		return cocktailXIngredientRepository.findAll().stream()
				.filter(record -> ingredientIds.contains(record.getIngredient().getIngredientId())).distinct()
				.collect(Collectors.toList());
	}

}
