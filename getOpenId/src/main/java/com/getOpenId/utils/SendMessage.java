/**   
* @Title: SendMessage.java 
* @Package com.getOpenId.utils 
* @Description: (用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年8月17日 下午7:33:25 
* @version V1.0   
*/
package com.getOpenId.utils;

import net.sf.json.JSONObject;

/**
 * @ClassName: SendMessage
 * @Description: (这里用一句话描述这个类的作用)
 * @author Rex
 * @date 2017年8月17日 下午7:33:25
 * 
 */
public class SendMessage {

	public String urlSetIndustry = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
	public String urlGetIndustry = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
	public String urlGetTemplateId = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
	public String urlSend = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	private AccessTokenService accessTokenService = new AccessTokenService();

	public JSONObject SetIndustry(String industry_id1, String industry_id2) {
		String accessToken = accessTokenService.refreshAccessToken().getAccesstoken();
		urlSetIndustry = urlSetIndustry.replace("ACCESS_TOKEN", accessToken);
		JSONObject map = new JSONObject();
		map.put("industry_id1", industry_id1);
		map.put("industry_id2", industry_id2);
		JSONObject jsonObject = HttpsRequestUtil.httpRequest(urlSetIndustry, "POST", map.toString());
		return jsonObject;
	}
	public JSONObject GetIndustry() {
		String accessToken = accessTokenService.refreshAccessToken().getAccesstoken();
		urlGetIndustry = urlGetIndustry.replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = HttpsRequestUtil.httpRequest(urlGetIndustry, "GET", null);
		return jsonObject;
	}
	public JSONObject GetTemplateId(String template_id_short) {
		String accessToken = accessTokenService.refreshAccessToken().getAccesstoken();
		urlGetTemplateId = urlGetTemplateId.replace("ACCESS_TOKEN", accessToken);
		JSONObject map = new JSONObject();
		map.put("template_id_short", template_id_short);
		JSONObject jsonObject = HttpsRequestUtil.httpRequest(urlGetTemplateId, "GET", map.toString());
		return jsonObject;
	}
	public JSONObject Send(JSONObject map) {
		String accessToken = accessTokenService.refreshAccessToken().getAccesstoken();
		urlSend = urlSend.replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = HttpsRequestUtil.httpRequest(urlSend, "GET", map.toString());
		System.out.println(jsonObject);
		return jsonObject;
	}

	/**
	 * @Title: main @Description: (这里用一句话描述这个方法的作用) @param @param args
	 * 设定文件 @return void 返回类型 @throws
	 */
	public static void main(String[] args) {
		SendMessage sm = new SendMessage();
//		sm.SetIndustry();
//		sm.GetIndustry();
//		sm.GetTemplateId();
		JSONObject json = new JSONObject();
		json.put("touser", "ovrp5jstB3GrH6gRGlBkUojiGrpo");
		json.put("template_id", "5na8_B5V3P7uPljpIVAvtXtwq1R61LrwC9Gu8yIlOuU");
		json.put("url", "");
		json.put("topcolor", "#FF0000");
		JSONObject jsonData = new JSONObject();
		JSONObject jsonDataFirst = new JSONObject();
		jsonDataFirst.put("value", "尊敬的客户：您已成功绑定中国光大银行微信银行");
		jsonData.put("first", jsonDataFirst);
		JSONObject jsonDatakeyword1 = new JSONObject();
		jsonDatakeyword1.put("value", "2017-08-19");
		jsonData.put("keyword1", jsonDatakeyword1);
		JSONObject jsonDatakeyword2 = new JSONObject();
		jsonDatakeyword2.put("value", "2017-08-19");
		jsonData.put("keyword2", jsonDatakeyword2);
		JSONObject jsonDatakeyword3 = new JSONObject();
		jsonDatakeyword3.put("value", "测试");
		jsonData.put("keyword3", jsonDatakeyword3);
		JSONObject jsonDataRemark = new JSONObject();
		jsonDataRemark.put("value", "即刻享受微信银行服务吧！");
		jsonData.put("remark", jsonDataRemark);
		json.put("data", jsonData);
		sm.Send(json);
	}

}
