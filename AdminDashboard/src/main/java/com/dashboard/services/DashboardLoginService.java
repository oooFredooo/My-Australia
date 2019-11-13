package com.dashboard.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dashboard.beans.*;
import com.dashboard.common.DatabaseHelper;

@WebServlet("/login")
public class DashboardLoginService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ResultSet res = null;
	Connection con = null;
	PreparedStatement pre = null;
       
	public DashboardLoginService() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		DashboardLogin account = new DashboardLogin();
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String sql="select Authority from dashboarduser where UserName = ? and Password = ?";
		try {
			con = DatabaseHelper.getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, username);
			pre.setString(2, pwd);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				account.setPassword(pwd);
				account.setUsername(username);
				account.setAuthority(rs.getString("Authority"));
				session.setAttribute("account", account);
				String login_suc = "http://localhost:8088/AdminDashboard/report.jsp";
				response.sendRedirect(login_suc);
				return;
			} else {
				String login_fail = "http://localhost:8088/AdminDashboard/index.html";
				response.sendRedirect(login_fail);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseHelper.closeAll(res, pre, con);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
