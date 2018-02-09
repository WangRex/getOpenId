package com.getOpenId.utils;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.getOpenId.model.AccessToken;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * 获得微信api的accessToken
 * @author Administrator
 *
 */
@Component("accessTokenUtil")
public class AccessTokenUtil {
	
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private AccessTokenService accessTokenService = new AccessTokenService();
	/**
	 * 获取access_token
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return
	 * @throws SQLException 
	 */
	public AccessToken getAccessToken(String appid, String appsecret) throws SQLException {
		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		
		JSONObject jsonObject = HttpsRequestUtil.httpRequest(requestUrl, "GET", null);
		AccessToken accessToken = new AccessToken();
		// 如果请求成功
		if (null != jsonObject) {
			try {
				System.out.println("accessToken是:"+jsonObject.toString()+"accesstoken"+jsonObject.getString("access_token"));
				accessToken.setAccesstoken(jsonObject.getString("access_token"));
				accessToken.setExpires_in(jsonObject.getString("expires_in"));
				accessTokenService.update(accessToken);
			} catch (JSONException e) {
				 // 获取token失败
				System.out.println("获取token失败 errcode:{} errmsg:{}"+ jsonObject.getInt("errcode")+ jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}
	
	public static AccessToken getrefurshAccessToken(String appid, String appsecret) throws SQLException {
		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		
		JSONObject jsonObject = HttpsRequestUtil.httpRequest(requestUrl, "GET", null);
		AccessToken accessToken = new AccessToken();
		// 如果请求成功
		if (null != jsonObject) {
			try {
				System.out.println("accessToken是:"+jsonObject.toString()+"accesstoken"+jsonObject.getString("access_token"));
				accessToken.setAccesstoken(jsonObject.getString("access_token"));
				accessToken.setExpires_in(jsonObject.getString("expires_in"));
			} catch (JSONException e) {
				 // 获取token失败
				System.out.println("获取token失败 errcode:{} errmsg:{}"+ jsonObject.getInt("errcode")+ jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}
	
	
}
