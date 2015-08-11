package designer.observer.api;

import designer.observer.domain.Member;

public interface ScoreService {
	
	/**
	 * 注册会员，给会员添加初始积分
	 * @param member
	 */
	public void addMemberScore(Member member);
	/**
	 * 删除会员积分
	 * @param member
	 * @param score
	 */
	public void deleteMemberScore(Member member);
	
}
