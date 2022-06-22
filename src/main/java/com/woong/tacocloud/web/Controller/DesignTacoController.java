package com.woong.tacocloud.web.Controller;

import com.woong.tacocloud.domain.Ingredient;
import com.woong.tacocloud.domain.Ingredient.Type;
import com.woong.tacocloud.domain.Order;
import com.woong.tacocloud.domain.Taco;
import com.woong.tacocloud.domain.repository.IngredientRepository;
import com.woong.tacocloud.domain.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController
{
    private final IngredientRepository ingredientRepository;

    private final TacoRepository tacoRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepo) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepo = tacoRepo;
    }

    @GetMapping
    public String showDesignForm(Model model)
    {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);

        Type[] types = Ingredient.Type.values();
        for (Type type : types)
        {
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type));
        }

        model.addAttribute("taco", new Taco());

        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type)
    {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    @ModelAttribute(name = "order")
    public Order order()
    {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco()
    {
        return new Taco();
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order)
    {
        if(errors.hasErrors()) {return "design";};
        Taco saved = tacoRepo.save(design);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }
}
