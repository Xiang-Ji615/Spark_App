package main.java.spark.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Rest")
public class RestfulController {

	@RequestMapping(value="AssignTask", method=RequestMethod.POST)
	public ResponseEntity<?> AssignTaskPost(@RequestParam(name="class") String classId, @RequestParam(name="student") String studentId, @RequestParam(name="selected") String selected, HttpServletRequest  request){
		System.out.println("Class: "+classId + ", Student: "+studentId);
		System.out.println(selected);
		String base = request.getLocalName();
		System.out.println(base);
		return ResponseEntity.ok("/Web/Student?class="+classId+"&student="+studentId);
	}
}
