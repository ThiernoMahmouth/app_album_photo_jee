package dao;

import java.util.Collection;

import domain.Album;
import domain.Image;

public interface IAlbumDao 
{
	boolean addAlbum(Album album);
	boolean updateAlbum(Album album);
	boolean deleteAlbum(Album album);
	Album findAlbumById(Long id);
	Collection<Album> findAllAlbumsOf(Long idUser);
	Collection<Album> findAllPublicAlbums();
	
	
	//
	boolean addImage(Image img);
	boolean updateImage(Image img);
	boolean deleteImage(Image img);
	Image findImageById(Long id);
	Collection<Image> findAllImageOf(Album album);

}
