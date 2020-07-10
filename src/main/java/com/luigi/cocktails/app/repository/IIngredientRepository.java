package com.luigi.cocktails.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luigi.cocktails.app.model.TIngredient;

public interface IIngredientRepository extends JpaRepository<TIngredient, Long> {

}