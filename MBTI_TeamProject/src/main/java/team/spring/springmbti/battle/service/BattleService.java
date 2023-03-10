package team.spring.springmbti.battle.service;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import team.spring.springmbti.battle.vo.BattleLog;
import team.spring.springmbti.character.vo.CharacterInfo;
import team.spring.springmbti.user.vo.User;

@Service
public class BattleService {

	public double adAttack(CharacterInfo a, CharacterInfo d, String aUser, String dUser) {
		
		Logger log = LogManager.getLogger("case3");
		
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		double dmg = 0;
		double critical = 0;
		double miss = 0;
		
		dmg = a.getCharacterAD() * (random.nextDouble() + 0.5);
		log.debug("초기데미지 : " + dmg);
		critical = random.nextInt(80) + a.getCharacterCritical();
		if (critical >= 100) {
			log.debug("크리티컬point가 : " + critical + "이므로");
			log.debug("크리티컬공격!");
			dmg = dmg * 2;
		}
		dmg = dmg - (d.getCharacterADDefence()/2);
		log.debug("상대 방어력" + d.getCharacterADDefence());
		log.debug("최종데미지" + dmg);
		if (dmg <= 0) {
			log.debug("최종데미지가 0 이하이므로 데미지 0처리");
		}
		log.debug("공격자 적중률" + a.getCharacterHitRate());
		miss = d.getCharacterAvoidanceRate() + random.nextInt(100) - a.getCharacterHitRate();
		if (miss  >= 100) {
			log.debug("회피point 100이상이므로 miss!");
			dmg = 0;
		}
		return dmg;
	}
	
	public double apAttack(CharacterInfo a, CharacterInfo d, String aUser, String dUser) {
		
		Logger log = LogManager.getLogger("case3");
		
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		double dmg = 0;
		double critical = 0;
		double miss = 0;
		
		dmg = a.getCharacterAP() * (random.nextDouble() + 0.5);
		log.debug("초기데미지 : " + dmg);
		critical = random.nextInt(80) + a.getCharacterCritical();
		if (critical >= 100) {
			log.debug("크리티컬point가 : " + critical + "이므로");
			log.debug("크리티컬공격!");
			dmg = dmg * 2;
		}
		dmg = dmg - (d.getCharacterAPDefence()/2);
		log.debug("상대 방어력" + d.getCharacterAPDefence());
		log.debug("최종데미지" + dmg);
		if (dmg <= 0) {
			log.debug("최종데미지가 0 이하이므로 데미지 0처리");
		}
		log.debug("공격자 적중률" + a.getCharacterHitRate());
		miss = d.getCharacterAvoidanceRate() + random.nextInt(100) - a.getCharacterHitRate();
		if (miss  >= 100) {
			log.debug("회피point 100이상이므로 miss!");
			dmg = 0;
		}
		return dmg;
	}
	public BattleLog battle(CharacterInfo challengeCharacter, CharacterInfo defenceCharacter, User challengeUser,
			User defenceUser) {
		
		String challengerName = challengeUser.getUserName();
		String defenderName = defenceUser.getUserName();
		User winner = null;
		User loser = null;
		for(int cnt = 0; cnt <= 10; cnt++) {
			Logger log = LogManager.getLogger("case3");
			// 속도비교 도전자가빠를때만 선공 같을경우도 방어자 선공
			if (challengeCharacter.getCharacterSpeed() > defenceCharacter.getCharacterSpeed()) {
				log.debug(challengeUser + "턴!");
				double adDmg = adAttack(challengeCharacter, defenceCharacter, challengerName, defenderName);
				defenceCharacter.setCharacterHP(defenceCharacter.getCharacterHP() - adDmg);
				if (defenceCharacter.getCharacterHP() <= 0) {
					log.debug(defenderName + " 의 잔여 HP 가 0이하이므로 대전을 종료합니다");
					log.debug(challengerName + " 승리 !");
					winner = challengeUser;
					loser = defenceUser;
					break;
				}
				log.debug(defenderName + "잔여 HP" + defenceCharacter.getCharacterHP());
				double apDmg = apAttack(challengeCharacter, defenceCharacter, challengerName, defenderName);
				defenceCharacter.setCharacterHP(defenceCharacter.getCharacterHP() - apDmg);
				if (defenceCharacter.getCharacterHP() <= 0) {
					log.debug(defenderName + " 의 잔여 HP 가 0이하이므로 대전을 종료합니다");
					log.debug(challengerName + " 승리 !");
					winner = challengeUser;
					loser = defenceUser;
					break;
				}
				log.debug(defenderName + "잔여 HP" + defenceCharacter.getCharacterHP());
				
				
			} else {
				log.debug(defenceUser + "턴!");
				double adDmg = adAttack(defenceCharacter, challengeCharacter, defenderName, challengerName);
				challengeCharacter.setCharacterHP(challengeCharacter.getCharacterHP() - adDmg);
				log.debug(challengeUser + "잔여 HP" + challengeCharacter.getCharacterHP());
				if (defenceCharacter.getCharacterHP() <= 0) {
					log.debug(challengerName + " 의 잔여 HP 가 0이하이므로 대전을 종료합니다");
					log.debug(defenderName + " 승리 !");
					winner = defenceUser;
					loser = challengeUser;
					break;
				}
				log.debug(challengerName + "잔여 HP" + challengeCharacter.getCharacterHP());
				double apDmg = apAttack(defenceCharacter, challengeCharacter, defenderName, challengerName);
				challengeCharacter.setCharacterHP(challengeCharacter.getCharacterHP() - apDmg);
				log.debug(challengeUser + "잔여 HP" + challengeCharacter.getCharacterHP());
				if (defenceCharacter.getCharacterHP() <= 0) {
					log.debug(challengerName + " 의 잔여 HP 가 0이하이므로 대전을 종료합니다");
					log.debug(defenceUser + " 승리 !");
					winner = defenceUser;
					loser = challengeUser;
					break;
				}
				log.debug(challengerName + "잔여 HP" + challengeCharacter.getCharacterHP());
			}
		}
		// 대결종료 승자, 패자 가지고 db 처리
		return null;
	}

}
