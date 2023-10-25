package com.luvlove.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luvlove.dao.ProductDAO;
import com.luvlove.dao.impl.ProductDAOImpl;

@WebServlet(urlPatterns = { "/admin/delete" })
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ProductDAO productDAO = new ProductDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maSanPham = req.getParameter("maSanPham");
		productDAO.delete(Integer.parseInt(maSanPham));
		resp.sendRedirect(req.getContextPath() + "/admin/home");
	}
}
