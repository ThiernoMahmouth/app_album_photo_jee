package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import domain.Album;
import domain.Image;
import domain.Utilisateur;
import utils.DateUtils;
import utils.SingletonConnection;

public class AlbumDAO implements IAlbumDao
{
	@Override
	public boolean addAlbum(Album album) 
	{
		String requete = "INSERT INTO album(nom, isPrivate, proprietaire, date, heure) VALUES (?, ?, ?, ?, ?);";
        Connection connection = null;
        boolean result = false;
		try 
        {
        	connection = SingletonConnection.getConnection();
        	connection.setAutoCommit(false);
        	// Insertion
        	PreparedStatement preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setString(1, album.getNom());	
            preparedStatement.setBoolean(2, album.isPrivate());	
            preparedStatement.setLong(3, album.getProprietaire().getId());	
            preparedStatement.setDate(4, DateUtils.getSQLDate(album.getDate()));	
            preparedStatement.setTime(5, DateUtils.getSQLTime(album.getHeure()));	
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
            result = true;
        } 
		catch (SQLException e) 
		{
		     e.printStackTrace();
		     if(connection != null)
		     {
		       try 
		       {
		         // Rollingback the transaction
		         connection.rollback();
		       } 
		       catch (SQLException e1) 
		       {
		         e1.printStackTrace();
		       }
		     }    
		}
		finally
		{
		       if(connection != null)
		       {
		    	   //closing connection 
			        try 
			        {
			          connection.close();
			        } catch (SQLException e) 
			        {
			           e.printStackTrace();
			        }
		      } 
		}				 
		return result;
	}

	@Override
	public boolean updateAlbum(Album album) 
	{
		String requete = "UPDATE album SET nom = ?, isPrivate = ? WHERE id = ?;";
        Connection connection = null;
        boolean result = false;
		try 
        {
        	connection = SingletonConnection.getConnection();
        	connection.setAutoCommit(false);
        	// Insertion
        	PreparedStatement preparedStatement = connection.prepareStatement(requete);
        	preparedStatement.setString(1, album.getNom());	
            preparedStatement.setBoolean(2, album.isPrivate());	
            preparedStatement.setLong(3, album.getId());		
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
            result = true;
        } 
		catch (SQLException e) 
		{
		     e.printStackTrace();
		     if(connection != null)
		     {
		       try 
		       {
		         // Rollingback the transaction
		         connection.rollback();
		       } 
		       catch (SQLException e1) 
		       {
		         e1.printStackTrace();
		       }
		     }    
		}
		finally
		{
		       if(connection != null)
		       {
		    	   //closing connection 
			        try 
			        {
			          connection.close();
			        } catch (SQLException e) 
			        {
			           e.printStackTrace();
			        }
		      } 
		}				 
		return result;
	}

	@Override
	public boolean deleteAlbum(Album album) 
	{
		String requete = "DELETE FROM album WHERE id = ?;";
		boolean result = false;
		Connection connection = null;
		try 
		{
        	connection = SingletonConnection.getConnection();
        	connection.setAutoCommit(false);
			PreparedStatement ps = connection.prepareStatement(requete);
	        ps.setLong(1, album.getId());
	        ps.executeUpdate();
	        ps.close();
	        connection.commit();
	        result = true;
		} 
		catch (SQLException e) 
		{
		     e.printStackTrace();
		     if(connection != null)
		     {
		       try 
		       {
		         // Rollingback the transaction
		         connection.rollback();
		       } 
		       catch (SQLException e1) 
		       {
		         e1.printStackTrace();
		       }
		     }    
		}
		finally
		{
		       if(connection != null)
		       {
		    	   //closing connection 
			        try 
			        {
			          connection.close();
			        } catch (SQLException e) 
			        {
			           e.printStackTrace();
			        }
		      } 
		}				 
		return result;
	}

	@Override
	public Album findAlbumById(Long id) 
	{
		Album alb = null;
		Connection connection = null;
		try 
     	{
        	connection = SingletonConnection.getConnection();
    	    PreparedStatement ps = connection.prepareStatement("select * from album where  id = ?;");
    	    ps.setLong(1, id);
            ResultSet rs= ps.executeQuery();
            if (rs.next())
            {
            	alb = new Album();
            	alb.setId(rs.getLong("id"));
            	alb.setNom(rs.getString("nom"));
            	alb.setDate(DateUtils.getLocalDate(rs.getDate("date")));		            
            	alb.setHeure(DateUtils.getLocalTime(rs.getTime("heure")));		            
            	alb.setPrivate(rs.getBoolean("isPrivate"));	 	            
            }
            ps.close();
            connection.close();
        } 
		catch (SQLException e) 
		{
		     e.printStackTrace();	      
		}		 
		return alb;
	}

	@Override
	public Collection<Album> findAllAlbumsOf(Long idUser) 
	{
		ArrayList<Album> albums = new ArrayList<>();
		Connection connection = null;
		try 
     	{
        	connection = SingletonConnection.getConnection();
    	    PreparedStatement ps = connection.prepareStatement("select * from album where proprietaire = ?;");
            ps.setLong(1, idUser);
    	    ResultSet rs= ps.executeQuery();
            while (rs.next())
            {
            	Album alb = new Album();
            	alb.setId(rs.getLong("id"));
            	alb.setNom(rs.getString("nom"));
            	alb.setDate(DateUtils.getLocalDate(rs.getDate("date")));		            
            	alb.setHeure(DateUtils.getLocalTime(rs.getTime("heure")));		            
            	alb.setPrivate(rs.getBoolean("isPrivate"));	 
            	albums.add(alb);
            }
            ps.close();
            connection.close();
        } 
		catch (SQLException e) 
		{
		     e.printStackTrace();	      
		}	
		
		return albums;
	}
	
	@Override
	public Collection<Album> findAllPublicAlbums() 
	{
		ArrayList<Album> albums = new ArrayList<>();
		Connection connection = null;
		try 
     	{
        	connection = SingletonConnection.getConnection();
    	    PreparedStatement ps = connection.prepareStatement("select * from album where isPrivate = 0;");
    	    ResultSet rs= ps.executeQuery();
            while (rs.next())
            {
            	Album alb = new Album();
            	alb.setId(rs.getLong("id"));
            	alb.setNom(rs.getString("nom"));
            	alb.setDate(DateUtils.getLocalDate(rs.getDate("date")));		            
            	alb.setHeure(DateUtils.getLocalTime(rs.getTime("heure")));		            
            	alb.setPrivate(rs.getBoolean("isPrivate"));	 
            	albums.add(alb);
            }
            ps.close();
            connection.close();
        } 
		catch (SQLException e) 
		{
		     e.printStackTrace();	      
		}	
		return albums;
	}

	@Override
	public boolean addImage(Image img) 
	{
		String requete = "INSERT INTO image(titre, fileName, album, hauteur, largeur) VALUES (?, ?, ?, ?, ?);";
        Connection connection = null;
        boolean result = false;
		try 
        {
        	connection = SingletonConnection.getConnection();
        	connection.setAutoCommit(false);
        	// Insertion
        	PreparedStatement preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setString(1, img.getTitre());	
            preparedStatement.setString(2, img.getFileName());	
            preparedStatement.setLong(3, img.getAlbum());	
            preparedStatement.setInt(4, img.getHauteur());	
            preparedStatement.setInt(5, img.getLargeur());	
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
            result = true;
        } 
		catch (SQLException e) 
		{
		     e.printStackTrace();
		     if(connection != null)
		     {
		       try 
		       {
		         // Rollingback the transaction
		         connection.rollback();
		       } 
		       catch (SQLException e1) 
		       {
		         e1.printStackTrace();
		       }
		     }    
		}
		finally
		{
		       if(connection != null)
		       {
		    	   //closing connection 
			        try 
			        {
			          connection.close();
			        } catch (SQLException e) 
			        {
			           e.printStackTrace();
			        }
		      } 
		}				 
		return result;

	}

	@Override
	public boolean updateImage(Image img) 
	{
		String requete = "UPDATE image SET titre = ?, description = ?, hauteur = ?, largeur = ?, fileName = ? WHERE id = ?;";
        Connection connection = null;
        boolean result = false;
		try 
        {
        	connection = SingletonConnection.getConnection();
        	connection.setAutoCommit(false);
        	// Insertion
        	PreparedStatement preparedStatement = connection.prepareStatement(requete);
        	preparedStatement.setString(1, img.getTitre());	
        	preparedStatement.setString(2, img.getDescription());	
        	preparedStatement.setInt(3, img.getHauteur());	
        	preparedStatement.setInt(4, img.getLargeur());	
        	preparedStatement.setString(5, img.getFileName());	
            preparedStatement.setLong(6, img.getId());		
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
            result = true;
        } 
		catch (SQLException e) 
		{
		     e.printStackTrace();
		     if(connection != null)
		     {
		       try 
		       {
		         // Rollingback the transaction
		         connection.rollback();
		       } 
		       catch (SQLException e1) 
		       {
		         e1.printStackTrace();
		       }
		     }    
		}
		finally
		{
		       if(connection != null)
		       {
		    	   //closing connection 
			        try 
			        {
			          connection.close();
			        } catch (SQLException e) 
			        {
			           e.printStackTrace();
			        }
		      } 
		}				 
		return result;

	}

	@Override
	public boolean deleteImage(Image img) 
	{
		String requete = "DELETE FROM image WHERE id = ?;";
		boolean result = false;
		Connection connection = null;
		try 
		{
        	connection = SingletonConnection.getConnection();
        	connection.setAutoCommit(false);
			PreparedStatement ps = connection.prepareStatement(requete);
	        ps.setLong(1, img.getId());
	        ps.executeUpdate();
	        ps.close();
	        connection.commit();
	        result = true;
		} 
		catch (SQLException e) 
		{
		     e.printStackTrace();
		     if(connection != null)
		     {
		       try 
		       {
		         // Rollingback the transaction
		         connection.rollback();
		       } 
		       catch (SQLException e1) 
		       {
		         e1.printStackTrace();
		       }
		     }    
		}
		finally
		{
		       if(connection != null)
		       {
		    	   //closing connection 
			        try 
			        {
			          connection.close();
			        } catch (SQLException e) 
			        {
			           e.printStackTrace();
			        }
		      } 
		}				 
		return result;
	}

	@Override
	public Image findImageById(Long id) 
	{
		Image img = null;
		Connection connection = null;
		try 
     	{
        	connection = SingletonConnection.getConnection();
    	    PreparedStatement ps = connection.prepareStatement("select * from image where  id = ?;");
    	    ps.setLong(1, id);
            ResultSet rs= ps.executeQuery();
            if (rs.next())
            {
            	img = new Image();
            	img.setId(rs.getLong("id"));
            	img.setTitre(rs.getString("titre"));
            	img.setDescription(rs.getString("description"));		            
            	img.setHauteur(rs.getInt("hauteur"));		            
            	img.setLargeur(rs.getInt("largeur"));		  
            	img.setFileName(rs.getString("fileName"));     
            	img.setAlbum(rs.getLong("album"));
            }
            ps.close();
            connection.close();
        } 
		catch (SQLException e) 
		{
		     e.printStackTrace();	      
		}		 
		return img;
	}

	@Override
	public Collection<Image> findAllImageOf(Album album) 
	{
		ArrayList<Image> imgs = new ArrayList<>();
		Connection connection = null;
		try 
     	{
        	connection = SingletonConnection.getConnection();
    	    PreparedStatement ps = connection.prepareStatement("select * from image where album = ?;");
            ps.setLong(1, album.getId());
    	    ResultSet rs= ps.executeQuery();
            while (rs.next())
            {
            	Image alb = new Image();
            	alb.setId(rs.getLong("id"));
            	alb.setTitre(rs.getString("titre"));
            	alb.setDescription(rs.getString("description"));		            
            	alb.setHauteur(rs.getInt("hauteur"));		            
            	alb.setLargeur(rs.getInt("largeur"));		  
            	alb.setFileName(rs.getString("fileName"));
            	alb.setAlbum(album.getId());	 
            	imgs.add(alb);
            }
            ps.close();
            connection.close();
        } 
		catch (SQLException e) 
		{
		     e.printStackTrace();	      
		}	
		
		return imgs;
	}

}
