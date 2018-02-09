/**   
* @Title: PersonalUtils.java 
* @Package com.getOpenId.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年7月25日 下午11:38:31 
* @version V1.0   
*/
package com.getOpenId.utils;

/** 
* @ClassName: PersonalUtils 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Rex 
* @date 2017年7月25日 下午11:38:31 
*  
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.getOpenId.constant.Constants;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class PersonalUtils {
	private static Logger log = LoggerFactory.getLogger(PersonalUtils.class);

	public static String getopenid(String code) {
		String openid = null;
		String requestUrl = Constants.access_token_url.replace("APPID", Constants.WX.APPID).replace("SECRET", Constants.WX.SECRET).replace("CODE", code);

		JSONObject jsonObject = HttpsRequestUtil.httpRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				openid = jsonObject.getString("openid");
			} catch (JSONException e) {
				// 获取token失败
				log.error("获取person失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		log.debug("openid = " + openid);
		return openid;
	}

	public static JSONObject getopenidjson(String code) {
		JSONObject openid = new JSONObject();
		String requestUrl = Constants.access_token_url.replace("APPID", Constants.WX.APPID).replace("SECRET", Constants.WX.SECRET).replace("CODE", code);

		JSONObject jsonObject = HttpsRequestUtil.httpRequest(requestUrl, "GET", null);
		System.out.println(jsonObject.toString());
		try {
			if (jsonObject.getString("openid").length() > 0) {
				openid.put("openid", jsonObject.getString("openid"));
				openid.put("access_token", jsonObject.getString("access_token"));
				openid.put("status", "success");
			} else {
				openid.put("status", "false");
			}
		} catch (JSONException e) {
			// 获取token失败
			log.error("获取person失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			openid.put("status", "false");
		}
		return openid;
	}

	public static JSONObject getUser(String code) {
		String openid = null;
		String requestUrl = Constants.access_token_url.replace("APPID", Constants.WX.APPID).replace("SECRET", Constants.WX.SECRET).replace("CODE", code);
		String requestUrla = "";
		JSONObject jsonObject = HttpsRequestUtil.httpRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				openid = jsonObject.getString("openid");
			} catch (JSONException e) {
				// 获取token失败
				log.error("获取person失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		return jsonObject;
	}

}
