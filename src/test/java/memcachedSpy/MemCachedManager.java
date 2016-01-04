package memcachedSpy;

import java.io.IOException;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

public class MemCachedManager {
	private static MemcachedClient c;

	public static synchronized MemcachedClient getInstance() {
		if (c == null) {
			try {
				c = new MemcachedClient(
						AddrUtil.getAddresses("10.211.55.8:11211"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return c;
	}
}
