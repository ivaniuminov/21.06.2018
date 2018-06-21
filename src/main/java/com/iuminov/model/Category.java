package com.iuminov.model;

import java.util.List;

public class Category {
    private Long id;
    private String categoryName;
    private String description;
    private List<Product> productList;

    public Category() {
    }

    public Category(Long id, String categoryName, String description, List<Product> productList) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.productList = productList;
    }

    public Category(String categoryName, String description, List<Product> productList) {
        this.categoryName = categoryName;
        this.description = description;
        this.productList = productList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
