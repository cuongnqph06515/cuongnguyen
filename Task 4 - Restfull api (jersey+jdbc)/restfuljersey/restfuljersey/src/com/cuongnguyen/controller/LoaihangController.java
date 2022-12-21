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

import com.cuongnguyen.dao.loaihangDAO;
import com.cuongnguyen.models.loaihang;

@Path("/loaihang")
public class LoaihangController {
	private loaihangDAO dao = loaihangDAO.getInstace();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<loaihang> getListLoaihang(){
		try {
			return dao.getLoaiHang();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateLoaiHang(loaihang lhang) {
		try {
			if(lhang != null) {
				dao.updateLoaiHang(lhang);
			}else {
				throw new NullPointerException("Loai hang null");
			}
		} catch (SQLException e) {
			e.getMessage();
		}
	}
	
	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void addLoaiHang(loaihang lhang) {
		try {
			if(lhang != null) {
				dao.addLoaiHang(lhang);
			}else {
				throw new NullPointerException("Loai hang null");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@DELETE
	@Path("/delete/{maloaihang}")
	public void addLoaiHang(@PathParam("maloaihang") Integer maLoaiHang) {
		try {
			if(maLoaiHang != null) {
				dao.deleteLoaiHang(maLoaiHang);
			}else {
				throw new NullPointerException("ma loai hang null");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
