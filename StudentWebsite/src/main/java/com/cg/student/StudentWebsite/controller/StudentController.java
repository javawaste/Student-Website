package com.cg.student.StudentWebsite.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import com.cg.student.StudentWebsite.pojo.Topic;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class StudentController {

	@RequestMapping(value = "/topics", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public String getAllEmployeesJSON(Model model) {
		
		final String uri = "http://localhost:8080/topics.json";

		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject(uri, String.class);
		model.addAttribute("topics", result);
		List<Topic> topics = new Gson().fromJson(result, new TypeToken<List<Topic>>() {
		}.getType());
		
		return "Student.jsp";
	}
}