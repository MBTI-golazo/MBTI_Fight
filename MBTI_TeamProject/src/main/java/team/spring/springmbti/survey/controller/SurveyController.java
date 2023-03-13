package team.spring.springmbti.survey.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import team.spring.springmbti.survey.service.SurveyService;
import team.spring.springmbti.user.vo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
//@SessionAttributes(value= {"myUser"})
@RequestMapping(value = "survey")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyservice;
	
	Logger log = LogManager.getLogger("case3");
	
	@PostMapping("surveyone")
	public String handler(Model model) {
		log.debug("handler1() s호출 - 일단연습");
		
		
		return "survey/survey1";
	}
	
	@PostMapping("surveytwo")
	public String handler1(Model model) {
		log.debug("handler1() 호출 - 일단연습");
		
		
		return "survey/survey2";
	}
	
	@PostMapping("surveythree")
	public String handler2(Model model) {
		log.debug("handler1() 호출 - 일단연습");
		
		
		return "survey/survey3";
	}
	
	@PostMapping("surveyfour")
	public String handler3(Model model) {
		log.debug("handler1() 호출 - 일단연습");
		
		
		return "survey/survey4";
	}
	
	@GetMapping("surveyone1")
	public void handler01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	@PostMapping("surveytwo1")
	public void handler02(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	@PutMapping("sbutton1")
	public void handler001(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("handler1() 호출 - 프로그레스바시작");
		request.setCharacterEncoding("UTF-8");
		int qone = Integer.parseInt(request.getParameter("qone"));
		int qtwo = Integer.parseInt(request.getParameter("qtwo"));
		int qthree = Integer.parseInt(request.getParameter("qthree"));
		int qfour = Integer.parseInt(request.getParameter("qfour"));
		int qfive = Integer.parseInt(request.getParameter("qfive"));
		int qtotal = qone + qtwo + qthree + qfour + qfive;
		int total = qtotal - 15;
		int nqtotal = total*-1;
		// String email = new String("seaha1223@naver.com");
		
		
		
		User user = new User();
		user = (User)session.getAttribute("myUser");
		// user.setUserEmail(email);
		user.setUserI(nqtotal);
		user.setUserE(qtotal);
		log.debug("괜찮슴");
		
		surveyservice.updateScore(user);
		
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("qone", qone);
		String find = gson.toJson(jsonObject);
		response.getWriter().write(find);
	}
	
	
	
}
