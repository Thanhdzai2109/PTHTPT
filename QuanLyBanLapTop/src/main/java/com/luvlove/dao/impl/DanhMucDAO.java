package com.luvlove.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.luvlove.model.DanhMuc;


public interface DanhMucDAO {
    // load danh muc cha
	public ArrayList<DanhMuc> getListDanhMucCha();
	public ArrayList<DanhMuc> getListDanhMucCon(String ma_danh_muc);
	public List<DanhMuc> getListByLikeName(String nameFind);
	public DanhMuc searchDanhMucByName(int madanhmuc);
	public boolean updateDM(int madanhmuc,String name);
	public boolean deleteDM(int madanhmuc);
	public boolean addDanhMuc(String name);
}
