package com.luigi.cocktails.app.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CocktailMatchModel {

	private String cocktailName;
	private String percentageMatch;
	private String url;
		
	public CocktailMatchModel() {
		super();
	}

	public CocktailMatchModel(String cocktailName, String percentageMatch, String url) {
		super();
		this.cocktailName = cocktailName;
		this.percentageMatch = percentageMatch;
		this.url = url;
	}

	public String getCocktailName() {
		return cocktailName;
	}

	public void setCocktailName(String cocktailName) {
		this.cocktailName = cocktailName;
	}

	public String getPercentageMatch() {
		return percentageMatch;
	}

	public void setPercentageMatch(String percentageMatch) {
		this.percentageMatch = percentageMatch;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
