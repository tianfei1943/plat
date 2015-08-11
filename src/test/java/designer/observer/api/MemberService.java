package designer.observer.api;

import designer.observer.domain.Member;

public interface MemberService {
	/**
	 * 会员注册
	 */
	public void register(Member member);
	/**
	 * 删除会员
	 * @param member
	 */
	public void delete(Member member);

}
