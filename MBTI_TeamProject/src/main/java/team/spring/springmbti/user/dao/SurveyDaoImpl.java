package team.spring.springmbti.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.springmbti.user.vo.Member;



@Repository
public class SurveyDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public Member idCheck(String memberId) {
		
		Member member = session.selectOne("myMember.checkid",memberId);
		
		return member;
	}

}
