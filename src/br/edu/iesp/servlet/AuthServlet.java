package br.edu.iesp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.iesp.entity.User;
import br.edu.iesp.util.ActionConstant;

@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession s = req.getSession(false);

		if(req.getParameter("action").equals(ActionConstant.ACTION_LOGIN)){

			if(req.getParameter("login") != null && req.getParameter("login").equals(User.LOGIN_ADMIN) 
					&& req.getParameter("password") != null && req.getParameter("password").equals(User.PASSWORD_ADMIN)){

				if(s.isNew()){
					User user = new User();
					user.setLogin(req.getParameter("login"));
					user.setName("Admin");
					user.setAutenticate(true);
					s.setAttribute("user", user);
				}
				
				req.getRequestDispatcher("posts.jsp").forward(req, resp);

			}else{
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}else if(req.getParameter("action").equals(ActionConstant.ACTION_LOGOUT)){
			s.setAttribute("user", null);
			s.invalidate();
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}


	}

}
