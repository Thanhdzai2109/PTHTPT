package com.luvlove.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.luvlove.model.DanhMuc;
import com.luvlove.model.SanPham;
import com.luvlove.utils.DBConnect;

public class DanhMucDAOImpl implements DanhMucDAO{

	
	public ArrayList<DanhMuc> getListDanhMucCha() {
		Connection connection=DBConnect.getConnecttion();
		String sql="SELECT *FROM danh_muc";
		ArrayList<DanhMuc> arr=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				DanhMuc dm=new DanhMuc();
				dm.setMa_danh_muc(rs.getInt("ma_danh_muc"));
				dm.setTen_danh_muc(rs.getString("ten_danh_muc"));
				dm.setDanh_muc_cha(rs.getString("danh_muc_cha"));
				arr.add(dm);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		return arr;
		
	}

	@Override
	public ArrayList<DanhMuc> getListDanhMucCon(String ma_danh_muc) {
		Connection connection=DBConnect.getConnecttion();
		String sql="SELECT *FROM danh_muc WHERE danh_muc_cha='"+ma_danh_muc+"'";
		ArrayList<DanhMuc> arr=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs1=ps.executeQuery();
			while(rs1.next()) {
				DanhMuc dm=new DanhMuc();
				dm.setMa_danh_muc(rs1.getInt("ma_danh_muc"));
				dm.setTen_danh_muc(rs1.getString("ten_danh_muc"));
				dm.setDanh_muc_cha(rs1.getString("danh_muc_cha"));
				arr.add(dm);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		return arr;
		
	}

	@Override
	public List<DanhMuc> getListByLikeName(String nameFind) {
		Connection cons = DBConnect.getConnecttion();
		String sql = "SELECT *FROM danh_muc WHERE ten_danh_muc LIKE ?";
		ArrayList<DanhMuc> arr = new ArrayList<>();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setString(1, "%" + nameFind + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DanhMuc dm = new DanhMuc();
				dm.setMa_danh_muc(rs.getInt("ma_danh_muc"));
				dm.setDanh_muc_cha(rs.getString("danh_muc_cha"));
				dm.setTen_danh_muc(rs.getString("ten_danh_muc"));
				arr.add(dm);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return arr;
	}

	@Override
	public DanhMuc searchDanhMucByName(int madanhmuc) {
		Connection connection=DBConnect.getConnecttion();
		DanhMuc dm=new DanhMuc();
		String sql="SELECT *FROM danh_muc WHERE ma_danh_muc='"+madanhmuc+"'";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs1=ps.executeQuery();
			while(rs1.next()) {
				dm.setMa_danh_muc(rs1.getInt("ma_danh_muc"));
				dm.setTen_danh_muc(rs1.getString("ten_danh_muc"));
				dm.setDanh_muc_cha(rs1.getString("danh_muc_cha"));
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		return dm;
	}

	@Override
	public boolean updateDM(int madanhmuc,String name) {
		Connection connection=DBConnect.getConnecttion();
		DanhMuc dm=new DanhMuc();
		int i=0;
		String sql="UPDATE danh_muc set ten_danh_muc='"+name+"' WHERE ma_danh_muc='"+madanhmuc+"'";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			i = ps.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		return false;
		
	}

	@Override
	public boolean deleteDM(int madanhmuc) {
		Connection cons = DBConnect.getConnecttion();
		StringBuilder sql = new StringBuilder("DELETE FROM danh_muc WHERE ma_danh_muc = ?");
		try {
			PreparedStatement statement = cons.prepareStatement(sql.toString());
			statement.setInt(1, madanhmuc);
			int i=statement.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean addDanhMuc(String name) {
		Connection cons = DBConnect.getConnecttion();
//		StringBuilder sql = new StringBuilder("INSERT INTO danh_muc(ma_danh_muc,ten_danh_muc) values('0','"+name+"')");
                 StringBuilder sql = new StringBuilder("INSERT INTO danh_muc(ten_danh_muc) values('"+name+"')");
		try {
			PreparedStatement statement = cons.prepareStatement(sql.toString());
			int i=statement.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
  
}
