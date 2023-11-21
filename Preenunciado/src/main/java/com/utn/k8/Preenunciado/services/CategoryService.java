package com.utn.k8.Preenunciado.services;

import com.utn.k8.Preenunciado.dtos.CategoryDTO;
import com.utn.k8.Preenunciado.dtos.CustomerDTO;
import com.utn.k8.Preenunciado.entidades.Category;
import com.utn.k8.Preenunciado.entidades.Customer;
import com.utn.k8.Preenunciado.excepciones.ResourceNotFoundException;
import com.utn.k8.Preenunciado.excepciones.ResourseConflictException;
import com.utn.k8.Preenunciado.mapppers.CategoryMapper;
import com.utn.k8.Preenunciado.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;


    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category getById(Long id){
        Category category = categoryRepository.findById(id)
                .orElse(null);

        return category;
    }
    public Category save(CategoryDTO categoryDTO){
        if(getById(categoryDTO.getCategoryId()) != null){
            throw new ResourseConflictException("Category ya registrado");
        }

        Category category = categoryMapper.toEntity(categoryDTO);
        category.setCategoryId(categoryDTO.getCategoryId());

        return categoryRepository.save(category);
    }

    public Category update(Long id, CategoryDTO categoryDTO){
        Category category = getById(id);

        if(category == null){
            throw new ResourceNotFoundException("Category no registrado");
        }

        Category categoryUpdate = categoryMapper.toEntity(categoryDTO);
        categoryUpdate.setCategoryId(categoryUpdate.getCategoryId());

        return categoryRepository.save(categoryUpdate);
    }

    public void delete (Long id){
        Category category = getById(id);

        if(category == null){
            throw new ResourceNotFoundException("Category no registrado");
        }

        categoryRepository.delete(category);
    }
}