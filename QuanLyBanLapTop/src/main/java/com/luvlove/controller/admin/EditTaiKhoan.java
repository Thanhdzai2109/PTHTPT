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

@WebServlet(urlPatterns = { "/admin/editTaiKhoan" })
public class EditTaiKhoan extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idtk=req.getParameter("maTaiKhoan");
		TaiKhoan tk=new TaiKhoan();
		TaiKhoanDAO dao=new TaiKhoanDAOImpl();
		tk=dao.getTaiKhoanByWhere(Integer.parseInt(idtk));
		req.setAttribute("taikhoan", tk);
		RequestDispatcher rd = req.getRequestDispatcher("/admin/EditTaiKhoan.jsp");
		rd.forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("ma_tai_khoan");
		TaiKhoan tk=new TaiKhoan();
		tk.setMa_tai_khoan(Integer.parseInt(id));
		tk.setTen_dang_nhap(req.getParameter("ten_tai_khoan"));
		tk.setQuyen_truy_cap(Integer.parseInt(req.getParameter("quyentruycap")));
		TaiKhoanDAO dao=new TaiKhoanDAOImpl();
		dao.suaTaiKhoan(tk);
		resp.sendRedirect(req.getContextPath() + "/admin/taikhoan");
	}
}
