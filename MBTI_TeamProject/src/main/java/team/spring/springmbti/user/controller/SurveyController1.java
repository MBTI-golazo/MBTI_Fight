package team.spring.springmbti.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import team.spring.springmbti.user.service.SurveyService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "survey")
public class SurveyController1 {
	
	@Autowired
	private SurveyService surveyservice;
	
	Logger log = LogManager.getLogger("case3");
	
	@PostMapping("surveyone")
	public String handler(Model model) {
		log.debug("handler1() 호출 - 일단연습");
		
		
		return "survey/survey1";
	}
	
	
	
	@PostMapping("surveyone1")
	public void handler1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("handler1() 호출 - 프로그레스바시작");
		request.setCharacterEncoding("UTF-8");
		int qnum = Integer.parseInt(request.getParameter("qnum"));
		int onum = Integer.parseInt(request.getParameter("onum"));

		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("qnum", qnum);
		jsonObject.addProperty("onum", onum);
		String find = gson.toJson(jsonObject);
		response.getWriter().write(find);
	}	
	
	@PostMapping("surveyone3")
	public void handler3(HttpServletRequest request3, HttpServletResponse response3) throws ServletException, IOException {
		log.debug("handler1() 호출 - 프로그레스바시작");
		request3.setCharacterEncoding("UTF-8");
		int qnum3 = Integer.parseInt(request3.getParameter("qnum"));
		int onum3 = Integer.parseInt(request3.getParameter("onum"));

		Gson gson3 = new Gson();
		JsonObject jsonObject3 = new JsonObject();
		jsonObject3.addProperty("qnum3", qnum3);
		jsonObject3.addProperty("onum3", onum3);
		String find3 = gson3.toJson(jsonObject3);
		response3.getWriter().write(find3);
	}
}
