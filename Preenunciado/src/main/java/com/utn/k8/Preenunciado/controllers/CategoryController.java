package com.utn.k8.Preenunciado.controllers;


import com.utn.k8.Preenunciado.dtos.CategoryDTO;
import com.utn.k8.Preenunciado.entidades.Category;
import com.utn.k8.Preenunciado.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id){
        Category category = categoryService.getById(id);

        if(category != null){
            return ResponseEntity.ok(category);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = categoryService.getAll();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody CategoryDTO categoryDTO){
        Category category = categoryService.save(categoryDTO);
        return  ResponseEntity.ok(category);
    }

    @PutMapping("{id}")
    ResponseEntity<Category> update(@PathVariable Long id,@RequestBody CategoryDTO categoryDTO){
        Category category = categoryService.update(id, categoryDTO);

        return ResponseEntity.ok(category);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
