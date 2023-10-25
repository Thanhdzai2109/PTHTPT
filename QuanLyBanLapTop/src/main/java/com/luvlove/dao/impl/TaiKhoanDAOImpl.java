package com.luvlove.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.mindrot.jbcrypt.BCrypt;
import com.luvlove.dao.TaiKhoanDAO;
import com.luvlove.model.DanhMuc;
import com.luvlove.model.TaiKhoan;
import com.luvlove.utils.DBConnect;

public class TaiKhoanDAOImpl implements TaiKhoanDAO{

	@Override
	public boolean checkUser(String user) {
		Connection cnn=DBConnect.getConnecttion();
		String sql="SELECT *FROM tai_khoan where ten_dang_nhap ='"+user+"'";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				return true;
			}
			cnn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public ArrayList<TaiKhoan> getAll() {
		Connection connection=DBConnect.getConnecttion();
		String sql="SELECT *FROM tai_khoan";
		ArrayList<TaiKhoan> arr=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				TaiKhoan tk=new TaiKhoan();
				tk.setMa_tai_khoan(rs.getInt("ma_tai_khoan"));
				tk.setTen_dang_nhap(rs.getString("ten_dang_nhap"));
				tk.setQuyen_truy_cap(rs.getInt("quyen_truy_cap"));
				arr.add(tk);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		return arr;
		
	}
	public void AddUser(TaiKhoan tk) {
		Connection cnn=DBConnect.getConnecttion();
		String hash = BCrypt.hashpw(tk.getMat_khau(), BCrypt.gensalt(12));
		String sql="INSERT INTO tai_khoan(ten_tai_khoan,ten_dang_nhap,mat_khau,quyen_truy_cap,tinh_trang) values (?,?,?,?,?)";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setString(1,tk.getTen_dang_nhap());
			ps.setString(2,tk.getTen_tai_khoan());
			ps.setString(3,hash);
		    ps.setInt(4, tk.getQuyen_truy_cap());
			ps.setInt(5,tk.getTinh_trang());
			ps.executeUpdate();
			cnn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public boolean checkLogin(String username,String pass) {
		Connection cnn=DBConnect.getConnecttion();
		String sql="SELECT *FROM tai_khoan where ten_dang_nhap='"+username+"'";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 if (BCrypt.checkpw(pass, rs.getString("mat_khau"))) {
					 return true;
				 }
			}
			cnn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}
	@Override
	public TaiKhoan timTaiKhoan(String id) {
		Connection cnn=DBConnect.getConnecttion();
		String sql="SELECT *FROM tai_khoan where ten_dang_nhap='"+id+"'";
		TaiKhoan tk=new TaiKhoan();
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				tk.setQuyen_truy_cap(rs.getInt("quyen_truy_cap"));
				tk.setMa_tai_khoan(rs.getInt("ma_tai_khoan"));
				tk.setTen_dang_nhap(rs.getString("ten_dang_nhap"));
				tk.setTinh_trang(rs.getInt("tinh_trang"));
			}
			cnn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tk;
	}
	@Override
	public boolean suaTaiKhoan(TaiKhoan tk) {
		Connection cons = DBConnect.getConnecttion();
		int kt=0;
		StringBuilder sql = new StringBuilder("UPDATE tai_khoan SET ten_dang_nhap=?,quyen_truy_cap=? WHERE ma_tai_khoan = ?");
	
		
		try {
			PreparedStatement statement = cons.prepareStatement(sql.toString());
			statement.setString(1, tk.getTen_dang_nhap());
			statement.setInt(2,tk.getQuyen_truy_cap());
			statement.setInt(3,tk.getMa_tai_khoan());
			kt=statement.executeUpdate();
			if(kt>0){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return false;
	}
	@Override
	public boolean deleteTaiKhoan(int taikhoan) {
		Connection cons = DBConnect.getConnecttion();
		StringBuilder sql = new StringBuilder("DELETE FROM tai_khoan WHERE ma_tai_khoan = ?");
		try {
			PreparedStatement statement = cons.prepareStatement(sql.toString());
			statement.setInt(1, taikhoan);
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
	public TaiKhoan getTaiKhoanByWhere(int id) {
		Connection cnn=DBConnect.getConnecttion();
		String sql="SELECT *FROM tai_khoan where ma_tai_khoan='"+id+"'";
		TaiKhoan tk=new TaiKhoan();
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				tk.setQuyen_truy_cap(rs.getInt("quyen_truy_cap"));
				tk.setMa_tai_khoan(rs.getInt("ma_tai_khoan"));
				tk.setTen_dang_nhap(rs.getString("ten_dang_nhap"));
			}
			cnn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tk;
	}
	@Override
	public ArrayList getTaiKhoanByLike(String id) {
		Connection cnn=DBConnect.getConnecttion();
		String sql="SELECT *FROM tai_khoan where ten_dang_nhap LIKE '"+id+"%'";
		System.out.println(sql);
		
		ArrayList<TaiKhoan> arr=new ArrayList<>();
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				TaiKhoan tk=new TaiKhoan();
				tk.setQuyen_truy_cap(rs.getInt("quyen_truy_cap"));
				tk.setMa_tai_khoan(rs.getInt("ma_tai_khoan"));
				tk.setTen_dang_nhap(rs.getString("ten_dang_nhap"));
				arr.add(tk);
			}
			cnn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}
	@Override
	public void upDateStatus(String id) {
		Connection cons = DBConnect.getConnecttion();
		StringBuilder sql = new StringBuilder("UPDATE tai_khoan SET tinh_trang='1' WHERE ten_dang_nhap ='"+id+"'");
		try {
			PreparedStatement statement = cons.prepareStatement(sql.toString());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Override
	public void remoStatus(String id) {
		Connection cons = DBConnect.getConnecttion();
		StringBuilder sql = new StringBuilder("UPDATE tai_khoan SET tinh_trang='0' WHERE ten_dang_nhap ='"+id+"'");
		try {
			PreparedStatement statement = cons.prepareStatement(sql.toString());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	
}
