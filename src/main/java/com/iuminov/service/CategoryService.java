package com.iuminov.service;

import com.iuminov.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category getById(Long id);
}
