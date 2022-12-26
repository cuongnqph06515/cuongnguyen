package com.cuongnguyen.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.cuongnguyen.dao.impl.CategoryDAO;
import com.cuongnguyen.model.ApiResponse;
import com.cuongnguyen.model.Category;
import com.google.protobuf.Api;
import com.google.protobuf.ApiOrBuilder;


@Path("/category")
public class CategoryController {
	private static final Logger logger = Logger.getLogger(CategoryController.class);
	private CategoryDAO dao = CategoryDAO.getInstace();
	private ApiResponse apiResponse = new ApiResponse();
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	public ApiResponse getListCategory(){
		List<Category> lstCategory = null;
		try {
			lstCategory = dao.getCategory();
			apiResponse.setData(lstCategory);
			apiResponse.setCode(200);
			apiResponse.setStatus(true);
			apiResponse.setError("");
			apiResponse.setMessage("Lấy thông tin loại hàng thành công");
		} catch (SQLException e) {
			logger.error("err getlistCategory() in CategoryController: ", e);
			apiResponse.setError(e.getMessage());
			apiResponse.setStatus(false);
			apiResponse.setMessage("Lấy thông tin loại hàng thất bại");
		}
		return apiResponse;
	}
	
	@GET
	@Path("/{categoryCode}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ApiResponse getCategoryById(@PathParam("categoryCode") String code) {
		Category category = null;
		try {
			Integer categoryCode = Integer.parseInt(code);
			category =  dao.getCategoryById(categoryCode);
			apiResponse.setData(category);
			apiResponse.setCode(200);
			apiResponse.setStatus(true);
			apiResponse.setError("");
			apiResponse.setMessage("Lấy thông tin loại hàng thành công");
			if(category==null) {
				apiResponse.setMessage("Không có loại hàng phù hợp");
			}
		} catch (Exception e) {
			logger.error("err getCategoryById() in CategoryController: ", e);
			apiResponse.setError(e.getMessage());
			apiResponse.setStatus(false);
			apiResponse.setMessage("Lấy thông tin loại hàng thất bại");
		}
		return apiResponse;
	}
	
	@PUT
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ApiResponse updateCategory(Category category) {
		try {
			apiResponse.setStatus(false);
			if(category.getTenloaihang().equals("")) {
				apiResponse.setMessage("Mã loại hàng & tên loại hàng không được trống");
			}else if(dao.getCategoryById(category.getMaloaihang())== null) {
				apiResponse.setMessage("Mã loại hàng không chính xác");
			}else {
				dao.addCategory(category);
				apiResponse.setCode(200);
				apiResponse.setStatus(true);
				apiResponse.setError("");
				apiResponse.setMessage("Cập nhật loại hàng thành công");
			}
			
		} catch (Exception e) {
			logger.error("err updateCategory() in CategoryController: ", e);
			apiResponse.setError(e.getMessage());
			apiResponse.setStatus(false);
			apiResponse.setMessage("Cập nhật loại hàng thất bại");
		}
		return apiResponse;
	}
	
	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ApiResponse addCategory(Category category) {
		try {
			apiResponse.setStatus(false);
			if(category.getTenloaihang().equals("")) {
				apiResponse.setMessage("Mã loại hàng & tên loại hàng không được trống");
			}else if(dao.getCategoryById(category.getMaloaihang())!= null) {
				apiResponse.setMessage("Mã loại hàng đã tồn tại");
			}else {
				dao.addCategory(category);
				apiResponse.setCode(200);
				apiResponse.setStatus(true);
				apiResponse.setError("");
				apiResponse.setMessage("Thêm mới loại hàng thành công");
			}
			
		} catch (Exception e) {
			logger.error("err addCategory() in CategoryController: ", e);
			apiResponse.setError(e.getMessage());
			apiResponse.setStatus(false);
			apiResponse.setMessage("Thêm loại hàng thất bại");
		}
		return apiResponse;
	}
	
	@DELETE
	@Path("/delete/{categoryCode}")
	@Produces({ MediaType.APPLICATION_JSON})
	public ApiResponse deleteCategory(@PathParam("categoryCode") String code) {
		try {
			Integer categoryCode = Integer.parseInt(code);
			dao.deleteCategory(categoryCode);
			apiResponse.setCode(200);
			apiResponse.setStatus(true);
			apiResponse.setError("");
			apiResponse.setMessage("Xóa loại hàng thành công");
		} catch (Exception e) {
			logger.error("err deleteCategory() in CategoryController: ", e);
			apiResponse.setError(e.getMessage());
			apiResponse.setStatus(false);
			apiResponse.setMessage("Xóa loại hàng thất bại");
		}
		return apiResponse;
	}
}
