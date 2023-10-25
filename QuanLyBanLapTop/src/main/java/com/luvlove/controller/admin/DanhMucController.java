package com.luvlove.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luvlove.dao.impl.DanhMucDAO;
import com.luvlove.dao.impl.DanhMucDAOImpl;
import com.luvlove.model.DanhMuc;

@WebServlet(urlPatterns = { "/admin/qldm" })
public class DanhMucController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    DanhMucDAO dm=new DanhMucDAOImpl();
	    String nameFind = req.getParameter("nameFind");
		if (nameFind != null) {
			List<DanhMuc> list = dm.getListByLikeName(nameFind);
			req.setAttribute("dm", list);
		} else {
			List<DanhMuc> list = dm.getListDanhMucCha();
			req.setAttribute("dm", list);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/admin/qlDanhmuc.jsp");
		rd.forward(req, resp);
	}
}