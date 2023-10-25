package com.luvlove.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.luvlove.dao.impl.TaiKhoanDAOImpl;
import com.luvlove.model.TaiKhoan;
/*@WebServlet(urlPatterns = {"/DangNhap"})*/
public class DangNhap extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private TaiKhoanDAOImpl tk=new TaiKhoanDAOImpl(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("fail") != null){
			req.setAttribute("loi", "Tên đăng nhập hoặc mật khẩu sai");
		}
		if(req.getParameter("fal") != null){
			req.setAttribute("loi", "Tài khoản đã đăng nhập ở một nơi khác, vui lòng đăng xuất");
		}
		String url="/dangnhap.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="";
		String ten_dang_nhap=req.getParameter("email");
		String mat_khau=req.getParameter("matkhau");
		System.out.println(ten_dang_nhap);
		System.out.println(mat_khau);
		TaiKhoan tkhoan=new TaiKhoan();
		HttpSession session=req.getSession();
		tkhoan=tk.timTaiKhoan(ten_dang_nhap);
		try{
			if(tk.checkLogin(ten_dang_nhap, mat_khau)==false) {
				
			
				url="/QuanLyBanLapTop/DangNhap?fail=true";
			}else{
				if(tkhoan.getTinh_trang()==1){
					
					url="/QuanLyBanLapTop/DangNhap?fal=true";
					System.out.println(url);
				}else{
				if(tkhoan.getQuyen_truy_cap()!=1){
					tk.upDateStatus(ten_dang_nhap);
					url="/QuanLyBanLapTop/trangchu.jsp";
					session.setAttribute("username", ten_dang_nhap);
					session.removeAttribute("cart");
					System.out.println(url);
				}else{	
					session.setAttribute("username", ten_dang_nhap);
					session.removeAttribute("cart");
					url="/QuanLyBanLapTop/admin/home";
					System.out.println(url);
				}
				
			
				}
			}	
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		resp.sendRedirect(url);
		
		
	}
	
}
