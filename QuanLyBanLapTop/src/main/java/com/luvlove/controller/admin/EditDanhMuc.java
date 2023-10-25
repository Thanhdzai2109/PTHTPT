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
import com.luvlove.model.DanhMuc;

@WebServlet(urlPatterns = { "/admin/editDanhMuc" })
public class EditDanhMuc extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String madanhmuc = req.getParameter("maDanhMuc");
		DanhMucDAO dao=new DanhMucDAOImpl();
		DanhMuc dm=new DanhMuc();
		dm=dao.searchDanhMucByName(Integer.parseInt(madanhmuc));
		req.setAttribute("danhmuc", dm);
		RequestDispatcher rd = req.getRequestDispatcher("/admin/EditDanhMuc.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HIHIHIHHI");
		DanhMucDAO dao=new DanhMucDAOImpl();
		String tenupdate=req.getParameter("ten_danh_muc");
		System.out.println(tenupdate);
		String id=req.getParameter("madanhmuc");
		boolean kt;
		kt=dao.updateDM(Integer.parseInt(id), tenupdate);
		resp.sendRedirect(req.getContextPath() + "/admin/qldm");
	}
}
