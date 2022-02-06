package metier;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import domain.Utilisateur;

public interface IAdminService 
{
	public boolean addUser(HttpServletRequest request, String key);
	public boolean updateUser(HttpServletRequest request, String key);
	public boolean deleteUser(Long id);
	public Collection<Utilisateur> findAllUsers();
	public Utilisateur findById(Long id);

}
