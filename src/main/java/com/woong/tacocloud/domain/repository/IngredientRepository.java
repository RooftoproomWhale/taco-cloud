package com.woong.tacocloud.domain.repository;

import com.woong.tacocloud.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String>
{
//    Iterable<Ingredient> findAll();
//    Ingredient findById(String id);
//    Ingredient save(Ingredient ingredient);
}
