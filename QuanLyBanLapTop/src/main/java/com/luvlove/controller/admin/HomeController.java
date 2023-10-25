package com.luvlove.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luvlove.dao.ProductDAO;
import com.luvlove.dao.impl.ProductDAOImpl;
import com.luvlove.model.SanPham;

@WebServlet(urlPatterns = { "/admin/home" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProductDAO productDAO = new ProductDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nameFind = req.getParameter("nameFind");
		if (nameFind != null) {
			List<SanPham> list = productDAO.getListByLikeName(nameFind);
			req.setAttribute("list", list);
		} else {
			List<SanPham> list = productDAO.getList();
			req.setAttribute("list", list);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/admin/list.jsp");
		rd.forward(req, resp);
	}
}
