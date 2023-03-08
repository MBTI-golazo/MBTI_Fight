package team.spring.springmbti.character.service;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import team.spring.springmbti.character.vo.CharacterInfo;

public class CharacterService {

	public String fight(CharacterInfo c, CharacterInfo d, String userName, String userName2) {
		String cName = userName;
		String dName = userName2;
		
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		double adDmg = 0;
		double apDmg = 0;
		double critical = 0;
		double miss = 0;
		for(int cnt = 0; cnt <= 2; cnt++) {
			Logger log = LogManager.getLogger("case3");
			// 속도비교 도전자가빠를때만 선공 같을경우도 방어자 선공
			if (c.getCharacterSpeed() > d.getCharacterSpeed()) {
				log.debug(cName + "선공!");
				adDmg = c.getCharacterAD() * (random.nextDouble() + 0.25);
				log.debug("초기데미지" + adDmg);
				critical = random.nextInt(80) + c.getCharacterCritical();
				if (critical >= 100) {
					log.debug("크리티컬수치가" + critical + "이므로");
					log.debug("크리티컬공격!");
					adDmg = adDmg * 2;
				}
				adDmg = adDmg - (d.getCharacterADDefence()/2);
				log.debug("상대 방어력" + d.getCharacterADDefence());
				log.debug("최종데미지" + adDmg);
				if (adDmg <= 0) {
					log.debug("최종데미지가 0 이하이므로 데미지 0처리");
				}
				log.debug("공격자 적중률" + c.getCharacterHitRate());
				miss = d.getCharacterAvoidanceRate() + random.nextInt(100) - c.getCharacterHitRate();
				log.debug("회피율 : " + miss);
				if (miss  >= 100) {
					log.debug("회피수치 100이상이므로 miss!");
					adDmg = 0;
				}
				d.setCharacterHP(d.getCharacterHP() - adDmg);
				log.debug(dName + "잔여 HP" + d.getCharacterHP());
			} else {
				log.debug(dName + "선공");
			}
		}
		return null;
	}

}
