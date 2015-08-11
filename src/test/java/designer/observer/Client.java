package designer.observer;

import designer.observer.domain.Member;
import designer.observer.impl.MemberServiceImpl;
import designer.observer.impl.ScoreServiceImpl;
import designer.observer.listener.MemberRegisterListener;

public class Client {

	public static void main(String[] args) {
		Member member = new Member();
		MemberServiceImpl ms = new MemberServiceImpl();
		MemberRegisterListener mrl =new MemberRegisterListener();
		mrl.setScoreService(new ScoreServiceImpl());
		ms.addObserver(mrl);
		ms.register(member);
		ms.deleteObservers();
	}

}
