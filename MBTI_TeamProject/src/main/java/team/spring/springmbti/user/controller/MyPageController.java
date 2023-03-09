package team.spring.springmbti.user.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import team.spring.springmbti.character.service.CharacterService;
import team.spring.springmbti.character.vo.CharacterInfo;
import team.spring.springmbti.user.service.UserService;
import team.spring.springmbti.user.vo.User;

@Controller
@SessionAttributes(value= { "myCharacter" })
public class MyPageController {
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private UserService service;
	
	@Autowired
	private CharacterService cService;
	
	@ModelAttribute("myCharacter")
	public CharacterInfo createCharacter() {
		CharacterInfo character = new CharacterInfo();
		return character;
	}
	
	@GetMapping(value = "myPage")
	public String myPage(HttpSession session, Model model, @ModelAttribute("myCharacter") CharacterInfo character) {
		
		User user = (User)session.getAttribute("myUser");
		int userNum = service.getUserNum(user);
		int userCharacterNum = service.getUserCharacterNum(userNum);
		character = cService.getCharacter(userCharacterNum);
		log.debug(character);
		model.addAttribute("myNum", userNum);
		
		model.addAttribute("myCharacter", character);
		
		return "userMyPage";
	}

}