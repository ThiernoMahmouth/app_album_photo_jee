package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SecurityDao;
import domain.Utilisateur;
import metier.impl.AuthService;

@WebServlet({"/login", "/logout", "/register"})
public class AuthServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final String VUE_LOGIN = "/login.jsp";
	private static final String VUE_REGISTER = "/register.jsp";

	private AuthService authService;
	private String key;

	
	@Override
	public void init() throws ServletException 
	{
		authService = new AuthService();
		key = SecurityDao.getSalt();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		switch (request.getServletPath())
		{
			case "/login":
					getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
			break;
			case "/register":
				getServletContext().getRequestDispatcher(VUE_REGISTER).forward(request, response);
			break;
			default:
					HttpSession session = request.getSession();
					session.invalidate();
					response.sendRedirect(request.getContextPath() + "/login");
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		switch (request.getServletPath())
		{
			case "/login":
				if (authService.login(request, key))
				{
					HttpSession session = request.getSession();
					Utilisateur currentUser = (Utilisateur) session.getAttribute("currentUser");
					if (currentUser.getRole().equals("ADMIN"))
						response.sendRedirect(request.getContextPath() + "/admin/list");
					else 
						response.sendRedirect(request.getContextPath() + "/albums/list-albums");
				}
				else
				{
					request.setAttribute("erreur", "Login ou mot de passe incorrect!");
					getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
				}
			break;
			default:
				if (authService.register(request, key))
				{
					response.sendRedirect(request.getContextPath() + "/");
				}
				else
				{
					getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
				}

			break;
		}
	}


}
