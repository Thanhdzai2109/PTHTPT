/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvlove.controller;

import com.luvlove.dao.HoaDonDAO;
import com.luvlove.dao.impl.HoaDonDAOImpl;
import com.luvlove.model.DetailHoaDon;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nguyen Thanh
 */

public class LichsuServerlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  public class Lichsuservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lichsuservelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DetailHoaDon> listsp=new ArrayList<DetailHoaDon>();
		HttpSession session=request.getSession();
		String ten_dang_nhap=(String) session.getAttribute("username");
		System.out.println(ten_dang_nhap);
        HoaDonDAO dao=new HoaDonDAOImpl();
        listsp=dao.getListHDmember(ten_dang_nhap);
        request.setAttribute("listhoadon", listsp);
        request.setAttribute("ten_dang_nhap", ten_dang_nhap);

        request.getRequestDispatcher("lichsu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


  }}
