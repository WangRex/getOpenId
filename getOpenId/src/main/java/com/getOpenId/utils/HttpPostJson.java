/**   
* @Title: HttpPostJson.java 
* @Package com.getOpenId.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年7月26日 上午10:08:33 
* @version V1.0   
*/
package com.getOpenId.utils;

/** 
* @ClassName: HttpPostJson 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Rex 
* @date 2017年7月26日 上午10:08:33 
*  
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.charset.Charset;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.getOpenId.controller.GetOpenId;

import net.sf.json.JSONObject;

public class HttpPostJson {

	private static Logger log = LoggerFactory.getLogger(GetOpenId.class);

	public static JSONObject jsonpost(String url, JSONObject json) {

		log.debug("发送post方法开始，json = " + json);
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/json");
		post.addHeader("Authorization", "Basic YWRtaW46");
		String result = "";
		try {
			StringEntity s = new StringEntity(json.toString(), "utf-8");
			s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			post.setEntity(s);
			// 发送请求
			HttpResponse httpResponse = client.execute(post);
			// 获取响应输入流
			InputStream inStream = httpResponse.getEntity().getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "utf-8"));
			StringBuilder strber = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null)
				strber.append(line + "\n");
			inStream.close();

			result = strber.toString();
			log.debug("result = " + result);

			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				log.debug("请求服务器成功，做相应处理");
			} else {
				log.debug("请求服务端失败");
			}

		} catch (Exception e) {
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally {
		}
		JSONObject resultJson = JSONObject.fromObject(result);
		return resultJson;
	}

	/**
	 * 发送get请求
	 * 
	 * @param url
	 *            路径
	 * @return
	 */
	public static JSONObject httpGet(String url) {
		// get请求返回结果
		JSONObject jsonResult = null;
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			// 发送get请求
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			log.debug("get请求结果:" + response);
			/** 请求发送成功，并得到响应 **/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				/** 读取服务器返回过来的json字符串数据 **/
				String strResult = EntityUtils.toString(response.getEntity());
				log.debug("get请求结果, strResult : " + strResult);
				/** 把json字符串转换成json对象 **/
				jsonResult = JSONObject.fromObject(strResult);
				log.debug("get请求结果, jsonResult : " + jsonResult);
				url = URLDecoder.decode(url, "UTF-8");
			} else {
				log.error("get请求提交失败:" + url);
			}
		} catch (IOException e) {
			log.error("get请求提交失败:" + url, e);
		}
		return jsonResult;
	}

}