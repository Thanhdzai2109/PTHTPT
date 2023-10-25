package com.luvlove.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luvlove.dao.impl.DanhMucDAO;
import com.luvlove.dao.impl.DanhMucDAOImpl;
@WebServlet(urlPatterns = { "/admin/deleteDanhMuc" })
public class DeleteDanhMuc extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ma_danh_muc = req.getParameter("maDanhMuc");
		DanhMucDAO dao=new DanhMucDAOImpl();
		dao.deleteDM(Integer.parseInt(ma_danh_muc));
		resp.sendRedirect(req.getContextPath() + "/admin/qldm");
	}
}
