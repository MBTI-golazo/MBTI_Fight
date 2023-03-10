package team.spring.springmbti.survey.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.springmbti.survey.dao.SurveyDao;
import team.spring.springmbti.user.vo.User;





@Service
public class SurveyService {
	
	@Autowired
	private SurveyDao dao;
	
	Logger log = LogManager.getLogger("case3");
	
	public void updateScore(User user) {
		int result = dao.updateSurvey(user);
		if(result == 1) {
			log.debug("점수 저장 성공");
		} else {
			log.debug("점수 저장 실패");
		}
	}

}
