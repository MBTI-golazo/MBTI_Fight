package team.spring.springmbti.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.springmbti.user.dao.UserDao;
import team.spring.springmbti.user.vo.User;

@Service
public class UserService {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private UserDao dao;
	
	public int getUserNum(User user) {
		
		int userNum = dao.getUserNum(user.getUserEmail());
		
		return userNum;
	}

	public int getUserCharacterNum(int userNum) {
		
		int userCharacterNum = dao.getUserCharacterNum(userNum);
		
		return userCharacterNum;
	}

}
