package metier.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.UtilisateurDao;
import domain.Utilisateur;
import metier.IAdminService;
import utils.FormUtils;
import utils.PasswordUtils;

public class AdminService implements IAdminService
{
	private static final String id_field = "id";
	private static final String nom_field = "nom";
	private static final String prenom_field = "prenom";
	private static final String login_field = "login";
	private static final String password_field = "password";
	private static final String password_bis_field = "password_bis";

	/**********************************************************************/
	
	private Utilisateur utilisateur;
	private UtilisateurDao userDAO;
	
	public AdminService()
	{
		this.userDAO = new UtilisateurDao();
	}
	
	@Override
	public boolean addUser(HttpServletRequest request, String key)
	{		
		String nom = FormUtils.getParameter(request, nom_field);
		String prenom = FormUtils.getParameter(request, prenom_field);
		String login = FormUtils.getParameter(request, login_field);
		String password = FormUtils.getParameter(request, password_field);
		String password_bis = FormUtils.getParameter(request, password_bis_field);
		
		utilisateur = new Utilisateur(nom, prenom, login, password, "ADMIN");
		
		if (FormUtils.validateFields(request, nom_field, prenom_field, login_field, password_field, password_bis_field)
				&& FormUtils.validatePassword(request, password, password_bis))// Le formulaire a bien été rempli
		{
			// On crypte le mot de passe
			utilisateur.setPassword(PasswordUtils.hashPassword(password, key));
			if (userDAO.ajouter(utilisateur))		// Ajout reussi
			{
				request.setAttribute("succes","Ajout effectué avec succès!");
				return true;
			}
			else		// Erreur
			{
				request.setAttribute("erreur","Echec de l'ajout!");
				return false;
			}			
		}
		// Le formulaire n'a pas ete bien rempli
		request.setAttribute("erreur","Veuillez bien remplir le formulaire!");
		return false;
	}
	
	@Override
	public boolean updateUser(HttpServletRequest request, String key)
	{		
		String id = FormUtils.getParameter(request, id_field);
		String nom = FormUtils.getParameter(request, nom_field);
		String prenom = FormUtils.getParameter(request, prenom_field);
		String login = FormUtils.getParameter(request, login_field);
		String password = FormUtils.getParameter(request, password_field);
		String password_bis = FormUtils.getParameter(request, password_bis_field);
		
		utilisateur = new Utilisateur(nom, prenom, login, password);
		
		if (FormUtils.validateFields(request, id_field, nom_field, prenom_field, login_field, password_field, password_bis_field)
				&& FormUtils.validatePassword(request, password, password_bis)) // Le formulaire a bien été rempli
		{
			if(id.matches("[0-9]+")) // Il s'agit d'une modification
			{
				utilisateur.setId(Long.parseLong(id));
				if (userDAO.modifier(utilisateur))	// Modification reussie
				{
					request.setAttribute("succes","Modification effectuée avec succès!");
					return true;
				}
				else 	// Erreur 
				{
					request.setAttribute("erreur","Echec de la modification!");
					return false;
				}
			}
		}
		// Le formulaire n'a pas ete bien rempli
		request.setAttribute("erreur","Veuillez bien remplir le formulaire!");
		return false;
	}
	
	@Override
	public ArrayList<Utilisateur> findAllUsers()
	{
		return userDAO.lister();
	}
	
	@Override
	public Utilisateur findById(Long id)
	{
		return userDAO.get(id);
	}
	
	@Override
	public boolean deleteUser(Long id)
	{
		return userDAO.supprimer(id);
	}
}
