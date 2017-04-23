package main.java.spark.web.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="Web")
public class WebController {
	
	@RequestMapping(value="Index", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String Index(ModelMap map){
		return "Web/Index";
	}
	
	@RequestMapping(value="Class", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String ClassDetail(@RequestParam(name="class") String className, ModelMap map){
		return "Web/ClassDetail";
	}
	
	@RequestMapping(value="Student", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String StudentDetail(@RequestParam(name="class") String className, @RequestParam(name="student") String studenId, ModelMap map){
		return "Web/StudentDetail";
	}
	
	@RequestMapping(value="Task", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String StudentTask(@RequestParam(name="class") String className, @RequestParam(name="student") String studenId,@RequestParam(name="task") String taskId, ModelMap map){
		return "Web/StudentTask";
	}
	

}
