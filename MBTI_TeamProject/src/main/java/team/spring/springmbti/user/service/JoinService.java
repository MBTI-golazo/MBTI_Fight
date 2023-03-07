package team.spring.springmbti.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.springmbti.user.dao.UserDao;
import team.spring.springmbti.user.vo.User;



@Service
public class JoinService {
	
	@Autowired
	private UserDao dao;
	
	Logger log = LogManager.getLogger("case3");
	
	public boolean idCheck(String userId) {
		
		User user = dao.idCheck(userId);
		
		boolean canUse = false;
		
		if(user==null)
		{
			log.debug("중복된 아이디 없음");
			canUse=true;
		}else {
			log.debug("아이디 중복");
		}
		
		return canUse;
	}

}
