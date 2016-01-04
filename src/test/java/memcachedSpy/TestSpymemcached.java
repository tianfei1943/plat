package memcachedSpy;

import net.spy.memcached.MemcachedClient;

public class TestSpymemcached extends Thread {

	private int count;

	public TestSpymemcached(int i) {
		count = i;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("begin:" + System.currentTimeMillis());
		for (int i = 0; i < 1; i++) {
			TestSpymemcached test = new TestSpymemcached(i);
			test.start();
		}
		System.out.println("end:" + System.currentTimeMillis());
	}

	public void run() {
		System.out.println(count + "start:" + System.currentTimeMillis());
		MemcachedClient c = MemCachedManager.getInstance();
		if(c == null){
			System.out.println("链接失败");
			return;
		}
		for (int i = 0; i < 1; i++) {
			// Store a value (async) for one hour
			String key = count + "000" + i;
			c.set(key, 3600, "Hello World " + count + "000" + i+ "!");
			// Retrieve a value (synchronously).
			Object myObject = c.get(key);
			System.out.println(myObject);
		}
		System.out.println(count + "end:" + System.currentTimeMillis());
	}
}
