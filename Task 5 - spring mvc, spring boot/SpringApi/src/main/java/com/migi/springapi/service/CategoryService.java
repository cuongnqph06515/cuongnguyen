package com.migi.springapi.service;

import com.migi.springapi.dao.CategoryJPA;
import com.migi.springapi.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getListCategory();
    public void addCategory(Category category);
    public void updateCategory(Category category);
    public void deleteCategory(Integer categoryCode);
}
