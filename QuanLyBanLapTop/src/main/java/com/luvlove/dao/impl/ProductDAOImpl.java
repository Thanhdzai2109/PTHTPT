package com.luvlove.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.luvlove.dao.ProductDAO;
import com.luvlove.model.DanhMuc;
import com.luvlove.model.SanPham;
import com.luvlove.utils.DBConnect;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public ArrayList<SanPham> getList() {
		Connection cons = DBConnect.getConnecttion();
		String sql = "SELECT *FROM san_pham";
		ArrayList<SanPham> arr = new ArrayList<>();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setDanh_muc(rs.getInt("ma_danh_muc"));
				sp.setTen_san_pham(rs.getString("ten_san_pham"));
				sp.setHinh_anh(rs.getString("hinh_anh"));
				sp.setSo_luong(rs.getInt("so_luong"));
				sp.setMo_ta(rs.getString("mo_ta"));
				sp.setDon_gia(rs.getDouble("don_gia"));
				sp.setGiam_gia(rs.getInt("giam_gia"));
				arr.add(sp);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return arr;
	}

	@Override
	public Integer addSanPham(SanPham sanPham) {
		Connection cons = DBConnect.getConnecttion();
		StringBuilder sql = new StringBuilder(
				"INSERT INTO san_pham(ma_danh_muc,ten_san_pham,hinh_anh,so_luong,mo_ta,don_gia,giam_gia) ");
		sql.append("VALUES(?,?,?,?,?,?,?)");
		try {
			PreparedStatement statement = cons.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, sanPham.getDanh_muc());
			statement.setString(2, sanPham.getTen_san_pham());
			statement.setString(3, sanPham.getHinh_anh());
			statement.setInt(4, sanPham.getSo_luong());
			statement.setString(5, sanPham.getMo_ta());
			statement.setDouble(6, sanPham.getDon_gia());
			statement.setInt(7, sanPham.getGiam_gia());
			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SanPham> getListProductCategory(String ma_danh_muc) {
		Connection cons = DBConnect.getConnecttion();
		String sql = "SELECT *FROM san_pham WHERE ma_danh_muc='" + ma_danh_muc + "'";
		ArrayList<SanPham> arr = new ArrayList<>();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				/*
				 * DanhMuc dm=new DanhMuc(rs.getString("ma_danh_muc"), "", "");
				 * sp.setDanh_muc(dm)
				 */
				sp.setDanh_muc(rs.getInt("ma_danh_muc"));
				sp.setTen_san_pham(rs.getString("ten_san_pham"));
				sp.setHinh_anh(rs.getString("hinh_anh"));
				sp.setSo_luong(rs.getInt("so_luong"));
				sp.setMo_ta(rs.getString("mo_ta"));
				sp.setDon_gia(rs.getDouble("don_gia"));
				sp.setGiam_gia(rs.getInt("giam_gia"));
				arr.add(sp);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return arr;
	}

	@Override
	public ArrayList<SanPham> getListProduct(int ma_danh_muc) {
		Connection cons = DBConnect.getConnecttion();
		String sql = "SELECT *FROM san_pham WHERE ma_danh_muc='" + ma_danh_muc + "'";
		ArrayList<SanPham> arr = new ArrayList<>();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setDanh_muc(rs.getInt("ma_danh_muc"));
				sp.setTen_san_pham(rs.getString("ten_san_pham"));
				sp.setHinh_anh(rs.getString("hinh_anh"));
				sp.setSo_luong(rs.getInt("so_luong"));
				sp.setMo_ta(rs.getString("mo_ta"));
				sp.setDon_gia(rs.getDouble("don_gia"));
				sp.setGiam_gia(rs.getInt("giam_gia"));
				arr.add(sp);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return arr;
	}

	@Override
	public SanPham getChiTietSP(int ma_san_pham) {
		Connection cons = DBConnect.getConnecttion();
		String sql = "SELECT * FROM san_pham WHERE ma_san_pham='" + ma_san_pham + "'";
		SanPham sp = new SanPham();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setDanh_muc(rs.getInt("ma_danh_muc"));
				sp.setTen_san_pham(rs.getString("ten_san_pham"));
				sp.setHinh_anh(rs.getString("hinh_anh"));
				sp.setSo_luong(rs.getInt("so_luong"));
				sp.setMo_ta(rs.getString("mo_ta"));
				sp.setDon_gia(rs.getDouble("don_gia"));
				sp.setGiam_gia(rs.getInt("giam_gia"));

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return sp;
	}

	@Override
	public ArrayList<SanPham> getListBySearCh(String name) {
		Connection cons = DBConnect.getConnecttion();
		String sql = "SELECT *FROM san_pham WHERE ten_san_pham like '" + name + "%'";
		ArrayList<SanPham> arr = new ArrayList<>();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setDanh_muc(rs.getInt("ma_danh_muc"));
				sp.setTen_san_pham(rs.getString("ten_san_pham"));
				sp.setHinh_anh(rs.getString("hinh_anh"));
				sp.setSo_luong(rs.getInt("so_luong"));
				sp.setMo_ta(rs.getString("mo_ta"));
				sp.setDon_gia(rs.getDouble("don_gia"));
				sp.setGiam_gia(rs.getInt("giam_gia"));
				arr.add(sp);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return arr;

	}

	@Override
	public void update(SanPham sanPham) {
		Connection cons = DBConnect.getConnecttion();
		StringBuilder sql = new StringBuilder(
				"UPDATE san_pham SET ma_danh_muc = ?,ten_san_pham=?,so_luong=?,mo_ta=?,don_gia=? ");
		if (sanPham.getHinh_anh() != null) {
			sql.append(",hinh_anh=?");
		}
		sql.append("WHERE ma_san_pham = ?");
		try {
			PreparedStatement statement = cons.prepareStatement(sql.toString());
			statement.setInt(1, sanPham.getDanh_muc());
			statement.setString(2, sanPham.getTen_san_pham());

			statement.setInt(3, sanPham.getSo_luong());
			statement.setString(4, sanPham.getMo_ta());
			statement.setDouble(5, sanPham.getDon_gia());
			if (sanPham.getHinh_anh() != null) {
				statement.setString(6, sanPham.getHinh_anh());
				statement.setInt(7, sanPham.getMa_san_pham());
			} else {
				statement.setInt(6, sanPham.getMa_san_pham());
			}
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int maSanPham) {
		Connection cons = DBConnect.getConnecttion();
		StringBuilder sql = new StringBuilder("DELETE FROM san_pham WHERE ma_san_pham = ?");
		try {
			PreparedStatement statement = cons.prepareStatement(sql.toString());
			statement.setInt(1, maSanPham);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<SanPham> getListByLikeName(String nameFind) {
		Connection cons = DBConnect.getConnecttion();
		String sql = "SELECT *FROM san_pham WHERE ten_san_pham LIKE ?";
		ArrayList<SanPham> arr = new ArrayList<>();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setString(1, "%" + nameFind + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setDanh_muc(rs.getInt("ma_danh_muc"));
				sp.setTen_san_pham(rs.getString("ten_san_pham"));
				sp.setHinh_anh(rs.getString("hinh_anh"));
				sp.setSo_luong(rs.getInt("so_luong"));
				sp.setMo_ta(rs.getString("mo_ta"));
				sp.setDon_gia(rs.getDouble("don_gia"));
				sp.setGiam_gia(rs.getInt("giam_gia"));
				arr.add(sp);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return arr;
	}
}
