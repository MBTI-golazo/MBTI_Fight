package team.spring.springmbti.character.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import team.spring.springmbti.character.service.CharacterService;
import team.spring.springmbti.character.vo.CharacterInfo;
import team.spring.springmbti.user.vo.User;

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
		CharacterService service = new CharacterService();
		
		CharacterInfo c = new CharacterInfo(1, 100, 11, 9, 6, 4, 11, 10, 10, 30, 5);
		CharacterInfo d = new CharacterInfo(2, 100, 9, 11, 4, 6, 10, 10, 10, 30 ,5);
		
		User u1 = new User();
		u1.setUserName("도전자");
		User u2 = new User();
		u2.setUserName("방어자");
		String result = service.fight(c, d, u1.getUserName(), u2.getUserName());
		return null;
	}
}
