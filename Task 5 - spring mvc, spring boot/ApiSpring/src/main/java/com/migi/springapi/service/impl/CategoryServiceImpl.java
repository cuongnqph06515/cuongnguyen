package com.migi.springapi.service.impl;

import com.migi.springapi.dao.CategoryJPA;
import com.migi.springapi.entity.Category;
import com.migi.springapi.model.ApiResponse;
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
    public ApiResponse getListCategory() throws NullPointerException {
        ApiResponse apiResponse = new ApiResponse();
        List<Category> listCategory = null;
        try {
            listCategory = categoryJPA.findAll();
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
        return apiResponse;
    }

    @Override
    public ApiResponse getCategoryById(String categoryCode){
        ApiResponse apiResponse = new ApiResponse();
        Category category=null;
        try {
            Integer code = Integer.parseInt(categoryCode);
            category = categoryJPA.findById(code).get();
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
        return apiResponse;
    }

    @Override
    public ApiResponse addCategory(Category category) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setStatus(false);
            if(category.getCategoryCode()==null || category.getCategoryName().equals("")){
                apiResponse.setMessage("Mã loại và tên loại không thể để trống");
            }else if(getCategoryById(String.valueOf(category.getCategoryCode())).getData()  != null){
                apiResponse.setMessage("Mã loại hàng đã tồn tại");
            }else{
                categoryJPA.save(category);
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
        return apiResponse;
    }

    @Override
    public ApiResponse updateCategory(Category objCategory) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setStatus(false);
            if(objCategory.getCategoryCode()==null || objCategory.getCategoryName().equals("")){
                apiResponse.setMessage("Mã loại và tên loại không đc trống");
            }else if(getCategoryById(String.valueOf(objCategory.getCategoryCode())).getData() == null){
                apiResponse.setMessage("Mã loại hàng không tồn tại");
            }else{
                categoryJPA.save(objCategory);
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
        return apiResponse;
    }

    @Override
    public ApiResponse deleteCategory(String categoryCode) throws Exception {
        ApiResponse apiResponse = new ApiResponse();
        try {
            Integer code = Integer.parseInt(categoryCode);
            categoryJPA.deleteById(code);
            apiResponse.setCode(200);
            apiResponse.setMessage("Xóa loại hàng thành công");
            apiResponse.setError("");
            apiResponse.setStatus(true);
        }catch(Exception ex){
            apiResponse.setError(ex.getMessage());
            apiResponse.setMessage("Xóa loại hàng thất bại");
            apiResponse.setStatus(false);
        }
        return apiResponse;
    }
}
