package com.luvlove.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.luvlove.dao.impl.ProductDAOImpl;
import com.luvlove.model.Giohang;
import com.luvlove.model.SanPham;

/**
 * Servlet implementation class GioHangServlet
 */

public class GioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ProductDAOImpl sanPhamDAO=new ProductDAOImpl();
    public GioHangServlet() {
        super();
       
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*String url="/giohang.jsp";
    	RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);*/
    	doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Giohang cart=(Giohang) session.getAttribute("cart"); 
		String msp=request.getParameter("ma_san_pham");
		String command=request.getParameter("command");
		ArrayList<Long> listBuy=null;
		String url="/trangchu.jsp";
		try {
			listBuy=(ArrayList<Long>) session.getAttribute("cartID");
			long iBuy=0;
			if(request.getParameter("cartID")!=null) {
				iBuy=Long.parseLong(request.getParameter("cartID"));
			}
				SanPham sp=sanPhamDAO.getChiTietSP(Integer.parseInt(msp));
				switch(command) {
				case "insert":
					if(listBuy==null) {
						listBuy=new ArrayList<>();
						session.setAttribute("cartID", listBuy);
					}
					if(listBuy.indexOf(iBuy)==-1) {
						cart.InsertToCart(sp,1);
						listBuy.add(iBuy);
					}
				case "plus":
					if(listBuy==null) {
						listBuy=new ArrayList<>();
						session.setAttribute("cart", listBuy);
					}
					if(listBuy.indexOf(iBuy)==-1) {
						cart.InsertToCart(sp, 1);
						listBuy.add(iBuy);
					}
				case "sub":
					if(listBuy==null) {
						listBuy=new ArrayList<>();
						session.setAttribute("cart", listBuy);
					}
					if(listBuy.indexOf(iBuy)==-1) {
						cart.SubToCart(sp, 1);
						listBuy.add(iBuy);
					}
					if(command.equals("insert")) {
						url="/trangchu.jsp";
					}else {
						url="/giohang.jsp";
					}
					
					break;
					default:
						break;
							
				}
				
			
		} catch (Exception e) {
			
		}
		RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
		
	}
	

}
