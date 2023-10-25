package com.luvlove.model;

import java.sql.Date;

public class DetailHoaDon {
	private int IDHD;
	private String mataikhoan;
	private Date ngaymuahang;
	private String tensp;
	private int soluong;
	private int dongia;
	private String diachigiaohang;
	private String sdt;

	public DetailHoaDon() {

	}

	public DetailHoaDon(int iDHD, String mataikhoan, Date ngaymuahang, String tensp, int soluong, int dongia,
			String diachigiaohang, String sdt) {
		super();
		IDHD = iDHD;
		this.mataikhoan = mataikhoan;
		this.ngaymuahang = ngaymuahang;
		this.tensp = tensp;
		this.soluong = soluong;
		this.dongia = dongia;
		this.diachigiaohang = diachigiaohang;
		this.sdt = sdt;
	}
	
	public String getDiachigiaohang() {
		return diachigiaohang;
	}

	public void setDiachigiaohang(String diachigiaohang) {
		this.diachigiaohang = diachigiaohang;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getIDHD() {
		return IDHD;
	}

	public void setIDHD(int iDHD) {
		IDHD = iDHD;
	}

	public String getMataikhoan() {
		return mataikhoan;
	}

	public void setMataikhoan(String mataikhoan) {
		this.mataikhoan = mataikhoan;
	}

	public Date getNgaymuahang() {
		return ngaymuahang;
	}

	public void setNgaymuahang(Date ngaymuahang) {
		this.ngaymuahang = ngaymuahang;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getDongia() {
		return dongia;
	}

	public void setDongia(int dongia) {
		this.dongia = dongia;
	}

    @Override
    public String toString() {
        return "DetailHoaDon{" + "IDHD=" + IDHD + ", mataikhoan=" + mataikhoan + ", ngaymuahang=" + ngaymuahang + ", tensp=" + tensp + ", soluong=" + soluong + ", dongia=" + dongia + ", diachigiaohang=" + diachigiaohang + ", sdt=" + sdt + '}';
    }

}
