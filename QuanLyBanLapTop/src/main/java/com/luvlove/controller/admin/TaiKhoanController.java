package com.luvlove.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luvlove.dao.TaiKhoanDAO;
import com.luvlove.dao.impl.TaiKhoanDAOImpl;
import com.luvlove.model.TaiKhoan;
@WebServlet(urlPatterns = { "/admin/taikhoan" })
public class TaiKhoanController extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			TaiKhoanDAO dao=new TaiKhoanDAOImpl();
			String tentim = req.getParameter("nameFind");
			if (tentim != null) {
				List<TaiKhoan> list=dao.getTaiKhoanByLike(tentim);
				req.setAttribute("listtk", list);
			} else {
				List<TaiKhoan> list =dao.getAll();
				req.setAttribute("listtk", list);
			}
			RequestDispatcher rd = req.getRequestDispatcher("/admin/qlTaiKhoan.jsp");
			rd.forward(req, resp);
		}
	
		
}
