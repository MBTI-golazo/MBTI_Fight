package team.spring.springmbti.user.dao;

import team.spring.springmbti.user.vo.Member;

public interface MemberDao {

	Member idCheck(String memberId);
	
}
