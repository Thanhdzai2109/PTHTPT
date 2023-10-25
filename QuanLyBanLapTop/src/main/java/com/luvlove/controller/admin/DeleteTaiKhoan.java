package com.luvlove.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luvlove.dao.TaiKhoanDAO;
import com.luvlove.dao.impl.TaiKhoanDAOImpl;



@WebServlet(urlPatterns = { "/admin/deleteTaiKhoan" })
public class DeleteTaiKhoan extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mataikhoan = req.getParameter("maTaiKhoan");
		TaiKhoanDAO dao=new TaiKhoanDAOImpl();
		dao.deleteTaiKhoan(Integer.parseInt(mataikhoan));
		resp.sendRedirect(req.getContextPath() + "/admin/taikhoan");
	}
}
