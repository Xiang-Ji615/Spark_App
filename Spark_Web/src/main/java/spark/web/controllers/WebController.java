package main.java.spark.web.controllers;

import java.util.Optional;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.spark.bo.bo.IAssigningTaskBo;
import main.java.spark.bo.bo.IClassBo;
import main.java.spark.bo.bo.IStudentBo;
import main.java.spark.bo.bo.ITaskBo;
import main.java.spark.dao.model.AssigningTask;


@Controller
@RequestMapping(value="Web")
public class WebController {
	
	@Autowired
	IClassBo classBo;
	
	@Autowired
	IStudentBo studentBo;
	
	@Autowired
	IAssigningTaskBo assigningTaskBo;
	
	@Autowired
	ITaskBo taskBo;
	
	
	@RequestMapping(value="Index", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String Index(ModelMap map, HttpServletRequest request){
		System.out.println(request.getSession().getAttribute("role"));
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
		map.addAttribute("classId", classId);
		map.addAttribute("studentId", studentId);
		map.addAttribute("taskId", taskId);
		
		return "Web/StudentTask";
	}
	
	@RequestMapping(value="UpdateMark", method=RequestMethod.POST, produces=MediaType.ALL_VALUE)
	public String UpdateMark(@RequestParam(name="class") String classId, @RequestParam(name="student") String studentId, @RequestParam(name="task") String taskId, String mark, String completed){
		System.out.println(mark);
		AssigningTask assigningTask = assigningTaskBo.findById(Integer.valueOf(taskId));
		assigningTask.setMark(Integer.valueOf(mark));
		if(!StringUtils.isEmpty(mark) && Integer.valueOf(mark) > 0)
			assigningTask.setCompleted(1);
		else
			assigningTask.setCompleted(0);	
		completed = Optional.ofNullable(completed).orElse("off");
		assigningTask.setCompleted(completed.equals("on")?1:0);
		assigningTaskBo.saveOrUpateAssigningTask(assigningTask);
		return "redirect:../Web/Student?class="+classId+"&student="+studentId;
	}
	
	@RequestMapping(value="AssignTask", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String AssignTask(@RequestParam(name="class") String classId, @RequestParam(name="student") String studentId, ModelMap map){
		System.out.println("Class: "+classId + ", Student: "+studentId);
		map.addAttribute("classId", classId);
		map.addAttribute("studentId", studentId);
		map.addAttribute("tasks", taskBo.listTasks());
		map.addAttribute("dueDate", "20171215");
		return "Web/AssignTask";
	}
	



}
