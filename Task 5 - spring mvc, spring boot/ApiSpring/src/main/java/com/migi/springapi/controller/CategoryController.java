package com.migi.springapi.controller;

import com.migi.springapi.entity.Category;
import com.migi.springapi.model.ApiResponse;
import com.migi.springapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService ;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllCategory(){
        return new ResponseEntity<ApiResponse>(categoryService.getListCategory(), HttpStatus.OK);
    }

    @GetMapping("/{categoryCode}")
    public ResponseEntity<ApiResponse> getAllCategoryById(@PathVariable("categoryCode") String categoryCode){
        return new ResponseEntity<ApiResponse>(categoryService.getCategoryById(categoryCode), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody Category objCategory) {
        return new ResponseEntity<ApiResponse>(categoryService.addCategory(objCategory), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse> updateCategory(@RequestBody Category objCategory){
        return new ResponseEntity<ApiResponse>(categoryService.updateCategory(objCategory), HttpStatus.OK);
    }

    @DeleteMapping("delete/{categoryCode}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryCode") String categoryCode) throws Exception {
        return new ResponseEntity<ApiResponse>(categoryService.deleteCategory(categoryCode), HttpStatus.OK);
    }
}
