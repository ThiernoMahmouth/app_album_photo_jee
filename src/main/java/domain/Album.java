package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Album 
{
	private Long id;
	private String nom;
	private boolean isPrivate;
	private LocalDate date;
	private LocalTime heure;
	Collection<Image> images;
	private Utilisateur proprietaire;
	private Collection<Utilisateur> consulteurs;
	
	public Album(String nom)
	{
		this.nom = nom;
		this.isPrivate = true;
		this.date = LocalDate.now();
		this.heure = LocalTime.now();
	}
	public Album(String nom, boolean isPrivate)
	{
		this.nom = nom;
		this.isPrivate = isPrivate;
		this.date = LocalDate.now();
		this.heure = LocalTime.now();
	}
}
