package com.hcl.taco.controller;

import com.hcl.taco.engity.Ingredient;
import com.hcl.taco.engity.Rjm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/desin")
public class DesignTacoController {

    @GetMapping
    public String showDesignFrom(Model model){
        List<Ingredient> ingredients= Arrays.asList(
                new Ingredient("fs","肥瘦",Ingredient.TYPE.meat),
                new Ingredient("cs","纯瘦",Ingredient.TYPE.meat),
                new Ingredient("td","土豆",Ingredient.TYPE.dish),
                new Ingredient("sc","蔬菜",Ingredient.TYPE.dish),
                new Ingredient("jzg","金针菇",Ingredient.TYPE.dish),
                new Ingredient("m1","白饼",Ingredient.TYPE.cake),
                new Ingredient("m2","千层饼",Ingredient.TYPE.cake),
                new Ingredient("la1","微辣",Ingredient.TYPE.pepper),
                new Ingredient("la2","中辣",Ingredient.TYPE.pepper),
                new Ingredient("la3","超级辣",Ingredient.TYPE.pepper),
                new Ingredient("la0","不辣",Ingredient.TYPE.pepper)
        );

        Ingredient.TYPE[] types=Ingredient.TYPE.values();
        for(Ingredient.TYPE type:types){
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type));
        }

        model.addAttribute("design",new Rjm());
        return "design";
    }


    private List<Ingredient> filterByType(List<Ingredient> ingredients,Ingredient.TYPE type){
        return  ingredients.stream().filter(x ->x.getType().equals(type)).collect(Collectors.toList());
    }

    @PostMapping
    public String order(Rjm rjm){
        log.info("订购了： "+rjm);
        return "redirect:/desin";
    }
}
