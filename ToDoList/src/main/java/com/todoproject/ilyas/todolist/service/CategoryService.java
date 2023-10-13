package com.todoproject.ilyas.todolist.service;

import com.todoproject.ilyas.todolist.entity.Category;
import com.todoproject.ilyas.todolist.repo.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service


@Transactional
public class CategoryService {


    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Cacheable(cacheNames = "categories")
    public List<Category> findAll(String email) {
        return repository.findByUserEmailOrderByTitleAsc(email);
    }

    public Category add(Category category) {
        return repository.save(category);
    }

    public Category update(Category category) {
        return repository.save(category);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // поиск категорий пользователя по названию
    public List<Category> findByTitle(String text, String email) {
        return repository.findByTitle(text, email);
    }

    // поиск категории по ID
    public Category findById(Long id) {
        return repository.findById(id).get();
    }

    public Category findAllCat() {
        return (Category) repository.findAll();
    }


}
