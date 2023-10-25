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

@WebServlet(urlPatterns = { "/admin/edits" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class EditController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DanhMucDAO danhMucDAO = new DanhMucDAOImpl();
	private ProductDAO productDAO = new ProductDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maSanPham = req.getParameter("maSanPham");
		SanPham sanPham = productDAO.getChiTietSP(Integer.parseInt(maSanPham));
		List<DanhMuc> list = danhMucDAO.getListDanhMucCha();
		req.setAttribute("list", list);
		req.setAttribute("sanPham", sanPham);
		RequestDispatcher rd = req.getRequestDispatcher("/admin/edit.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String realPath = req.getRealPath("/images/admin");
		String filePath = null;
		String hinhAnh = null;
		System.out.println(realPath);
		
		String tenSanPham = req.getParameter("name");
		String maDanhMuc = req.getParameter("category_id");
		String donGia = req.getParameter("price");
		String mota = req.getParameter("descriptsion");
		String soLuong = req.getParameter("total");
		String maSanPham = req.getParameter("maSanPham");
		
		for (Part part : req.getParts()) {
			String fileName = extractFileName(part);
			if (fileName != null && fileName.length() > 0) {
				hinhAnh = fileName;
				filePath = realPath + File.separator + fileName;
				part.write(filePath);
			}
		}
		
		if(hinhAnh!=null){
			hinhAnh = "/images/admin/" + hinhAnh;
		}else{
			hinhAnh = null;
		}
		
		SanPham sanPham = new SanPham(Integer.parseInt(maDanhMuc), hinhAnh, tenSanPham,
				Integer.parseInt(soLuong), mota, Double.parseDouble(donGia));
		sanPham.setMa_san_pham(Integer.parseInt(maSanPham));
		productDAO.update(sanPham);
		
		resp.sendRedirect(req.getContextPath() + "/admin/home");
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
