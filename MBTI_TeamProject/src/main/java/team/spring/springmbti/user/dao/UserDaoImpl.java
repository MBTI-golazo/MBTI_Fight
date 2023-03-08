package team.spring.springmbti.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.springmbti.user.vo.User;



@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession session;
	
	Logger log = LogManager.getLogger("case3");
	
	@Override
	public User emailCheck(String userEmail) {
		
		User user = session.selectOne("myUser.checkEmail",userEmail);
		
		return user;
	}

	@Override
	public int insertUser(User user) {

		int count = session.insert("myUser.insertUser", user);
		
		if(count==1) {
			session.commit();
			log.debug("유저 등록 커밋 성공");
		}else {
			log.debug("유저 등록 실패, 롤백");
		}
		
		return count;
	}

	
}
