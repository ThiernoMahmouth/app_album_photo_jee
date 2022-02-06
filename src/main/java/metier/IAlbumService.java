package metier;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import domain.Album;
import domain.Image;
import domain.Utilisateur;

public interface IAlbumService 
{
	boolean addAlbum(HttpServletRequest request);
	boolean updateAlbum(HttpServletRequest request);
	boolean deleteAlbum(HttpServletRequest request);
	Album findAlbum(Long id, Utilisateur user);
	Collection<Album> findAllAlbumsOf(Utilisateur user);
	Collection<Album> findAllPublicAlbums();
	
	boolean addImage(HttpServletRequest request);
	boolean updateImage(HttpServletRequest request);
	boolean deleteImage(HttpServletRequest request);
	Album findImage(Long id, Utilisateur user);
	Collection<Image> findAllImagesOf(HttpServletRequest request, Album album);
	Collection<Image> findAllImagesOf(HttpServletRequest request, Utilisateur user);
	Collection<Image> findAllPublicImages(HttpServletRequest request);

	


}
