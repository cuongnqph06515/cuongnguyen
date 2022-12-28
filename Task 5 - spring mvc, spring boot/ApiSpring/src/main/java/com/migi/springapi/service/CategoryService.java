package com.migi.springapi.service;

import com.migi.springapi.dao.CategoryJPA;
import com.migi.springapi.entity.Category;
import com.migi.springapi.model.ApiResponse;

import java.util.List;

public interface CategoryService {
    public ApiResponse getListCategory();
    public ApiResponse getCategoryById(String categoryCode);
    public ApiResponse addCategory(Category category);
    public ApiResponse updateCategory(Category category);
    public ApiResponse deleteCategory(String categoryCode) throws Exception;
}
