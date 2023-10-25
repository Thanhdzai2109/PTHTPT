package com.luvlove.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luvlove.dao.ProductDAO;
import com.luvlove.dao.impl.ProductDAOImpl;
import com.luvlove.model.SanPham;
import com.luvlove.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api/products/*" })
public class ProductGetByWhereAPI extends HttpServlet {

	/**
	 * 
	 */
	private ProductDAO dao = new ProductDAOImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfor = req.getPathInfo();
		System.out.println(pathInfor);
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String[] arrs = pathInfor.split("/");
		System.out.println(arrs[arrs.length - 1]);
		String kt = arrs[arrs.length - 1];
		try{
			int maDanhMuc = Integer.parseInt(kt);
			List<SanPham> list = dao.getListProduct(maDanhMuc);
			objectMapper.writeValue(resp.getOutputStream(), list);
		}catch (Exception e) {
			kt = kt.replaceAll("\\+", " ");
			List<SanPham> list = dao.getListByLikeName(kt);
			//System.out.println(list.size());
			objectMapper.writeValue(resp.getOutputStream(), list);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfor = req.getPathInfo();
		System.out.println(pathInfor);
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		SanPham sanPham = HttpUtil.of(req.getReader()).toModel(SanPham.class);
		List<SanPham> list = dao.getListByLikeName(sanPham.getTen_san_pham());
		//System.out.println(list.size());
		objectMapper.writeValue(resp.getOutputStream(), list);
	}

	public static void main(String[] args) {
		String a = "Tets+test";
		a = a.replaceAll("\\+", " ");
		System.out.println(a);
	}
}
