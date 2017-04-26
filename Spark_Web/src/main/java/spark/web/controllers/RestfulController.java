package main.java.spark.web.controllers;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import main.java.spark.bo.bo.IAssigningTaskBo;
import main.java.spark.bo.bo.IStudentBo;
import main.java.spark.bo.bo.ITaskBo;
import main.java.spark.dao.dao.StudentDaoImp;
import main.java.spark.dao.model.AssigningTask;

@RestController
@RequestMapping("Rest")
public class RestfulController {
	
	
	@Autowired
	IAssigningTaskBo assigningTaskBo;
	
	@Autowired
	ITaskBo taskBO;
	
	@Autowired
	IStudentBo studentBo;
	
	Gson gson = new Gson();

	@RequestMapping(value="AssignTask", method=RequestMethod.POST)
	public ResponseEntity<?> AssignTaskPost(@RequestParam(name="class") String classId, @RequestParam(name="student") String studentId, @RequestParam(name="selected") String selected, @RequestParam(name="duedate") String duedate, HttpServletRequest  request){
		System.out.println("Class: "+classId + ", Student: "+studentId);
		System.out.println(selected);
		String base = request.getLocalName();
		System.out.println(base);
		Type type = new TypeToken<Map<String, String>>(){}.getType();
		Map<String, String> selectedMap = gson.fromJson(selected, type);
		Map<String, String> duedateMap = gson.fromJson(duedate, type);
		Iterator it = selectedMap.entrySet().iterator();
		 while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        AssigningTask aTask = new AssigningTask(taskBO.findById(Integer.valueOf(pair.getKey().toString())), studentBo.findById(Integer.valueOf(studentId)), 0, 0, duedateMap.get(pair.getKey()));
		        assigningTaskBo.saveOrUpateAssigningTask(aTask);
		 }

		
		return ResponseEntity.ok("../Web/Student?class="+classId+"&student="+studentId);
	}
}
