package com.luvlove.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luvlove.dao.ProductDAO;
import com.luvlove.dao.impl.DanhMucDAO;
import com.luvlove.dao.impl.DanhMucDAOImpl;
import com.luvlove.dao.impl.ProductDAOImpl;
import com.luvlove.model.DanhMuc;
import com.luvlove.model.SanPham;

@WebServlet(urlPatterns={"/api/danhmuc"})
public class DanhMucAPI extends HttpServlet{
	private DanhMucDAO dao = new DanhMucDAOImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		List<DanhMuc> list = dao.getListDanhMucCha();
		objectMapper.writeValue(resp.getOutputStream(), list);
	}
}
