package com.cuongnguyen.models;


public class loaihang {
	public int maloaihang;
	public String tenloaihang;
	
	public loaihang() {
	}
	
	public loaihang(int maloaihang, String tenloaihang) {
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
