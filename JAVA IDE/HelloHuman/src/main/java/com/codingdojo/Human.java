package com.codingdojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class Human {
	@RequestMapping("/")
	public String human(@RequestParam(name="name",required=false) String name,@RequestParam(name="lastname",required=false) String lastname)
	{
		if(name==null)
		{
			return "<h1>Hello Human!</h1> <br> <h4>Welcome to SpringBoot!</h4>";
		}
		
		else
		{
			if(lastname==null)
			{
				return "<h1>Hello" +name+ "</h1> <br> <h4>Welcome to SpringBoot!</h4>";
			}
			
			else
			{
				return "<h1>Hello " + name + " " + lastname + "!</h1> <br> <h4>Welcome to Springboot!</h4>";
			}
				
		}
	}
	

}
