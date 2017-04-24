package main.java.spark.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.spark.bo.bo.IAssigningTaskBo;
import main.java.spark.bo.bo.IClassBo;
import main.java.spark.bo.bo.IStudentBo;


@Controller
@RequestMapping(value="Web")
public class WebController {
	
	@Autowired
	IClassBo classBo;
	
	@Autowired
	IStudentBo studentBo;
	
	@Autowired
	IAssigningTaskBo assigningTaskBo;
	
	
	@RequestMapping(value="Index", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String Index(ModelMap map){
		map.addAttribute("classes", classBo.listClasses());
		return "Web/Index";
	}
	
	@RequestMapping(value="Class", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String ClassDetail(@RequestParam(name="class") String classId, ModelMap map){
		map.addAttribute("students", studentBo.listStudentsInClass(classId));
		map.addAttribute("classId", classId);
		return "Web/ClassDetail";
	}
	
	@RequestMapping(value="Student", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String StudentDetail(@RequestParam(name="class") String classId, @RequestParam(name="student") String studentId, ModelMap map){
		map.addAttribute("tasks", assigningTaskBo.listAssigningTasksWithStudentId(studentId));
		map.addAttribute("classId", classId);
		map.addAttribute("studentId", studentId);
		return "Web/StudentDetail";
	}
	
	@RequestMapping(value="Task", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String StudentTask(@RequestParam(name="class") String classId, @RequestParam(name="student") String studentId,@RequestParam(name="task") String taskId, ModelMap map){
		map.addAttribute("taskDetail", assigningTaskBo.findById(Integer.valueOf(taskId)));
		return "Web/StudentTask";
	}
	

}
