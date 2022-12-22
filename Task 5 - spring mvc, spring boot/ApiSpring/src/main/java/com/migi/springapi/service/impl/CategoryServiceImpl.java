package com.migi.springapi.service.impl;

import com.migi.springapi.dao.CategoryJPA;
import com.migi.springapi.entity.Category;
import com.migi.springapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryJPA categoryJPA;

    @Override
    public List<Category> getListCategory() throws NullPointerException {
        List<Category> lstCategory = categoryJPA.findAll();
        if(lstCategory == null || lstCategory.isEmpty()){
            throw new NullPointerException("Category is empty:");
        }
        return lstCategory;
    }

    @Override
    public Category getCategoryById(Integer categoryCode) throws NullPointerException{
        Category category=null;
        try {
            category = categoryJPA.findById(categoryCode).get();
        }catch(Exception e){
            throw new NullPointerException("Error in categoryService: "+ e.getMessage());
        }
        return category;
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
    public void deleteCategory(Integer categoryCode) throws Exception {
        try {
            categoryJPA.deleteById(categoryCode);
        }catch(Exception ex){
            throw new Exception("error:" +ex.getMessage());
        }
    }
}
