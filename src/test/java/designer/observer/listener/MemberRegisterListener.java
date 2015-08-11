package designer.observer.listener;

import java.util.Observable;
import java.util.Observer;

import designer.observer.api.ScoreService;
import designer.observer.domain.Member;

public class MemberRegisterListener implements Observer {

	
	private ScoreService scoreService;
	
	@Override
	public void update(Observable o, Object arg) {
		Member member = (Member)arg;
		this.scoreService.addMemberScore(member);
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
}
