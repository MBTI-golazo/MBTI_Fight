package team.spring.springmbti.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.springmbti.user.vo.User;



@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public User idCheck(String userId) {
		
		User user = session.selectOne("myUser.checkid",userId);
		
		return user;
	}

}
