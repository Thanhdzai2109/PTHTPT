package com.luvlove.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luvlove.dao.TaiKhoanDAO;
import com.luvlove.dao.impl.TaiKhoanDAOImpl;
import com.luvlove.model.TaiKhoan;

@WebServlet(urlPatterns = { "/admin/addTaiKhoan" })
public class AddTaiKhoan extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/admin/addTaiKhoan.jsp");
		rd.forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("ten_tai_khoan");
		String mk=req.getParameter("mat_khau");
		TaiKhoanDAO dao=new TaiKhoanDAOImpl();
		String url="/admin/taikhoan";
		TaiKhoan tk=new TaiKhoan();
		tk.setTen_tai_khoan(name);
		if(dao.checkUser(name)==false){
			tk.setMat_khau(mk);
			tk.setQuyen_truy_cap(2);
			tk.setTinh_trang(0);
			dao.AddUser(tk);
		}else{
			req.setAttribute("error","them khong thanh cong ten tk da ton tai");
			url="/admin/addTaiKhoan.jsp";
		}
		resp.sendRedirect(req.getContextPath() + url);
		
	}
}
