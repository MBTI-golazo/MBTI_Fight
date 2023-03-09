package team.spring.springmbti.user.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import team.spring.springmbti.user.service.SurveyService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SurveyController2 {
	
	@Autowired
	private SurveyService surveyservice;
	
	Logger log = LogManager.getLogger("case3");
	
	@PostMapping("surveytwo")
	public String handler() {
		log.debug("handler1() 호출 - 일단연습");
		
		
		return "survey/survey2";
	}
	
	@PostMapping("surveytwo1")
	public String handler1() {
		log.debug("handler1() 호출 - 일단연습");
		
		
		return "survey/survey2";
	}
	

	
}
