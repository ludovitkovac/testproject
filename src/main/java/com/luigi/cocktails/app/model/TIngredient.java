package com.luigi.cocktails.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "t_ingredients", schema = "co")
public class TIngredient implements Serializable {

	private static final long serialVersionUID = -8286523664238684462L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_ingredients_seq")
    @SequenceGenerator(name = "t_ingredients_seq", sequenceName = "co.t_ingredients_ingredient_id_seq", allocationSize = 1, initialValue = 0)
	@Column(name = "ingredient_id", nullable = false)
	private Long ingredientId;

	@Column(name = "name", nullable = false)
	private String name;

	public TIngredient() {
		super();
	}

	public Long getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
