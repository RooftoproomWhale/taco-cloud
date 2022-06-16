package com.woong.tacocloud.repository;

import com.woong.tacocloud.domain.Ingredient;

import java.util.Iterator;

public interface IngredientRepository
{
    Iterator<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
