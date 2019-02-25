package com.myaustralia.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.myaustralia.dao.DAO;

/**
 * Servlet implementation class ImageService
 */
@WebServlet("/image/*")
// http://localhost:8088/RestfulApi/image/13
public class ImageService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ImageService() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// e.g. http://localhost:8088/RestfulApi/image/13
		// the following line gets the number 13
		String photoId = request.getPathInfo().substring(1);
		
		byte[] content = new DAO().queryByte("Photo", "select Photo from report where ReportId = ?", photoId);
		response.setContentType("image/jpg");;
		response.setContentLength(content.length);
		response.getOutputStream().write(content);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}