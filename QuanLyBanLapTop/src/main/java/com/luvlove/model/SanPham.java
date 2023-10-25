package com.luvlove.model;

public class SanPham implements Comparable<SanPham>{
	private int ma_san_pham;
	private int danh_muc;
	private String hinh_anh;
	private String ten_san_pham;
	private int so_luong;
	private String mo_ta;
	private double don_gia;
	private int giam_gia;

	

	
	public SanPham(int ma_san_pham, int danh_muc, String hinh_anh, String ten_san_pham, int so_luong, String mo_ta,
			double don_gia, int giam_gia) {
		super();
		this.ma_san_pham = ma_san_pham;
		this.danh_muc = danh_muc;
		this.hinh_anh = hinh_anh;
		this.ten_san_pham = ten_san_pham;
		this.so_luong = so_luong;
		this.mo_ta = mo_ta;
		this.don_gia = don_gia;
		this.giam_gia = giam_gia;
	}
	
	

	public SanPham(int danh_muc, String hinh_anh, String ten_san_pham, int so_luong, String mo_ta, double donGia) {
		super();
		this.danh_muc = danh_muc;
		this.hinh_anh = hinh_anh;
		this.ten_san_pham = ten_san_pham;
		this.so_luong = so_luong;
		this.mo_ta = mo_ta;
		this.don_gia = donGia;
	}



	public void setDanh_muc(int danh_muc) {
		this.danh_muc = danh_muc;
	}

	public SanPham() {

	}

	public String getTen_san_pham() {
		return ten_san_pham;
	}

	public void setTen_san_pham(String ten_san_pham) {
		this.ten_san_pham = ten_san_pham;
	}

	

	public int getMa_san_pham() {
		return ma_san_pham;
	}

	public void setMa_san_pham(int ma_san_pham) {
		this.ma_san_pham = ma_san_pham;
	}


	public String getHinh_anh() {
		return hinh_anh;
	}

	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public int getDanh_muc() {
		return danh_muc;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public String getMo_ta() {
		return mo_ta;
	}

	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}

	public double getDon_gia() {
		return don_gia;
	}

	public void setDon_gia(double don_gia) {
		this.don_gia = don_gia;
	}

	public int getGiam_gia() {
		return giam_gia;
	}

	public void setGiam_gia(int giam_gia) {
		this.giam_gia = giam_gia;
	}

	@Override
	public int compareTo(SanPham o) {
		return (this.ma_san_pham)-(o.ma_san_pham);
	}



}
