package team.spring.springmbti.battle.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team.spring.springmbti.battle.service.BattleService;
import team.spring.springmbti.character.service.CharacterService;
import team.spring.springmbti.character.vo.CharacterInfo;
import team.spring.springmbti.user.vo.User;

@Controller
public class BattleController {

	Logger log = LogManager.getLogger("case3");
	
	@GetMapping(value = "battle")
	public String battle(Model model) {
		log.debug("싸우기");
		BattleService service = new BattleService();
		
		CharacterInfo challengeCharacter = new CharacterInfo(1, 100, 11, 9, 6, 4, 11, 10, 10, 30, 5);
		CharacterInfo defenceCharacter = new CharacterInfo(2, 100, 9, 11, 4, 6, 10, 10, 10, 30 ,5);
		
		User challengeUser = new User();
		challengeUser.setUserName("도전자");
		User defenceUser = new User();
		defenceUser.setUserName("방어자");
		String result = service.battle(challengeCharacter, defenceCharacter, challengeUser, defenceUser);
		return null;
	}
}
