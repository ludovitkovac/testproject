package com.luigi.cocktails.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luigi.cocktails.app.model.TCocktail;

public interface ICocktailRepository extends JpaRepository<TCocktail, Long> {

}