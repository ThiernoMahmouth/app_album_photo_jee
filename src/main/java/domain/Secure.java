package domain;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;
import utils.PasswordUtils;

@Data 
public class Secure 
{
	private String salt;
	private LocalDate date;
	private LocalTime time;
	
	public Secure()
	{	
		this.salt = PasswordUtils.generateSalt(PasswordUtils.KEY_LENGTH);
		this.date = LocalDate.now();
		this.time = LocalTime.now();
	}
	
}
