package com.migi.springapi.controller;

import com.migi.springapi.entity.Category;
import com.migi.springapi.model.ApiResponse;
import com.migi.springapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllCategory(){
        ApiResponse apiResponse = new ApiResponse();
        List<Category> listCategory = null;
        try {
            listCategory = categoryService.getListCategory();
        }catch (Exception e){
            apiResponse.setError(e.getMessage());
        }
        apiResponse.setData(listCategory);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{categoryCode}")
    public ResponseEntity<ApiResponse> getAllCategory(@PathVariable("categoryCode") String categoryCode){
        ApiResponse apiResponse = new ApiResponse();
        Category category=null;
        try {
            Integer code = Integer.parseInt(categoryCode);
            category = categoryService.getCategoryById(code);
        }catch(Exception ex){
            apiResponse.setError(ex.getMessage());
        }
        apiResponse.setData(category);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody Category category){
        ApiResponse apiResponse = new ApiResponse();
        if(category.getCategoryCode()!=null && category.getCategoryName()!=null){
            categoryService.addCategory(category);
        }else{
            apiResponse.setError("error: categoryCode or categoryName is null");
        }

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<ApiResponse> updateCategory(@RequestBody Category category){
        ApiResponse apiResponse = new ApiResponse();
        if(category.getCategoryCode()!=null && category.getCategoryName()!=null){
            categoryService.updateCategory(category);
        }else{
            apiResponse.setError("error: categoryCode or categoryName is null");
        }
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("delete/{categoryCode}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryCode") String categoryCode) throws Exception {
        ApiResponse apiResponse = new ApiResponse();
        try {
            Integer code = Integer.parseInt(categoryCode);
            categoryService.deleteCategory(code);
        }catch(Exception ex){
            apiResponse.setError(ex.getMessage());
        }
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}
