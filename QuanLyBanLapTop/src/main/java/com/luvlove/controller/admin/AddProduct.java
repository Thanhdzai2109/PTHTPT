package com.luvlove.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.luvlove.dao.ProductDAO;
import com.luvlove.dao.impl.DanhMucDAO;
import com.luvlove.dao.impl.DanhMucDAOImpl;
import com.luvlove.dao.impl.ProductDAOImpl;
import com.luvlove.model.DanhMuc;
import com.luvlove.model.SanPham;

@WebServlet(urlPatterns = { "/admin/addProduct" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AddProduct extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DanhMucDAO danhMucDAO = new DanhMucDAOImpl();

	private ProductDAO productDAO = new ProductDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DanhMuc> list = danhMucDAO.getListDanhMucCha();
		req.setAttribute("list", list);
		RequestDispatcher rd = req.getRequestDispatcher("/admin/add.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String realPath = req.getRealPath("/images/admin");
		System.out.println(realPath);
		String filePath = null;
		String hinhAnh = null;

		String tenSanPham = req.getParameter("name");
		String maDanhMuc = req.getParameter("category_id");
		String donGia = req.getParameter("price");
		String mota = req.getParameter("descriptsion");
		String soLuong = req.getParameter("total");

		for (Part part : req.getParts()) {
			String fileName = extractFileName(part);
			if (fileName != null && fileName.length() > 0) {
				hinhAnh = fileName;
				filePath = realPath + File.separator + fileName;
				//System.out.println("Write attachment to file: " + filePath);
				// Ghi vào file.
				part.write(filePath);
			}
		}

		SanPham sanPham = new SanPham(Integer.parseInt(maDanhMuc), "/images/admin/" + hinhAnh, tenSanPham,
				Integer.parseInt(soLuong), mota, Double.parseDouble(donGia));

		Integer id = productDAO.addSanPham(sanPham);
		if(id != null){
			resp.sendRedirect(req.getContextPath() + "/admin/home");
		}else{
			req.setAttribute("error", "Them khong thanh cong !");
			RequestDispatcher rd = req.getRequestDispatcher("/admin/add.jsp");
			rd.forward(req, resp);
		}
		//System.out.println("ID :" + id);
		
	}

	private String extractFileName(Part part) {
		// form-data; name="file"; filename="C:\file1.zip"
		// form-data; name="file"; filename="C:\Note\file2.zip"
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				// C:\file1.zip
				// C:\Note\file2.zip
				String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
				clientFileName = clientFileName.replace("\\", "/");
				int i = clientFileName.lastIndexOf('/');
				// file1.zip
				// file2.zip
				return clientFileName.substring(i + 1);
			}
		}
		return null;
	}
}
