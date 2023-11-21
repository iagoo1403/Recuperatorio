package com.utn.k8.Preenunciado.mapppers;

import com.utn.k8.Preenunciado.dtos.CategoryDTO;
import com.utn.k8.Preenunciado.entidades.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CategoryMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CategoryDTO toDto(Category category){
        return Objects.isNull(category) ? null : modelMapper.map(category, CategoryDTO.class);
    }

    public Category toEntity(CategoryDTO categoryDTO){
        return Objects.isNull(categoryDTO) ? null : modelMapper.map(categoryDTO, Category.class);
    }
}