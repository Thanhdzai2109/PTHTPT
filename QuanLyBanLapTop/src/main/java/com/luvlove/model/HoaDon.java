package com.luvlove.model;

import java.sql.Timestamp;

public class HoaDon {
      private String ma_hoa_don;
      private TaiKhoan tai_khoan;
      private String dia_chi_giao_hang;
      private String phuong_thuc_thanh_toan;
      private Timestamp ngay_mua_hang;
      private int tinh_trang_don_hang;
      private String so_dien_thoai;
      public HoaDon() {
    	  
      }
      
      



	public HoaDon(String ma_hoa_don, TaiKhoan tai_khoan, String dia_chi_giao_hang, String phuong_thuc_thanh_toan,
			Timestamp ngay_mua_hang, int tinh_trang_don_hang, String so_dien_thoai) {
		super();
		this.ma_hoa_don = ma_hoa_don;
		this.tai_khoan = tai_khoan;
		this.dia_chi_giao_hang = dia_chi_giao_hang;
		this.phuong_thuc_thanh_toan = phuong_thuc_thanh_toan;
		this.ngay_mua_hang = ngay_mua_hang;
		this.tinh_trang_don_hang = tinh_trang_don_hang;
		this.so_dien_thoai = so_dien_thoai;
	}





	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}





	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}





	public int getTinh_trang_don_hang() {
		return tinh_trang_don_hang;
	}
	public void setTinh_trang_don_hang(int tinh_trang_don_hang) {
		this.tinh_trang_don_hang = tinh_trang_don_hang;
	}
	public void setNgay_mua_hang(Timestamp ngay_mua_hang) {
		this.ngay_mua_hang = ngay_mua_hang;
	}
	public String getMa_hoa_don() {
		return ma_hoa_don;
	}
	public void setMa_hoa_don(String ma_hoa_don) {
		this.ma_hoa_don = ma_hoa_don;
	}
	public TaiKhoan getTai_khoan() {
		return tai_khoan;
	}
	public void setTai_khoan(TaiKhoan tai_khoan) {
		this.tai_khoan = tai_khoan;
	}
	public String getDia_chi_giao_hang() {
		return dia_chi_giao_hang;
	}
	public void setDia_chi_giao_hang(String dia_chi_giao_hang) {
		this.dia_chi_giao_hang = dia_chi_giao_hang;
	}
	public Timestamp getNgay_mua_hang() {
		return ngay_mua_hang;
	}
	public String getPhuong_thuc_thanh_toan() {
		return phuong_thuc_thanh_toan;
	}
	public void setPhuong_thuc_thanh_toan(String phuong_thuc_thanh_toan) {
		this.phuong_thuc_thanh_toan = phuong_thuc_thanh_toan;
	}

	
      
      
	
      
}
