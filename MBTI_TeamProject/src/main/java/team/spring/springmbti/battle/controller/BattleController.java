package team.spring.springmbti.battle.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import team.spring.springmbti.battle.service.BattleService;
import team.spring.springmbti.battle.vo.BattleLog;
import team.spring.springmbti.character.service.CharacterService;
import team.spring.springmbti.character.vo.CharacterInfo;
import team.spring.springmbti.user.vo.User;

@Controller
@RequestMapping(value = "battle")
public class BattleController {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	BattleService service;
	
	@GetMapping(value = "battle")
	public String battle(Model model) {
		log.debug("싸우기");
		
		CharacterInfo challengeCharacter = new CharacterInfo(1, 100, 11, 9, 6, 4, 11, 10, 10, 30, 5);
		CharacterInfo defenceCharacter = new CharacterInfo(2, 100, 9, 11, 4, 6, 10, 10, 10, 30 ,5);
		
		User challengeUser = new User();
		challengeUser.setUserName("도전자");
		User defenceUser = new User();
		defenceUser.setUserName("방어자");
		BattleLog battleLog = service.battle(challengeCharacter, defenceCharacter, challengeUser, defenceUser);
		return null;
	}
	
	@GetMapping(value = "searchBattleUser")
	public String searchBattleUser(HttpSession session) {
		
		User user = (User)session.getAttribute("myUser");
		// 내캐릭터 받아오기
		log.debug(user);
		return "searchBattleUser";
	}
	
	@GetMapping(value = "prepareBattle")
	public String prepareBattle(Model model) {
		User user = (User)model.getAttribute("myUser");
		log.debug(user);
		log.debug(user.getUserName() + "대결준비");
		return null;
	}
}
