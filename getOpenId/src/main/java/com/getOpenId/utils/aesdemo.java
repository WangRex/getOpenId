package com.getOpenId.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


public class aesdemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("openid", "111");
		map.put("terid", "123");
		map.put("merid", "155");
		map.put("kv", "0.12");
		map.put("cardphoto1", "/loc/1.png");
		map.put("cardphoto2", "/loc/2.png");
		map.put("businessphoto", "/loc/3.jpg");
		map.put("businessname", "大发");
		map.put("businessadress", "啊佛牌");
		map.put("recommendperson", "噶放");
		/*JSONObject jsonmap = JSONObject.fromObject(map);
		// // 加密
		byte[] encryptResult = AES.encrypt(jsonmap.toString(), AES.AesPd);
		String encryptResultStr = StrChange.parseByte2HexStr(encryptResult);
		// 发json
		JSONObject postjson = new JSONObject();
		postjson.put("concent", encryptResultStr);
		System.out.println("发送的Json：" + postjson);
		
		
		String msg = encryptResultStr;
		// 解密
		byte[] decryptFrom = StrChange.parseHexStr2Byte(msg);
		byte[] decryptResult = AES.decrypt(decryptFrom, AES.AesPd);
		// 解密后的concent
		String dtconcent = new String(decryptResult, "UTF-8");
		// 转成Json解析
		JSONObject resjson1 = JSONObject.fromObject(dtconcent);
		System.out.println("解密的msg：" + resjson1);*/
	}

}
