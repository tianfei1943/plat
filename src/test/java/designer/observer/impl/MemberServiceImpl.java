package designer.observer.impl;

import java.util.Observable;

import designer.observer.api.MemberService;
import designer.observer.domain.Member;

public class MemberServiceImpl extends Observable implements MemberService {

	@Override
	public void register(Member member) {
		System.out.println("会员注册成功");
		super.setChanged();
		super.notifyObservers(member);
		super.deleteObservers();
	}

	@Override
	public void delete(Member member) {

	}

}
