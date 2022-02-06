package domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor 
public class Image 
{
	private Long id;
	private String titre;
	private String description;
	private int hauteur;
	private String fileName;
	private int largeur;
	private Long album;
	
	
	
}
