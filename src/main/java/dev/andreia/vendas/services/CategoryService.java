package dev.andreia.vendas.services;

import dev.andreia.vendas.entities.Category;
import dev.andreia.vendas.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> opt = categoryRepository.findById(id);
        return opt.get();
    }
}
