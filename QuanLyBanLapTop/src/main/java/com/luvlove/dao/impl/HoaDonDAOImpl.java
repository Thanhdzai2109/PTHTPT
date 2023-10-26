package com.luvlove.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.luvlove.dao.HoaDonDAO;
import com.luvlove.model.DanhMuc;
import com.luvlove.model.DetailHoaDon;
import com.luvlove.model.HoaDon;
import com.luvlove.utils.DBConnect;

public class HoaDonDAOImpl implements HoaDonDAO{

	@Override
	public void themHoaDon(HoaDon hd) {
		Connection cnn=DBConnect.getConnecttion();
		String sql="INSERT INTO hoa_don values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1, hd.getMa_hoa_don());
			ps.setString(2,hd.getTai_khoan().getTen_dang_nhap());
			ps.setString(3,hd.getDia_chi_giao_hang());
			ps.setString(4,hd.getPhuong_thuc_thanh_toan());
			ps.setTimestamp(5,hd.getNgay_mua_hang());
			ps.setInt(6,hd.getTinh_trang_don_hang());
			ps.setString(7,hd.getSo_dien_thoai());
			ps.executeUpdate();
			cnn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<DetailHoaDon> getListHD() {
		Connection connection=DBConnect.getConnecttion();
		String sql="SELECT *FROM chi_tiet_hoa_don LEFT JOIN hoa_don on chi_tiet_hoa_don.ma_hoa_don=hoa_don.ma_hoa_don LEFT JOIN san_pham on chi_tiet_hoa_don.ma_san_pham=san_pham.ma_san_pham";
		ArrayList<DetailHoaDon> arr=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				DetailHoaDon dm=new DetailHoaDon();
				dm.setIDHD(0);
				dm.setMataikhoan(rs.getString("ma_tai_khoan"));
				dm.setTensp(rs.getString("ten_san_pham"));
				dm.setDongia(rs.getInt("don_gia"));
				dm.setNgaymuahang(rs.getDate("ngay_mua_hang"));
				dm.setSoluong(rs.getInt("so_luong"));
				dm.setDiachigiaohang(rs.getString("dia_chi_giao_hang"));
				dm.setSdt(rs.getString("so_dien_thoai"));
				arr.add(dm);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		return arr;
	}
        @Override
        public List<DetailHoaDon> getListHDmember(String user) {
		Connection connection=DBConnect.getConnecttion();
		String sql="SELECT *FROM chi_tiet_hoa_don LEFT JOIN hoa_don on chi_tiet_hoa_don.ma_hoa_don=hoa_don.ma_hoa_don LEFT JOIN san_pham on chi_tiet_hoa_don.ma_san_pham=san_pham.ma_san_pham  join  tai_khoan on hoa_don.ma_tai_khoan = '"+user+"'";
		ArrayList<DetailHoaDon> arr=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				DetailHoaDon dm=new DetailHoaDon();
				dm.setIDHD(0);
				dm.setMataikhoan(rs.getString("ma_tai_khoan"));
				dm.setTensp(rs.getString("ten_san_pham"));
				dm.setDongia(rs.getInt("don_gia"));
				dm.setNgaymuahang(rs.getDate("ngay_mua_hang"));
				dm.setSoluong(rs.getInt("so_luong"));
				dm.setDiachigiaohang(rs.getString("dia_chi_giao_hang"));
     	     	dm.setSdt(rs.getString("so_dien_thoai"));
				arr.add(dm);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return arr;
	}
   
}
