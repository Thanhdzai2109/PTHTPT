package com.luvlove.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luvlove.dao.impl.TaiKhoanDAOImpl;
import com.luvlove.model.TaiKhoan;



public class CheckDangKy extends HttpServlet{
	private TaiKhoanDAOImpl taikhoan=new TaiKhoanDAOImpl();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url;
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String hoten=req.getParameter("hoten");
		String email=req.getParameter("email");
		String matkhau=req.getParameter("matkhau");
		if(taikhoan.checkUser(email)==true) {
			 req.setAttribute("error","Tên Đăng Kí Đã Tồn Tại");
			 url="/dangky.jsp";
		}else{
			TaiKhoan tk=new TaiKhoan(4, email, hoten, matkhau, 2, 0);
			taikhoan.AddUser(tk);
			 url="/dangnhap.jsp";
		}
				
			
			   RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
				rd.forward(req, resp);
			
		
	}
}
