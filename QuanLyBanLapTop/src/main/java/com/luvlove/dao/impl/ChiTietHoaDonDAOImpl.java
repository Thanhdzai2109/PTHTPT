package com.luvlove.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.luvlove.dao.ChiTietHoaDonDAO;
import com.luvlove.model.ChiTietHoaDon;
import com.luvlove.utils.DBConnect;

public class ChiTietHoaDonDAOImpl implements ChiTietHoaDonDAO{

	@Override
	public void themChiTietHD(ChiTietHoaDon chitiet) {
		Connection cnn=DBConnect.getConnecttion();
		String sql="INSERT INTO chi_tiet_hoa_don values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps=cnn.prepareStatement(sql);
			ps.setInt(1, chitiet.getMa_chi_tiet_hoa());
                        System.out.println(chitiet.getMa_chi_tiet_hoa());
			ps.setString(2, chitiet.getHoa_don().getMa_hoa_don());
			ps.setInt(3,chitiet.getSan_pham().getMa_san_pham());
			ps.setInt(4, chitiet.getSo_luong());
			ps.setDouble(5, chitiet.getDon_gia());
			ps.setInt(6, chitiet.getGiam_gia());
			ps.executeUpdate();
			cnn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
