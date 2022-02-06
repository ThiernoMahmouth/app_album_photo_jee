package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Utilisateur;
import dao.SecurityDao;
import metier.IAdminService;
import metier.IAlbumService;
import metier.impl.AdminService;
import metier.impl.AlbumService;

@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/add.jsp";
	private static final String VUE_LIST_UTILISATEUR = "/WEB-INF/users.jsp";
	private static final String VUE_MODIFIER_UTILISATEUR = "/WEB-INF/edit.jsp";
	private String key;
	private IAlbumService albumService;
	private IAdminService adminService;

	@Override
	public void init() throws ServletException 
	{
		this.albumService = new AlbumService();
		this.adminService = new AdminService();
		key = SecurityDao.getSalt();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getPathInfo();
		switch (path) 
		{
			case "/delete":
					String identifiant = request.getParameter("id");				
					if(identifiant != null && identifiant.matches("[0-9]+")) 
					{	
						adminService.deleteUser(Long.parseLong(identifiant));
					}
					response.sendRedirect(request.getContextPath());
			break;
			case "/add":
					getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
			break;
			case "/update":
					String id = request.getParameter("id");
					if( id != null && id.matches("[0-9]+")) 
					{
						Utilisateur utilisateur = adminService.findById(Long.parseLong(id));
						if(utilisateur != null) 
						{
							request.setAttribute("utilisateur", utilisateur);
							getServletContext().getRequestDispatcher(VUE_MODIFIER_UTILISATEUR).forward(request, response);
						}
						else
						{
							response.sendRedirect(request.getContextPath() + "/admin/list");						
						}
					}
					else
					{
						response.sendRedirect(request.getContextPath() + "/admin/list");
					}
			break;
			case "/list":
					request.setAttribute("utilisateurs", adminService.findAllUsers());
					getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
			break;
			default:
					request.setAttribute("utilisateurs", adminService.findAllUsers());
					getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
			break;
		} 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getPathInfo();
		switch (path) 
		{
			case "/add":
				if (adminService.addUser(request, key))
				{
					request.setAttribute("utilisateurs", adminService.findAllUsers());
					getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
				}		
				else
					getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);

			break;
			case "/update":
				if (adminService.updateUser(request, key))
				{
					request.setAttribute("utilisateurs", adminService.findAllUsers());
					getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
				}		
				else
					getServletContext().getRequestDispatcher(VUE_MODIFIER_UTILISATEUR).forward(request, response);
			break;
			default:
			break;
		}
	}
	
}
