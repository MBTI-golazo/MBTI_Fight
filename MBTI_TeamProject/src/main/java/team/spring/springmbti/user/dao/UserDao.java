package team.spring.springmbti.user.dao;

import team.spring.springmbti.user.vo.User;

public interface UserDao {

	User emailCheck(String userEmail);

	int insertUser(User user);

	int getUserNum(String string);

	int getUserCharacterNum(int userNum);

	int deleteUser(String userEmail);
	
}
