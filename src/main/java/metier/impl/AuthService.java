package metier.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.Utilisateur;
import dao.UtilisateurDao;
import utils.FormUtils;
import utils.PasswordUtils;

public class AuthService 
{
	private static final String prenom_field = "prenom";
	private static final String nom_field = "nom";
	private static final String login_field = "login";
	private static final String password_field = "password";
	private static final String password_bis_field = "password_bis";

	private UtilisateurDao userDAO;
	
	public AuthService()
	{
		this.userDAO = new UtilisateurDao();
	}
	
	public boolean login(HttpServletRequest request, String key)
	{
		String login = FormUtils.getParameter(request, login_field);
		String password = FormUtils.getParameter(request, password_field);
		
		Utilisateur user = null;
		HttpSession session = request.getSession();
		String passerEncrypted = PasswordUtils.hashPassword("passer", key);
		if ("admin".equals(login) && PasswordUtils.verifyPassword(password,passerEncrypted, key))
		{
			user = new Utilisateur(1L, "ADMIN", "ADMIN", "admin", "", "ADMIN");
		}
		else 
		{
			user = userDAO.findByLogin(login);
			if (user != null && !PasswordUtils.verifyPassword(password,user.getPassword(), key))
			{
				user = null;
			}	
		}
		if (user != null)
		{
			session.setAttribute("currentUser", user);
			return true;
		}
		return false;
	}
	
	public boolean register(HttpServletRequest request, String key)
	{
		String prenom = FormUtils.getParameter(request, prenom_field);
		String nom = FormUtils.getParameter(request, nom_field);
		String login = FormUtils.getParameter(request, login_field);
		String password = FormUtils.getParameter(request, password_field);
		String password_bis = FormUtils.getParameter(request, password_bis_field);
		
		if (FormUtils.validateFields(request, nom_field, prenom_field, login_field, password_field, password_bis_field)
				&& FormUtils.validatePassword(request, password, password_bis))
		{
			Utilisateur utilisateur = new Utilisateur(nom, prenom, login, password, "USER");
			// On crypte le mot de passe
			utilisateur.setPassword(PasswordUtils.hashPassword(password, key));
			if(userDAO.ajouter(utilisateur)) // Ajout reussi
			{
				request.setAttribute("succes","inscription effectuée avec succès!");
				return true;
			}
			else 		// Erreur
			{
				request.setAttribute("erreur","Erreur lors de l'inscription!");
				return false;
			}
		}
		else
		{
			request.setAttribute("erreur","Veuillez bien remplir le formulaire!");
			return false;
		}
	}
}
