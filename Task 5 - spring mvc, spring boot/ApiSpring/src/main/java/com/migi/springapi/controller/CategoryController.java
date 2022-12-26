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
            apiResponse.setCode(200);
            apiResponse.setStatus(true);
            apiResponse.setMessage("Lấy thông tin loại hàng thành công");
            apiResponse.setError("");
            apiResponse.setData(listCategory);
        }catch (Exception e){
            apiResponse.setError(e.getMessage());
            apiResponse.setMessage("Lấy thông tin loại hàng thất bại");
            apiResponse.setStatus(false);
        }
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{categoryCode}")
    public ResponseEntity<ApiResponse> getAllCategory(@PathVariable("categoryCode") String categoryCode){
        ApiResponse apiResponse = new ApiResponse();
        Category category=null;
        try {
            Integer code = Integer.parseInt(categoryCode);
            category = categoryService.getCategoryById(code);
            apiResponse.setCode(200);
            apiResponse.setMessage("Lấy thông tin loại hàng thành công");
            apiResponse.setError("");
            apiResponse.setStatus(true);
            apiResponse.setData(category);
        }catch(Exception ex){
            apiResponse.setError(ex.getLocalizedMessage());
            apiResponse.setMessage("Lấy thông tin loại hàng thất bại");
            apiResponse.setStatus(false);
        }
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody Category objCategory) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setStatus(false);
            if(objCategory.getCategoryCode()==null || objCategory.getCategoryName().equals("")){
                apiResponse.setMessage("Mã loại và tên loại không thể để trống");
            }else if(categoryService.getCategoryById(objCategory.getCategoryCode()) != null){
                apiResponse.setMessage("Mã loại hàng đã tồn tại");
            }else{
                categoryService.addCategory(objCategory);
                apiResponse.setCode(200);
                apiResponse.setMessage("Thêm loại hàng thành công");
                apiResponse.setError("");
                apiResponse.setStatus(true);
            }
        }
        catch (Exception ex){
            apiResponse.setError(ex.getMessage());
            apiResponse.setMessage("Thêm loại hàng thất bại");
        }
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse> updateCategory(@RequestBody Category objCategory){
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setStatus(false);
            if(objCategory.getCategoryCode()==null || objCategory.getCategoryName().equals("")){
                apiResponse.setMessage("Mã loại và tên loại không đc trống");
            }else if(categoryService.getCategoryById(objCategory.getCategoryCode()) == null){
                apiResponse.setMessage("Mã loại hàng không tồn tại");
            }else{
                categoryService.addCategory(objCategory);
                apiResponse.setCode(200);
                apiResponse.setMessage("Cập nhật loại hàng thành công");
                apiResponse.setError("");
                apiResponse.setStatus(true);
            }
        }
        catch (Exception ex){
            apiResponse.setError(ex.getMessage());
            apiResponse.setMessage("Cập nhật loại hàng thất bại");
        }
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("delete/{categoryCode}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryCode") String categoryCode) throws Exception {
        ApiResponse apiResponse = new ApiResponse();
        try {
            Integer code = Integer.parseInt(categoryCode);
            categoryService.deleteCategory(code);
            apiResponse.setCode(200);
            apiResponse.setMessage("Xóa loại hàng thành công");
            apiResponse.setError("");
            apiResponse.setStatus(true);
        }catch(Exception ex){
            apiResponse.setError(ex.getMessage());
            apiResponse.setMessage("Xóa loại hàng thất bại");
            apiResponse.setStatus(false);
        }
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}
