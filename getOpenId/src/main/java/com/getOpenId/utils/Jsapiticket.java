package com.getOpenId.utils;

import java.sql.SQLException;

import com.getOpenId.model.AccessToken;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class Jsapiticket {

	public final static String jsticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	private AccessTokenService accessTokenService = new AccessTokenService();
	
	/**
	 * 获取jsapi_ticket
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public AccessToken getJsticket() throws SQLException {
		
//		String requestUrl = jsticket_url.replace("ACCESS_TOKEN", accessTokenService.refreshAccessToken().getAccessToken());
		String requestUrl = jsticket_url.replace("ACCESS_TOKEN", accessTokenService.refreshAccessToken().getAccesstoken());
		
		JSONObject jsonObject = HttpsRequestUtil.httpRequest(requestUrl, "GET", null);
		AccessToken accessToken = new AccessToken();
		// 如果请求成功
		if (null != jsonObject) {
			try {
				System.out.println("accessToken是:"+jsonObject.toString()+", accesstoken = "+jsonObject.getString("ticket"));
				accessToken.setAccesstoken(jsonObject.getString("ticket"));
				accessToken.setExpires_in(jsonObject.getString("expires_in"));
			} catch (JSONException e) {
				 // 获取token失败
				System.out.println("获取getJsticket失败 errcode:{} errmsg:{}"+ jsonObject.getInt("errcode")+ jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}
	
}
