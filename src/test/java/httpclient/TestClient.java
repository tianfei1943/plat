package httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
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
	public void testGet() throws ClientProtocolException, IOException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("http://localhost/easy/demo/datagrid/datagrid_data.json");
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
		//参数
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("param1", "value1"));
		formparams.add(new BasicNameValuePair("param2", "value2"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
		System.out.println("请求参数："+EntityUtils.toString(entity));
		//post
		HttpPost httppost = new HttpPost("http://localhost/easy/demo/datagrid/datagrid_data.json");
		httppost.setEntity(entity);

		HttpResponse response = httpclient.execute(httppost);
		HttpEntity responseEntity = response.getEntity();
		if (responseEntity != null) {
			
			long len = responseEntity.getContentLength();
			if (len != -1 && len < 2048) {
				System.out.println(EntityUtils.toString(responseEntity));
			} else {
				
			}
		}
	}

}
