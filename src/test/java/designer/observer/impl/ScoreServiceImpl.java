package designer.observer.impl;

import designer.observer.api.ScoreService;
import designer.observer.domain.Member;

public class ScoreServiceImpl implements ScoreService {

	@Override
	public void addMemberScore(Member member) {
		member.setScore(100);
		System.out.println("会员注册时添加会员积分--"+member.getScore());
		
	}

	@Override
	public void deleteMemberScore(Member member) {
		// TODO Auto-generated method stub
		
	}



}
