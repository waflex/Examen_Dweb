package cn.dweb.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import cn.dweb.dao.UserDao;
import cn.dweb.database.DbConnect;
import cn.dweb.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			String email = request.getParameter("correo");
			String password = request.getParameter("password");
			
			try {
				UserDao udao = new UserDao(DbConnect.getConnection());
				User user = udao.userlogin(email, password);
				
				if (user!= null) {
					request.getSession().setAttribute("auth", user);
					response.sendRedirect("shop.jsp");
				}else {
					out.print("User Logged Failed");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
