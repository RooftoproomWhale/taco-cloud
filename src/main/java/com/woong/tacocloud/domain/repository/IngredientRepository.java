package com.woong.tacocloud.domain.repository;

import com.woong.tacocloud.domain.Ingredient;

public interface IngredientRepository
{
    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
