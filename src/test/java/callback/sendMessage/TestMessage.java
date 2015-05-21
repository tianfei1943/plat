package callback.sendMessage;

import org.junit.Test;


public class TestMessage {

	@Test
	public void test(){
		Local local = new Local("1+1 等于几？",new Remote());
		local.sendMessage();
	}
	
}
