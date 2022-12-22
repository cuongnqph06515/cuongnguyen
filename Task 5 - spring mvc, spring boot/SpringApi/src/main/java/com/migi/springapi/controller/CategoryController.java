package com.migi.springapi.controller;

import com.migi.springapi.entity.Category;
import com.migi.springapi.model.ApiResponse;
import com.migi.springapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllCategory(){
        ApiResponse apiResponse = new ApiResponse();
        List<Category> listCategory = categoryService.getListCategory();
        apiResponse.setData(listCategory);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}
