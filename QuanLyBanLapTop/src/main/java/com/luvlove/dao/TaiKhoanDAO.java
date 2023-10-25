package com.luvlove.dao;

import java.util.ArrayList;

import com.luvlove.model.TaiKhoan;

public interface TaiKhoanDAO {
      public boolean checkUser(String user);
      public TaiKhoan timTaiKhoan(String id);
      public TaiKhoan getTaiKhoanByWhere(int id);
      public ArrayList getTaiKhoanByLike(String id);
      public boolean suaTaiKhoan(TaiKhoan tk);
      public boolean deleteTaiKhoan(int taikhoan);
      public ArrayList<TaiKhoan> getAll();
      public void AddUser(TaiKhoan tk); 
      public void upDateStatus(String id);
      public void remoStatus(String id);
}
