package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Album;
import domain.Utilisateur;
import metier.IAlbumService;
import metier.impl.AlbumService;

@WebServlet("/albums/*")
@MultipartConfig( fileSizeThreshold = 1024 * 1024, 
							maxFileSize = 1024 * 1024 * 5,
							maxRequestSize = 1024 * 1024 * 5 * 5 )
public class AlbumServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final String VUE_AJOUT_IMAGE = "/WEB-INF/addImage.jsp";
	private static final String VUE_MODIFIER_IMAGE = "/WEB-INF/updateImage.jsp";
	private static final String VUE_AJOUT_ALBUM = "/WEB-INF/addAlbum.jsp";
	private static final String VUE_MODIFIER_ALBUM = "/WEB-INF/updateAlbum.jsp";
	private static final String VUE_LIST_ALBUM = "/gallery.jsp";
	private static final String VUE_ALBUM = "/WEB-INF/album.jsp"; 
	private static final String VUE_IMAGE = "/WEB-INF/image.jsp"; 

	private IAlbumService albumService;

	@Override
	public void init() throws ServletException 
	{
		this.albumService = new AlbumService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		Utilisateur currentUser = (Utilisateur) session.getAttribute("currentUser");
		String id;
		if (request.getPathInfo() == null)
			response.sendRedirect(request.getContextPath()  + "/albums/gallery");
		else
			switch (request.getPathInfo()) 
			{
				case "/addAlbum":
					getServletContext().getRequestDispatcher(VUE_AJOUT_ALBUM).forward(request, response);
				break;
				case "/addImage":
					request.setAttribute("albums", albumService.findAllAlbumsOf(currentUser));
					getServletContext().getRequestDispatcher(VUE_AJOUT_IMAGE).forward(request, response);
				break;
				case "/updateAlbum":
					id = request.getParameter("id");
					if( id != null && id.matches("[0-9]+")) 
					{
						Album album = albumService.findAlbum(Long.parseLong(id), currentUser);
						if (album != null)
						{
							request.setAttribute("album", album);
							getServletContext().getRequestDispatcher(VUE_MODIFIER_ALBUM).forward(request, response);
						}
						else
							response.sendRedirect(getServletContext() + "/user/");
					}
				break;
				case "/updateImage":
					id = request.getParameter("id");
					if( id != null && id.matches("[0-9]+")) 
					{
						Album album = albumService.findAlbum(Long.parseLong(id), currentUser);
						if (album != null)
						{
							request.setAttribute("album", album);
							getServletContext().getRequestDispatcher(VUE_MODIFIER_ALBUM).forward(request, response);
						}
						else
							response.sendRedirect(request.getContextPath()  + "/albums/list-albums");
					}
				break;
				case "/deleteAlbum":
					if(albumService.deleteAlbum(request)) 
					{	
						request.setAttribute("succes", "Album supprimé avec succès!");
						request.setAttribute("albums", albumService.findAllAlbumsOf(currentUser));			
					}
					else
						request.setAttribute("erreur", "Erreur lors de la suppression!");
					getServletContext().getRequestDispatcher(VUE_LIST_ALBUM).forward(request, response);
				break;
				case "/deleteImage":
					if(albumService.deleteImage(request)) 
					{	
						request.setAttribute("succes", "Image supprimée avec succès!");
						request.setAttribute("image", albumService.findAllAlbumsOf(currentUser));
					}
					else
						request.setAttribute("erreur", "Erreur lors de la suppression!");
					getServletContext().getRequestDispatcher(VUE_ALBUM).forward(request, response);
				break;
				case "/list-albums":
					request.setAttribute("albums", albumService.findAllAlbumsOf(currentUser));
					request.setAttribute("images", albumService.findAllImagesOf(request, currentUser));
					getServletContext().getRequestDispatcher(VUE_LIST_ALBUM).forward(request, response);
				break;
				case "/gallery":
					request.setAttribute("albums", albumService.findAllPublicAlbums());
					request.setAttribute("images", albumService.findAllPublicImages(request));
					getServletContext().getRequestDispatcher(VUE_LIST_ALBUM).forward(request, response);
				break;
				case "/album":
					id = request.getParameter("id");
					System.out.println("****************************************");
					if( id != null && id.matches("[0-9]+")) 
					{
						System.out.println("id bien recuperer");
						Album album = albumService.findAlbum(Long.parseLong(id), currentUser);
						if (album != null)
						{
							System.out.println("Album bien récupéré");
							request.setAttribute("album", album);
							request.setAttribute("images", albumService.findAllImagesOf(request, album));
							getServletContext().getRequestDispatcher(VUE_ALBUM).forward(request, response);
						}	
						else
						{
							response.sendRedirect(request.getContextPath()  + "/albums/gallery");
						}
					}
					else
					{
						response.sendRedirect(request.getContextPath()  + "/albums/gallery");
					}
						
				break;
				default:
				break;
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getPathInfo();
		switch (path) 
		{
			case "/addAlbum":
				if (albumService.addAlbum(request))
				{
					response.sendRedirect(request.getContextPath() + "/albums/list-albums");
				}		
				else
					getServletContext().getRequestDispatcher(VUE_AJOUT_ALBUM).forward(request, response);

			break;
			case "/addImage":
				if (albumService.addImage(request))
				{
					response.sendRedirect(request.getContextPath() + "/albums/list-albums");
				}		
				else
					getServletContext().getRequestDispatcher(VUE_AJOUT_IMAGE).forward(request, response);
			break;
			case "/updateAlbum":
				if (albumService.updateAlbum(request))
				{
					response.sendRedirect(request.getContextPath() + "/albums/list-albums");
				}		
				else
					getServletContext().getRequestDispatcher(VUE_MODIFIER_ALBUM).forward(request, response);
			break;
			case "/updateImage":
				if (albumService.updateAlbum(request))
				{
					response.sendRedirect(request.getContextPath() + "/albums/list-albums");
				}		
				else
					getServletContext().getRequestDispatcher(VUE_MODIFIER_IMAGE).forward(request, response);
			break;
			default:
			break;
		}
	}

}
