package metier.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.AlbumDAO;
import dao.IAlbumDao;
import domain.Album;
import domain.Image;
import domain.Utilisateur;
import metier.IAlbumService;
import utils.FormUtils;

public class AlbumService implements IAlbumService
{
	private static final String UPLOAD_DIR = "images";

	private static final String id_field = "id";
	private static final String nom_field = "nom";
	private static final String private_field = "isPrivate";
	private static final String titre_field = "titre";
	
	private static final String hauteur_field = "hauteur";
	private static final String largeur_field = "largeur";

	private static final String album_field = "album";


	private IAlbumDao albumDAO;
	
	public AlbumService()
	{
		this.albumDAO = new AlbumDAO();
	}
	@Override
	public boolean addAlbum(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		if (FormUtils.validateFields(request, nom_field, private_field))
		{
			String nom = FormUtils.getParameter(request, nom_field);
			String radio = request.getParameter(private_field);
			boolean isPrivate = FormUtils.getParameter(request, private_field).equals("0")? false:true;
			Album album = new Album(nom, isPrivate);
			album.setProprietaire((Utilisateur) session.getAttribute("currentUser"));
			if (albumDAO.addAlbum(album))
				return true;
			else
				return false;
		}
		else
			request.setAttribute("erreur", "Veuillez bien remplir le formulaire!");
		return false;
	}

	@Override
	public boolean updateAlbum(HttpServletRequest request) 
	{
		if (FormUtils.validateFields(request, id_field, nom_field, private_field))
		{
			if (FormUtils.getParameter(request, id_field).matches("[0-9]+"))
			{
				Album album = albumDAO.findAlbumById(Long.parseLong(FormUtils.getParameter(request, id_field)));
				String nom = FormUtils.getParameter(request, nom_field);
				boolean isPrivate = FormUtils.getParameter(request, private_field).equals("0")? false:true;
				if (album != null)
				{
					album.setNom(nom);
					album.setPrivate(isPrivate);
					if (albumDAO.updateAlbum(album))
					{
						return true;
					}
					else
						return false;
				}
				else
				{
					request.setAttribute("erreur", "Cet album n'existe pas!");
					return false;
				}
			}
			else
			{
				request.setAttribute("erreur", "Paramètre incorrect!");
				return false;
			}
		}
		else
		{
			request.setAttribute("erreur", "Veuillez bien remplir le formulaire!");
			return false;
		}
	}

	@Override
	public boolean deleteAlbum(HttpServletRequest request) 
	{
		if (FormUtils.validateFields(request, id_field) && FormUtils.getParameter(request, id_field).matches("[0-9]+"))
		{
			Album album = albumDAO.findAlbumById(Long.parseLong(FormUtils.getParameter(request, id_field)));
			if (album != null)
			{
				if (albumDAO.deleteAlbum(album))
					return true;
				else
				{
					request.setAttribute("erreur", "Erreur lors de la suppression!");
					return false;
				}
			}
			else
			{
				request.setAttribute("erreur", "Cet album n'existe pas!");
				return false;
			}
		}
		else
		{
			request.setAttribute("erreur", "Paramètre incorrect!");
			return false;
		}
	}

	@Override
	public Album findAlbum(Long id, Utilisateur user) 
	{
		return null;
	}

	@Override
	public Collection<Album> findAllAlbumsOf(Utilisateur user) 
	{
		// TODO Auto-generated method stub
		return albumDAO.findAllAlbumsOf(user.getId());
	}
	
	@Override
	public Collection<Album> findAllPublicAlbums() 
	{
		return albumDAO.findAllPublicAlbums();
	}

	@Override
	public boolean addImage(HttpServletRequest request) 
	{
		if (FormUtils.validateFields(request, titre_field, hauteur_field, largeur_field))
		{
			String titre = FormUtils.getParameter(request, titre_field);
			int hauteur = Integer.parseInt(FormUtils.getParameter(request, hauteur_field));
			int largeur = Integer.parseInt(FormUtils.getParameter(request, largeur_field));
			String selectedAlbum = request.getParameter(album_field);
			Long idAlbum = Long.parseLong(FormUtils.getParameter(request, album_field));
			
			// Fichier
			Part part;
			try 
			{
				part = request.getPart("fileName");
				String fileName = extractFileName(part);
				//
				/*
				String applicationPath = request.getServletContext().getRealPath("");
		        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
		        */
				String uploadPath =  request.getServletContext().getRealPath(UPLOAD_DIR);
		        File fileUploadDirectory = new File(uploadPath);
		        if (!fileUploadDirectory.exists()) 
		        {
		            fileUploadDirectory.mkdirs();
		        }
		        String savePath = uploadPath + File.separator + fileName;
		        String sRootPath = new File(savePath).getAbsolutePath();
		        part.write(savePath + File.separator);
		        File fileSaveDir1 = new File(savePath);
		        String dbFileName = UPLOAD_DIR + File.separator + fileName;
		        part.write(savePath + File.separator);
		        Image img = new Image();
		        img.setTitre(titre);
		        img.setHauteur(hauteur);
		        img.setLargeur(largeur);
		        img.setAlbum(idAlbum);
		        img.setFileName(dbFileName);
		        if (albumDAO.addImage(img))
		        	return true;
		        else
	    		{
	    			request.setAttribute("erreur", "Erreur lors de l'ajout de l'image!");
	    			return false;
	    		}
			} 
			catch (IOException |  ServletException e) 
			{
				e.printStackTrace();			
				request.setAttribute("erreur", "Erreur avec la photo!");
				return false;
			}         
		}
		else
		{
			request.setAttribute("erreur", "Veuillez bien remplir le formulaire!");
			return false;
		}
	}

	@Override
	public boolean updateImage(HttpServletRequest request) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteImage(HttpServletRequest request) 
	{
		if (FormUtils.validateFields(request, id_field) && FormUtils.getParameter(request, id_field).matches("[0-9]+"))
		{
			Image img = albumDAO.findImageById(Long.parseLong(FormUtils.getParameter(request, id_field)));
			if (img != null)
			{
				if (albumDAO.deleteImage(img))
				{
					request.setAttribute("album", albumDAO.findAlbumById(img.getAlbum()));
				}
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Album findImage(Long id, Utilisateur user) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Image> findAllImagesOf(HttpServletRequest request, Album album) 
	{
		Collection<Image> images = new ArrayList<>();
		for (Image img: albumDAO.findAllImageOf(album))
		{
			//img.setFileName(getPath(request) + File.separator + img.getFileName());
			images.add(img);
		}
		return images;
	}
	@Override
	public Collection<Image> findAllImagesOf(HttpServletRequest request, Utilisateur user) 
	{
		Collection<Album> albums = albumDAO.findAllAlbumsOf(user.getId());
		Collection<Image> images = new ArrayList<>();
		for (Album album: albums)
		{
			for (Image img: albumDAO.findAllImageOf(album))
			{
				//img.setFileName(getPath(request) + File.separator + img.getFileName());
				images.add(img);
			}
		}
		return images;
	}
	
	@Override
	public Collection<Image> findAllPublicImages(HttpServletRequest request)
	{
		Collection<Album> albums = albumDAO.findAllPublicAlbums();
		Collection<Image> images = new ArrayList<>();
		for (Album album: albums)
		{
			for (Image img: albumDAO.findAllImageOf(album))
			{
				//img.setFileName(getPath(request) + File.separator + img.getFileName());
				images.add(img);
			}
		}
		return images;
	}
	
	private String getPath(HttpServletRequest request)
	{
		String applicationPath = request.getServletContext().getRealPath(UPLOAD_DIR);
        String uploadPath = applicationPath ;
        return uploadPath;
	}

	


	private String extractFileName(Part part) 
	{
		//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) 
        {
            if (s.trim().startsWith("filename")) 
            	return s.substring(s.indexOf("=") + 2, s.length() - 1);
        }
        return "";
    }


}
