package com.luvlove.dao;

import java.util.ArrayList;
import java.util.List;

import com.luvlove.model.DanhMuc;
import com.luvlove.model.SanPham;

public interface ProductDAO {
	public ArrayList<SanPham> getList();

	public ArrayList<SanPham> getListProductCategory(String ma_danh_muc);

	public ArrayList<SanPham> getListProduct(int ma_danh_muc);

	public Integer addSanPham(SanPham sanPham);

	public SanPham getChiTietSP(int ma_san_pham);

	public ArrayList<SanPham> getListBySearCh(String name);

	public void update(SanPham sanPham);

	public void delete(int maSanPham);
	
	public ArrayList<SanPham> getListByLikeName(String nameFind);
}
