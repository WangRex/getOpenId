/**   
* @Title: AccessTokenService.java 
* @Package com.getOpenId.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年7月29日 上午11:13:13 
* @version V1.0   
*/
package com.getOpenId.utils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.getOpenId.constant.Constants;
import com.getOpenId.model.AccessToken;

import net.sf.json.JSONObject;

/** 
* @ClassName: AccessTokenService 
* @Description: (这里用一句话描述这个类的作用) 
* @author Rex 
* @date 2017年7月29日 上午11:13:13 
*  
*/
public class AccessTokenService {

	private static Logger log = LoggerFactory.getLogger(AccessTokenService.class);

	public void update(AccessToken access){
		// 发送请求参数
		Map<String, String> map = new HashMap<String, String>();
		map.put("accesstoken", access.getAccesstoken());
		map.put("date", access.getDate());
		map.put("expires_in", String.valueOf(access.getExpires_in()));
		map.put("id", "1");
		JSONObject itemJSONObj = JSONObject.fromObject(map);
		String url = Constants.URL.TRANSFER_URL + "get/updatetoken";
		JSONObject rtnJson = HttpPostJson.jsonpost(url, itemJSONObj);
		log.debug("修改accessToken结果: " + rtnJson);
	}
	public void updateTicket(AccessToken access){
		// 发送请求参数
		Map<String, String> map = new HashMap<String, String>();
		map.put("accesstoken", access.getAccesstoken());
		map.put("date", access.getDate());
		map.put("expires_in", String.valueOf(access.getExpires_in()));
		map.put("id", "2");
		JSONObject itemJSONObj = JSONObject.fromObject(map);
		String url = Constants.URL.TRANSFER_URL + "get/updatetoken";
		JSONObject rtnJson = HttpPostJson.jsonpost(url, itemJSONObj);
		log.debug("修改ticket结果: " + rtnJson);
	}
	
	/**
	 * 在获取AccessToken时，系统自动检测jsticket是否过期，过期自动获取
	 * @return
	 */
	public AccessToken refreshAccessToken(){
		String url = Constants.URL.TRANSFER_URL + "/get/selecttoken?id=1";
		JSONObject rtnJson = HttpPostJson.httpGet(url);
		AccessToken access = new AccessToken();
		access.setAccesstoken(rtnJson.getString("accesstoken"));
		access.setExpires_in(rtnJson.getString("expires_in"));
		access.setDate(rtnJson.getString("date"));
		if(!DateUtils.checkdateover2(access.getDate())){
			try {
				AccessToken accessa = AccessTokenUtil.getrefurshAccessToken(Constants.WX.APPID, Constants.WX.SECRET);
				access.setAccesstoken(accessa.getAccesstoken());
				access.setExpires_in(access.getExpires_in());
				access.setDate(DateUtils.getNowTime());
				update(access);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return access;
	}
	
	/**
	 * 在获取jsticket时，系统自动检测jsticket是否过期，过期自动获取刷新
	 * @return
	 */
	public AccessToken refreshJsapiticket(){
		String url = Constants.URL.TRANSFER_URL + "/get/selecttoken?id=2";
		log.debug("refreshJsapiticket方法开始, url = " + url);
		JSONObject rtnJson = HttpPostJson.httpGet(url);
		log.debug("refreshJsapiticket方法返回json = " + rtnJson);
		AccessToken access = new AccessToken();
		Jsapiticket jsapiticket = new Jsapiticket();
		access.setAccesstoken(rtnJson.getString("accesstoken"));
		access.setExpires_in(rtnJson.getString("expires_in"));
		access.setDate(rtnJson.getString("date"));
		if(!DateUtils.checkdateover2(access.getDate())){
			try {
				AccessToken accessa = jsapiticket.getJsticket();
				access.setAccesstoken(accessa.getAccesstoken());
				access.setExpires_in(access.getExpires_in());
				access.setDate(DateUtils.getNowTime());
				updateTicket(access);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return access;
	}
	
	public JSONObject getSignature(String requrl){
		JSONObject json = new JSONObject();
		
		String nonce_str="5K8264ILTKCH16CQ2502SI8ZNMTM67VS";//随机字符串
		String url=requrl;//请求的url(当前网页的URL，不包含#及其后面部分)
		String timestamp=System.currentTimeMillis() / 1000 + "";//时间戳
		String jsapi_ticket = this.refreshJsapiticket().getAccesstoken();
		
		/*sign生成签名*/
		String result = "jsapi_ticket="+jsapi_ticket+"&noncestr="+nonce_str+"&timestamp="+timestamp+"&url="+url;
		String signature = SHA1.encode(result);
		json.put("timestamp", timestamp);
		json.put("nonceStr", nonce_str);
		json.put("signature",signature);
		return json;
	}
}
