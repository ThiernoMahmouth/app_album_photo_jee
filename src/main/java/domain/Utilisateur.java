package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @AllArgsConstructor @NoArgsConstructor
public class Utilisateur 
{
	@Id	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom, prenom, login, password, role;
	
	public Utilisateur(String nom, String prenom, String login, String password)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}
	public Utilisateur(String nom, String prenom, String login, String password, String role)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.role = role;
	}

}
