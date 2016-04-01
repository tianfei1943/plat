package httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestClient {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet1() throws ClientProtocolException, IOException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(
				"http://localhost/easy/demo/datagrid/datagrid_data.json");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		if (entity != null) {

			StringBuffer sb = new StringBuffer();
			InputStream content = entity.getContent();
			byte[] arr = new byte[1024];
			int i = 0;
			while((i = content.read(arr)) != -1 ){
				sb.append(new String(arr,0,i));
				//System.out.println(new String(arr));
			}
			
			System.out.println(sb.toString());
			
		}
	}
	
	
	@Test
	public void testGet() throws ClientProtocolException, IOException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(
				"http://192.168.3.62/easy/demo/datagrid/datagrid_data.json");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		if (entity != null) {

			long len = entity.getContentLength();
			if (len != -1 && len < 2048) {
				System.out.println(EntityUtils.toString(entity));
			} else {

			}
		}
	}

	@Test
	public void testPost() throws ClientProtocolException, IOException {
		HttpClient httpclient = new DefaultHttpClient();
		// 参数
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("param1", "value1"));
		formparams.add(new BasicNameValuePair("param2", "value2"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams,
				"UTF-8");
		System.out.println("请求参数：" + EntityUtils.toString(entity));
		// post
		HttpPost httppost = new HttpPost(
				"http://localhost/easy/demo/datagrid/datagrid_data.json");
		httppost.setEntity(entity);

		// 响应控制器
		ResponseHandler<String> handler = new ResponseHandler<String>() {
			public String handleResponse(HttpResponse response)
					throws ClientProtocolException, IOException {
				StringBuffer sb = new StringBuffer();
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream content = entity.getContent();
					byte[] arr = new byte[1024];
					int i = 0;
					while((i = content.read(arr)) != -1 ){
						sb.append(new String(arr,0,i));
					}
					System.out.println(sb.toString());
				}
				return sb.toString();
			}
		};
		
		String res = httpclient.execute(httppost, handler);
		System.out.println(res);
	}

}
