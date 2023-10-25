package com.luvlove.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luvlove.dao.impl.DanhMucDAO;
import com.luvlove.dao.impl.DanhMucDAOImpl;
@WebServlet(urlPatterns = { "/admin/addDanhMuc" })
public class AddDanhMuc extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/admin/addDanhMuc.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("ten_danh_muc");
		System.out.println(name);
		DanhMucDAO dao=new DanhMucDAOImpl();
		dao.addDanhMuc(name);
		/*RequestDispatcher rd = req.getRequestDispatcher("/admin/qlDanhmuc.jsp");*/
		resp.sendRedirect(req.getContextPath()+"/admin/qldm");
		//rd.forward(req, resp);
		
	}
}
