package com.luvlove.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.luvlove.dao.TaiKhoanDAO;
import com.luvlove.dao.impl.TaiKhoanDAOImpl;

public class DangXuat extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 public DangXuat() {
	        super();
	    }
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        HttpSession session = request.getSession(false);
	        String name=(String) session.getAttribute("username");
	        TaiKhoanDAO tk=new TaiKhoanDAOImpl();
	        if (session != null) {
	        	tk.remoStatus(name);
	            session.removeAttribute("username");  
	            session.removeAttribute("cart");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("trangchu.jsp");
	            dispatcher.forward(request, response);
	        }
	    }
	
}
