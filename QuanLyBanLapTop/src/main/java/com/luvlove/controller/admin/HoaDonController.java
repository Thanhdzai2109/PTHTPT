package com.luvlove.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luvlove.dao.HoaDonDAO;
import com.luvlove.dao.impl.HoaDonDAOImpl;
import com.luvlove.model.DetailHoaDon;
@WebServlet(urlPatterns = { "/admin/hoadon" })
public class HoaDonController extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<DetailHoaDon> list=new ArrayList<DetailHoaDon>();
			HoaDonDAO dao=new HoaDonDAOImpl();
			list=dao.getListHD();
			req.setAttribute("listhoadon", list);
//			System.out.println(list.get(0).getMataikhoan());
//			System.out.println(list.get(0).getTensp());
			RequestDispatcher rd = req.getRequestDispatcher("/admin/qlHoaDon.jsp");
			rd.forward(req, resp);
		}
}	
