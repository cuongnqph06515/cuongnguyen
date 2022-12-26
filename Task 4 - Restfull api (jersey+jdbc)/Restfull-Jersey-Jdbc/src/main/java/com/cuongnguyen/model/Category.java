package com.cuongnguyen.model;


public class Category {
	public int maloaihang;
	public String tenloaihang;
	
	public Category() {
	}
	
	public Category(int maloaihang, String tenloaihang) {
		this.maloaihang = maloaihang;
		this.tenloaihang = tenloaihang;
	}

	public int getMaloaihang() {
		return maloaihang;
	}
	public void setMaloaihang(int maloaihang) {
		this.maloaihang = maloaihang;
	}
	public String getTenloaihang() {
		return tenloaihang;
	}
	public void setTenloaihang(String tenloaihang) {
		this.tenloaihang = tenloaihang;
	}
}
