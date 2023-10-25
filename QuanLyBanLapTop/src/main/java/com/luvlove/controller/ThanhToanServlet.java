package com.luvlove.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.luvlove.dao.impl.ChiTietHoaDonDAOImpl;
import com.luvlove.dao.impl.HoaDonDAOImpl;
import com.luvlove.model.ChiTietHoaDon;
import com.luvlove.model.Giohang;
import com.luvlove.model.HoaDon;
import com.luvlove.model.SanPham;
import com.luvlove.model.TaiKhoan;

public class ThanhToanServlet extends HttpServlet{
	private HoaDonDAOImpl dao=new HoaDonDAOImpl();
	private ChiTietHoaDonDAOImpl cthd=new ChiTietHoaDonDAOImpl();
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doGet(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	resp.setCharacterEncoding("utf-8");
    	String dia_chi=req.getParameter("diachi");
    	String dien_thoai=req.getParameter("sdt");
    	String hinh_thuc_thanh_toan=req.getParameter("input");
    	String tai_khoan=req.getParameter("username");
    	HttpSession session=req.getSession();
    	Giohang cart=(Giohang) session.getAttribute("cart");
    	try {
    		TaiKhoan tk=new TaiKhoan();
    		tk.setTen_dang_nhap(tai_khoan);
    		tk.setMa_tai_khoan(0);
    		Date date=new Date();
    		String mhd=""+date.getTime();
			HoaDon hd=new HoaDon(mhd, tk, dia_chi, hinh_thuc_thanh_toan, new Timestamp(new Date().getTime()), 0,dien_thoai);
			dao.themHoaDon(hd);
			TreeMap<SanPham,Integer> list=cart.getList();
			for(Map.Entry<SanPham,Integer> ds : list.entrySet()){
				SanPham sp=new SanPham();
				sp.setMa_san_pham(ds.getKey().getMa_san_pham());
				cthd.themChiTietHD(new ChiTietHoaDon(0, hd, sp, ds.getValue(), ds.getKey().getDon_gia(), ds.getKey().getGiam_gia()));
			}
			System.out.println("Success");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	req.setAttribute("success","thanh toan thanh cong");
    	RequestDispatcher rd = req.getRequestDispatcher("thanhtoan.jsp");
		rd.forward(req, resp);
    }
}
