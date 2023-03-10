package team.spring.springmbti.survey.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.springmbti.user.vo.User;





@Repository
public class SurveyDaoImpl implements SurveyDao {
	
	@Autowired
	private SqlSession session;
	
	Logger log = LogManager.getLogger("case3");
	
	@Override
	public int updateSurvey(User user) {
		int result = session.update("mySurvey.updatesurveyone",user);
		if(result==1) {
			//session.commit();
			log.debug("성공!");
		} else {
			log.debug("실패!");
		}
		//session.close();
		return result;
	}

}
