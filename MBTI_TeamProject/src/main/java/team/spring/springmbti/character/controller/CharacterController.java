package team.spring.springmbti.character.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CharacterController {

	Logger log = LogManager.getLogger("case3");
	@PostMapping(value = "charactor")
	public String createCharacter(Model model) {
		log.debug("캐릭터생성");
		return "home";
	}
	
	@GetMapping(value = "fight")
	public String fight(Model model) {
		log.debug("싸우기");
		return null;
	}
}
