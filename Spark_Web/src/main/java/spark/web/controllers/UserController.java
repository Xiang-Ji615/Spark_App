package main.java.spark.web.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="User")
public class UserController {

	
	@RequestMapping(value="Login", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String UserLogin(ModelMap map){
		return "Login/Login";
	}
}
