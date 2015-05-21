package callback.template;

import org.junit.Test;

public class TestCallBack {

	private  HibernateTemplate template = new HibernateTemplate();

	@Test
	public void test() {
		this.template.save();
	}

}
