package com.iuminov.service;

import com.iuminov.dao.CategoryDao;
import com.iuminov.dao.CategoryDaoImpl;
import com.iuminov.model.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }
}
