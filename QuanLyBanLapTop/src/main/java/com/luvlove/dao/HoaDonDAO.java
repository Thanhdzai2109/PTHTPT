package com.luvlove.dao;

import java.util.List;

import com.luvlove.model.DetailHoaDon;
import com.luvlove.model.HoaDon;

public interface HoaDonDAO {
 public void themHoaDon(HoaDon hd);
 public List<DetailHoaDon> getListHD();
 public List<DetailHoaDon>getListHDmember(String user);
}
