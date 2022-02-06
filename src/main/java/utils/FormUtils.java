package utils;

import javax.servlet.http.HttpServletRequest;

public class FormUtils 
{
	public static String getParameter(HttpServletRequest request, String param)
	{
		String value = request.getParameter(param);
		if (value == null || value.trim().isEmpty())
		{
			return null;
		}
		return value.trim();
	}
	
	public static boolean validateFields(HttpServletRequest request, String ...fields)
	{
		boolean isValide = true;
		for (String field : fields)
		{ 
			if (getParameter(request, field) == null)
			{
				isValide = false;
				break;
			}
		}
		return isValide;
	}
	
	public static boolean validatePassword(HttpServletRequest request, String passwd, String passwd_bis)
	{
		boolean isValide = false;
		
		if (passwd != null && passwd.equals(passwd_bis) )
		{
			isValide = true;			
		}
		return isValide;
	}
}

