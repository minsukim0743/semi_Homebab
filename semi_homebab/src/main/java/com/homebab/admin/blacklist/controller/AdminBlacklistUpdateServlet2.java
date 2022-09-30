package com.homebab.admin.blacklist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.homebab.admin.blacklist.service.AdminBlacklistService;

/**
 * Servlet implementation class AdminBlacklistUpdateServlet2
 */
@WebServlet("/adminBlackList/update/ntoy")
public class AdminBlacklistUpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String number = request.getParameter("number");
		
		System.out.println("number : " + number);
		
		AdminBlacklistService service = new AdminBlacklistService();
		
		int result = service.blacklistUpdate2(number);
		
		String path = "";
		
		if(result > 0) {
			
			JOptionPane.showMessageDialog(null, "블랙리스트가 해제되었습니다.");
			
			path = "/adminMember/detail?number="+number;
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			JOptionPane.showMessageDialog(null, "등록 실패하였습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			
			path = "/WEB-INF/views/common/error/failed.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
	}

}
