package metier;

import javax.servlet.http.HttpServletRequest;

public interface IAuthService 
{
	boolean login(HttpServletRequest request, String key);
	boolean register(HttpServletRequest request, String key);
}
