package com.migi.springapi.service.impl;

import com.migi.springapi.dao.CategoryJPA;
import com.migi.springapi.entity.Category;
import com.migi.springapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryJPA categoryJPA;

    @Override
    public List<Category> getListCategory() {
        List<Category> lstCategory = categoryJPA.findAll();
        if(lstCategory == null || lstCategory.isEmpty()){
            throw new NullPointerException("Category is empty.");
        }
        return lstCategory;
    }

    @Override
    public void addCategory(Category category) {
        categoryJPA.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryJPA.save(category);
    }

    @Override
    public void deleteCategory(Integer categoryCode) {
        categoryJPA.deleteById(categoryCode);
    }
}
