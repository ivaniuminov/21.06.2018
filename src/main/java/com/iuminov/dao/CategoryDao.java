package com.iuminov.dao;

import com.iuminov.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getAll();

    Category getById(Long id);
}
