package main.java.spark.web.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GlobalWebController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	public String redirectToWebIndex() {
		return "redirect:Web/Index";
	}
	
}
