package com.iuminov.service;

import com.iuminov.dao.CategoryDao;
import com.iuminov.dao.CategoryDaoImpl;
import com.iuminov.model.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryDao.getById(id);
    }
}
