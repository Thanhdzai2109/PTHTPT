package com.luvlove.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luvlove.dao.ProductDAO;
import com.luvlove.dao.impl.ProductDAOImpl;
import com.luvlove.model.SanPham;
import com.luvlove.utils.HttpUtil;

/*@WebServlet(urlPatterns = { "/api/products/*" })*/
@WebServlet(urlPatterns = { "/api/products"})
public class ProductAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO dao = new ProductDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	String pathInfor = req.getPathInfo();
	//	System.out.println(pathInfor);
	//	String[] arrs = pathInfor.split("/");
	//	System.out.println(arrs[arrs.length-1]);
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		List<SanPham> list = dao.getList();
		objectMapper.writeValue(resp.getOutputStream(), list);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		SanPham sanPham = HttpUtil.of(req.getReader()).toModel(SanPham.class);
		System.out.println(sanPham.getMa_san_pham());
		dao.addSanPham(sanPham);
		
		objectMapper.writeValue(resp.getOutputStream(), "{Thêm thành công}");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//update
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//delete
	}
}
