package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.reponsitory.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getAll(){
        return repository.findAll();
    }

    public Category getone(Long id){
        return repository.findById(id).orElse(null);
    }


    public void add(Category category){
         repository.save(category);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void update(Long id,Category category){
        Category category1 = repository.findById(id).get();
        if(category1 != null){
            category1.setCode(category.getCode());
            category1.setName(category.getName());
            repository.save(category1);
        }
    }
}
