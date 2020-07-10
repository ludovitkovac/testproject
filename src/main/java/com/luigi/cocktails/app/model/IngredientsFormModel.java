package com.luigi.cocktails.app.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class IngredientsFormModel {

	private Long[] ingredientIds;

	public IngredientsFormModel() {
		super();
	}

	public Long[] getIngredientIds() {
		return ingredientIds;
	}

	public void setIngredientIds(Long[] ingredientIds) {
		this.ingredientIds = ingredientIds;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
